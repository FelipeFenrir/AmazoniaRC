package br.com.amazoniarc.newbuy.business.venda;

import br.com.amazoniarc.newbuy.interfaces.Desconto;
import br.com.amazoniarc.newbuy.model.Pedido;
import br.com.amazoniarc.newbuy.interfaces.Venda;

/**
 * Representa a ação de adionar desconto na venda.
 *
 * @author felipe.batista
 */
public class AdicionarDesconto implements Venda {

    private final Pedido pedido;
    private final Desconto desconto;
    private final String codigo;

    /**
     * Construtor personalizado.
     * @param pedido
     * @param desconto
     * @param codigoCupom
     */
    public AdicionarDesconto(Pedido pedido, Desconto desconto, String codigoCupom) {
        this.pedido = pedido;
        this.desconto = desconto;
        this.codigo = codigoCupom;
    }

    /**
     * Aplica o desconto no pedido.
     */
    public void concluir() {
        pedido.removerNoTotal(desconto.aplicar(pedido, codigo));
    }

}
