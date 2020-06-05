package br.com.amazoniarc.newbuy.model;

import java.util.List;

/**
 * Modelo de representação de um Produto.
 *
 * @author felipe.batista
 */
public class Produto extends Identificador {

    private String descricao;
    private Double preco;
    private String peso;
    private Double comprimento;
    private Double altura;
    private Double largura;
    private String diametro;
    private List<CupomDesconto> cuponsDeDesconto;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public Double getComprimento() {
        return comprimento;
    }

    public void setComprimento(Double comprimento) {
        this.comprimento = comprimento;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getLargura() {
        return largura;
    }

    public void setLargura(Double largura) {
        this.largura = largura;
    }

    public String getDiametro() {
        return diametro;
    }

    public void setDiametro(String diametro) {
        this.diametro = diametro;
    }

    public List<CupomDesconto> getCuponsDeDesconto() {
        return cuponsDeDesconto;
    }

    public void setCuponsDeDesconto(List<CupomDesconto> cuponsDeDesconto) {
        this.cuponsDeDesconto = cuponsDeDesconto;
    }

    /**
     * Builder com medidas.
     *
     * @param pesoProduto
     * @param comprimentoProduto
     * @param alturaProduto
     * @param diametroProduto
     * @return Produto.
     */
    Produto com(String pesoProduto, Double comprimentoProduto,
            Double alturaProduto, String diametroProduto) {
        this.setPeso(pesoProduto);
        this.setComprimento(comprimentoProduto);
        this.setAltura(alturaProduto);
        this.setDiametro(diametroProduto);
        return this;
    }

    /**
     * Adição de Descrição.
     *
     * @param descricaoProduto
     * @return Produto.
     */
    Produto descrito(String descricaoProduto) {
        this.setDescricao(descricaoProduto);
        return this;
    }

    /**
     * Adição de Cupons.
     *
     * @param cupons
     * @return Produto.
     */
    Produto cuponsVinculados(List<CupomDesconto> cupons) {
        this.setCuponsDeDesconto(cupons);
        return this;
    }
}
