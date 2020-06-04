package br.com.amazoniarc.newbuy.interfaces;

import br.com.amazoniarc.newbuy.model.Pedido;

/**
 * Interface para Pagamento.
 * @author felipe.batista
 */
public interface Pagamento {

    /**
     * Assinatura para Metodo de pagamento.
     * @param pedido
     */
    void pagar(Pedido pedido);
}
