package br.com.amazoniarc.newbuy.interfaces;

import br.com.amazoniarc.newbuy.model.Pedido;

/**
 * Interface para Aplicar Desconto.
 *
 * @author felipe.batista
 */
public interface Desconto {

    /**
     * Assinatura de Método de Aplicação do Desconto.
     *
     * @param pedido
     * @param codigo
     * @return
     */
    double aplicar(Pedido pedido, String codigo);
}
