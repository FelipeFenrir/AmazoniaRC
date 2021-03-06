package br.com.amazoniarc.newbuy.business.tributo;

import br.com.amazoniarc.newbuy.model.Pedido;
import br.com.amazoniarc.newbuy.model.Produto;
import br.com.amazoniarc.newbuy.model.Publicacao;
import br.com.amazoniarc.newbuy.interfaces.Tributo;

import java.text.NumberFormat;

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
        System.out.println("O ICMS é ".concat(
                NumberFormat.getCurrencyInstance().format(tributo)));
        return tributo;
    }

    private boolean temInsencao(Produto produto) {
        if (produto instanceof Publicacao) {
            return false;
        }
        return true;
    }

}
