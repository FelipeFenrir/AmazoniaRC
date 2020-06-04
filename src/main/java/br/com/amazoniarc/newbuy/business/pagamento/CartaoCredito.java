package br.com.amazoniarc.newbuy.business.pagamento;

import br.com.amazoniarc.newbuy.interfaces.Pagamento;
import br.com.amazoniarc.newbuy.model.Pedido;
import java.text.NumberFormat;

/**
 * Método de Pagamento com Cartão de Crédito.
 * @author felipe.batista
 */
public class CartaoCredito implements Pagamento {

    /**
     * Método de pagamento do Pedido.
     * @param pedido
     */
    public void pagar(Pedido pedido) {
        System.out.println("Pagamento realizado no valor de "
                + NumberFormat.getCurrencyInstance().format(pedido.getValorTotal())
                + " no Cartão de Crédito.");
    }
}
