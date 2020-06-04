package br.com.amazoniarc.newbuy.model;

/**
 * Representação de modelo de Pedido.
 * @author felipe.batista
 */
public class Pedido extends Identificador {

    private String codigo;
    private Cesta cesta;
    private double valorTotal;

    /**
     * Construtor personalizado.
     * @param codigo
     * @param cesta
     * @param valorTotal
     */
    public Pedido(String codigo, Cesta cesta, double valorTotal) {
        this.codigo = codigo;
        this.cesta = cesta;
        this.valorTotal = valorTotal;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Cesta getCesta() {
        return cesta;
    }

    public void setCesta(Cesta cesta) {
        this.cesta = cesta;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    /**
     * Método acessor para adição de valor no total.
     * @param valor
     */
    public void adicionarNoTotal(double valor) {
        this.valorTotal += valor;
    }

    /**
     * Método acessor para remover valor no total.
     * @param valor
     */
    public void removerNoTotal(double valor) {
        this.valorTotal -= valor;
    }
}
