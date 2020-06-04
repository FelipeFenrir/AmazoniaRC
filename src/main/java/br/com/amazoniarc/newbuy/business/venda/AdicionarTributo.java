package br.com.amazoniarc.newbuy.business.venda;

import br.com.amazoniarc.newbuy.model.Pedido;
import br.com.amazoniarc.newbuy.interfaces.Venda;
import br.com.amazoniarc.newbuy.interfaces.Tributo;

/**
 * Representa a ação de adionar tributo na venda.
 *
 * @author felipe.batista
 */
public class AdicionarTributo implements Venda {

    private final Pedido pedido;
    private final Tributo tributo;

    /**
     * Contrutor personalizado.
     * @param pedido
     * @param tributo
     */
    public AdicionarTributo(Pedido pedido, Tributo tributo) {
        this.pedido = pedido;
        this.tributo = tributo;
    }

    /**
     * Aplica o tributo no pedido.
     */
    public void concluir() {
        pedido.adicionarNoTotal(tributo.calcular());
    }

}
