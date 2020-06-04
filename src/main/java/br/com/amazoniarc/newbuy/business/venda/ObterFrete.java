package br.com.amazoniarc.newbuy.business.venda;

import br.com.amazoniarc.newbuy.interfaces.Frete;
import br.com.amazoniarc.newbuy.model.Pedido;
import br.com.amazoniarc.newbuy.interfaces.Venda;

/**
 * Representação de Calculo de Frete de Venda.
 *
 * @author felipe.batista
 */
public class ObterFrete implements Venda {

    private final Pedido pedido;
    private final Frete frete;

    /**
     * Construtor Personalizado.
     *
     * @param pedido
     * @param frete
     */
    public ObterFrete(Pedido pedido, Frete frete) {
        this.pedido = pedido;
        this.frete = frete;
    }

    /**
     * Método de conclusão de Compra.
     */
    public void concluir() {
        pedido.adicionarNoTotal(frete.calcular());
    }

}
