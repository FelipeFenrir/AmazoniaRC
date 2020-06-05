package br.com.amazoniarc.newbuy;

import static br.com.amazoniarc.newbuy.enums.ServicoFreteEnum.SEDEX_SEM_CONTRATO;

import br.com.amazoniarc.newbuy.enums.TipoMidia;
import br.com.amazoniarc.newbuy.interfaces.Desconto;
import br.com.amazoniarc.newbuy.interfaces.Frete;
import br.com.amazoniarc.newbuy.interfaces.Pagamento;
import br.com.amazoniarc.newbuy.model.Cesta;
import br.com.amazoniarc.newbuy.model.Cliente;
import br.com.amazoniarc.newbuy.model.Endereco;
import br.com.amazoniarc.newbuy.model.Filme;
import br.com.amazoniarc.newbuy.model.Revista;
import br.com.amazoniarc.newbuy.model.Pedido;
import br.com.amazoniarc.newbuy.model.Produto;
import br.com.amazoniarc.newbuy.service.ServiceVenda;
import br.com.amazoniarc.newbuy.business.venda.AdicionarDesconto;
import br.com.amazoniarc.newbuy.business.venda.AdicionarTributo;
import br.com.amazoniarc.newbuy.business.pagamento.CartaoCredito;
import br.com.amazoniarc.newbuy.business.confirmacao.PorEmail;
import br.com.amazoniarc.newbuy.business.venda.ConfirmarPedido;
import br.com.amazoniarc.newbuy.business.venda.ObterFrete;
import br.com.amazoniarc.newbuy.business.desconto.AplicarDesconto;
import br.com.amazoniarc.newbuy.business.venda.EfetuarPagamento;
import br.com.amazoniarc.newbuy.enums.CategoriaFilme;
import br.com.amazoniarc.newbuy.enums.CategoriaLeitura;
import br.com.amazoniarc.newbuy.enums.TipoEndereco;
import br.com.amazoniarc.newbuy.business.frete.FreteCorreios;
import br.com.amazoniarc.newbuy.interfaces.ConfimacaoCompra;
import br.com.amazoniarc.newbuy.interfaces.Tributo;
import br.com.amazoniarc.newbuy.model.CupomDesconto;
import br.com.amazoniarc.newbuy.business.tributo.ICMS;
import br.com.amazoniarc.newbuy.factory.Fabrica;
import java.text.NumberFormat;
import java.util.ArrayList;

import static java.util.Arrays.asList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/**
 * Classe principal.
 *
 * @author felipe.batista
 */
public class NewBuy {

    private static final String DESCONTAI = "DESCONTAI";

    /**
     * Metodo de Inicio.
     *
     * @param args
     */
    public static void main(String[] args) {
        Produto javamagazine = preparaRevistaTeste();
        Produto vingadores = preparaFilmeTeste();
        Produto videogame = preparaProdutoTeste();
        Cliente cliente = preparaClienteTeste();

        System.out.println("O cliente "
                .concat(cliente.getNome())
                .concat(" esta selecionando produtos..."));

        Cesta cestaDeCompras = new Cesta();
        cestaDeCompras.addItem(javamagazine);
        cestaDeCompras.addItem(vingadores);
        cestaDeCompras.addItem(videogame);

        Pedido pedido = new Pedido("WEB0238", cestaDeCompras, cestaDeCompras.getVlTotal());
        System.out.println("O cliente gerou o pedido: ".concat(pedido.getCodigo()));
        System.out.println("No valor total de: ".concat(
                NumberFormat.getCurrencyInstance().format(
                        pedido.getValorTotal())).concat(
                " (Sem Frete, Desconto e Tributos)."));

        Desconto desconto = new AplicarDesconto();

        Tributo tributo = new ICMS(pedido);

        Frete frete = new FreteCorreios(
                enderecoOrigem(),
                cliente.getEnderecoEntrega(),
                cestaDeCompras,
                SEDEX_SEM_CONTRATO.getCodigo().get(0));

        Pagamento pagamento = new CartaoCredito();
        ConfimacaoCompra confirmacaoCompra = new PorEmail(cliente, pedido);

        ServiceVenda venda = new ServiceVenda();
        venda.checkout(cestaDeCompras,
                asList(
                        new AdicionarDesconto(pedido, desconto, DESCONTAI),
                        new AdicionarTributo(pedido, tributo),
                        new ObterFrete(pedido, frete),
                        new EfetuarPagamento(pedido, pagamento),
                        new ConfirmarPedido(confirmacaoCompra)
                )
        );
    }

    private static Produto preparaProdutoTeste() {
        Fabrica<Produto> factory = Fabrica.getInstance(Produto.class);
        Produto produto = factory.getInstance();
        produto.setPreco(90.00);
        produto.setAltura(0.0);
        produto.setComprimento(0.0);
        produto.setLargura(0.0);
        produto.setDiametro("0");
        produto.setPeso("0.3");
        return produto;
    }

    private static Filme preparaFilmeTeste() {
        Fabrica<Filme> factory = Fabrica.getInstance(Filme.class);
        Filme filme = factory.getInstance();
        filme.setPreco(90.00);
        filme.setAltura(0.0);
        filme.setComprimento(0.0);
        filme.setTipomidia(TipoMidia.MIDIA_DIGIAL);
        filme.setLargura(0.0);
        filme.setDiametro("0");
        filme.setPeso("0.3");
        filme.setCategoria(CategoriaFilme.ACAO);        
        return filme;
    }

    private static Revista preparaRevistaTeste() {
        Fabrica<Revista> factory = Fabrica.getInstance(Revista.class);
        Revista revista = factory.getInstance();
        revista.setPreco(22.00);
        revista.setAltura(0.32);
        revista.setComprimento(0.24);
        revista.setTipomidia(TipoMidia.FISICO);
        revista.setLargura(0.02);
        revista.setDiametro("0");
        revista.setPeso("0.5");
        revista.setCuponsDeDesconto(criaCuponsDesconto());
        revista.setCategoria(CategoriaLeitura.INFORMACAO);
        revista.setCodigoISBN(12344567844L);
        return revista;
    }

    private static Cliente preparaClienteTeste() {
        Endereco entrega = new Endereco("R. Lilases", "Balneario Cidade Atlantica", 15, "Guaruja", "11441-330");
        Endereco cobranca = new Endereco("R. Lilases", "Balneario Cidade Atlantica", 15, "Guaruja", "11441-330");
        Map enderecosCLiente = new EnumMap(TipoEndereco.class);
        enderecosCLiente.put(TipoEndereco.ENTREGA, entrega);
        enderecosCLiente.put(TipoEndereco.COBRANCA, cobranca);

        Cliente cliente = new Cliente();
        cliente.setNome("Felipe de Andrade Batista");
        cliente.setEmail("feandrade.it@gmail.com");
        cliente.setEnderecos(enderecosCLiente);
        return cliente;
    }

    private static Endereco enderecoOrigem() {
        Endereco origem = new Endereco(
                "Avenida Tambore", "Alphaville", 267, "Barueri", "06460-000");
        return origem;
    }

    private static List<CupomDesconto> criaCuponsDesconto() {
        CupomDesconto cupom = new CupomDesconto(DESCONTAI, 50);
        List listaDeCupons = new ArrayList();
        listaDeCupons.add(cupom);
        return listaDeCupons;
    }
}
