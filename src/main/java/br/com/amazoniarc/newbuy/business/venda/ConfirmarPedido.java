package br.com.amazoniarc.newbuy.business.venda;

import br.com.amazoniarc.newbuy.interfaces.Venda;
import br.com.amazoniarc.newbuy.interfaces.ConfimacaoCompra;

/**
 * Representação de Confirmação de Venda.
 * @author felipe.batista
 */
public class ConfirmarPedido implements Venda {

    private final ConfimacaoCompra confirmacaoCompra;

    /**
     * Construtor Personalizado.
     * @param confirmacaoCompra
     */
    public ConfirmarPedido(ConfimacaoCompra confirmacaoCompra) {
        this.confirmacaoCompra = confirmacaoCompra;
    }

    /**
     * Método de conclusão de Compra.
     */
    public void concluir() {
        confirmacaoCompra.confirmar();
    }
}
