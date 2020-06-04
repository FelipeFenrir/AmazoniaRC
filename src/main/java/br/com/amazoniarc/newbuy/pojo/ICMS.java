package br.com.amazoniarc.newbuy.pojo;

import br.com.amazoniarc.newbuy.model.Pedido;
import br.com.amazoniarc.newbuy.model.Produto;
import br.com.amazoniarc.newbuy.model.ParaLeitura;
import br.com.amazoniarc.newbuy.interfaces.Tributo;

/**
 * Representacao do Tributo do tipo ICMS.
 *
 * @author felipe.batista
 */
public class ICMS implements Tributo {

    private static final double POR_CENTO = 5 / 100d;
    private final Pedido pedido;

    /**
     * Contrutor.
     * @param pedido
     */
    public ICMS(Pedido pedido) {
        this.pedido = pedido;
    }

    /**
     * Método de calculo de tributo.
     * @return valor do tributo.
     */
    public double calcular() {
        double tributo = 0;
        for (Produto produto : pedido.getCesta().getItens()) {
            if (temInsencao(produto)) {
                tributo += produto.getPreco() * POR_CENTO;
            }
        }
        return tributo;
    }

    private boolean temInsencao(Produto produto) {
        if (produto instanceof ParaLeitura) {
            return false;
        }
        return true;
    }

}
