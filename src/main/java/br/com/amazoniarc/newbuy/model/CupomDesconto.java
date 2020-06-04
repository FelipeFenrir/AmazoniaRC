package br.com.amazoniarc.newbuy.model;

/**
 * Representa um Cupon de Desconto.
 * @author felipe.batista
 */
public class CupomDesconto extends Identificador {

    private String codigo;
    private double valorDesconto;

    public CupomDesconto(String codigo, double valorDesconto) {
        this.codigo = codigo;
        this.valorDesconto = valorDesconto;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setValorDesconto(double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }
}
