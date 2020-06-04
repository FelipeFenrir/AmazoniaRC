package br.com.amazoniarc.newbuy.business.pagamento;

import br.com.amazoniarc.newbuy.interfaces.Pagamento;
import br.com.amazoniarc.newbuy.model.Pedido;

/**
 * Método de Pagamento com Cartão de Débito.
 * @author felipe.batista
 */
public class CartaoDebito implements Pagamento {

    /**
     * Método de pagamento do Pedido.
     * @param pedido
     */
    public void pagar(Pedido pedido) {
        System.out.println("Pagamento de R$" + pedido.getValorTotal() + " no Cartão de Débito.");
    }
}
