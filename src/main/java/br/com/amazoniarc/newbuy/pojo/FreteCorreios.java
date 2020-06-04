package br.com.amazoniarc.newbuy.pojo;

import java.net.URISyntaxException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import br.com.amazoniarc.newbuy.enums.TipoMidia;
import br.com.amazoniarc.newbuy.interfaces.Frete;
import br.com.amazoniarc.newbuy.model.Cesta;
import br.com.amazoniarc.newbuy.model.EmMidia;
import br.com.amazoniarc.newbuy.model.Endereco;
import br.com.amazoniarc.newbuy.model.Produto;
import java.io.IOException;
import java.text.NumberFormat;
import org.apache.http.ParseException;

/**
 * Representação do Frete pelos Correios do Brasil.
 *
 * @author felipe.batista
 */
public class FreteCorreios implements Frete {

    private final Endereco origem;
    private final Endereco destino;
    private final Cesta cesta;
    private final String codigoFrete;

    /**
     * Construtor personalizado.
     *
     * @param origem
     * @param destino
     * @param cesta
     * @param codigoFrete
     */
    public FreteCorreios(Endereco origem, Endereco destino, Cesta cesta,
            String codigoFrete) {
        this.origem = origem;
        this.destino = destino;
        this.cesta = cesta;
        this.codigoFrete = codigoFrete;
    }

    /**
     * Método para calculo de Frete dos Correios.
     * @return Valor Frete.
     */
    public double calcular() {
        Double frete = 0d;

        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();

            for (Produto produto : cesta.getItens()) {
                if (verificarMidia(produto)) {
                    HttpGet request = new HttpGet(linkWebService(origem, destino, produto).build());
                    CloseableHttpResponse response = httpClient.execute(request);
                    String xml = EntityUtils.toString(response.getEntity());
                    frete += Double.valueOf(
                            xml.substring(
                                    xml.indexOf("<Valor>") + 7,
                                    xml.indexOf("</Valor>"))
                                    .replace(",", "."));
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        } catch (URISyntaxException e) {
            System.out.println(e.getMessage());
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("O Frete total é: ".concat(
                NumberFormat.getCurrencyInstance().format(frete)));
        return frete;
    }

    private boolean verificarMidia(Produto produto) {
        if (produto instanceof EmMidia) {
            return ((EmMidia) produto).getTipomidia() != TipoMidia.MIDIA_DIGIAL;
        }
        return false;
    }

    /**
     * Constroi a url do Web Service dos Correios.
     * @param deOrigem
     * @param paraDestino
     * @param produto
     * @return
     * @throws URISyntaxException
     */
    private URIBuilder linkWebService(Endereco deOrigem, Endereco paraDestino,
            Produto produto) throws URISyntaxException {

        URIBuilder builder = new URIBuilder("http://ws.correios.com.br/calculador/CalcPrecoPrazo.aspx")
                .addParameter("sCepOrigem", deOrigem.getCep())
                .addParameter("sCepDestino", paraDestino.getCep())
                .addParameter("nVlPeso", produto.getPeso())
                .addParameter("nVlComprimento", produto.getComprimento().toString())
                .addParameter("nVlAltura", produto.getAltura().toString())
                .addParameter("nVlLargura", produto.getLargura().toString())
                .addParameter("nVlDiametro", produto.getDiametro())
                .addParameter("nCdFormato", "1")
                .addParameter("sCdMaoPropria", "N")
                .addParameter("sCdMaoPropria", "N")
                .addParameter("nVlValorDeclarado", "0")
                .addParameter("nCdServico", codigoFrete)
                .addParameter("nCdEmpresa", "")
                .addParameter("sDsSenha", "")
                .addParameter("StrRetorno", "xml");
        return builder;
    }

}
