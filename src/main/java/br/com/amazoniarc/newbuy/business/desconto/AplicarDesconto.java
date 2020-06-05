package br.com.amazoniarc.newbuy.business.desconto;

import br.com.amazoniarc.newbuy.interfaces.Desconto;
import br.com.amazoniarc.newbuy.model.CupomDesconto;
import br.com.amazoniarc.newbuy.model.Pedido;
import br.com.amazoniarc.newbuy.model.Produto;

/**
 * Implementação de desconto via Cupom para ser aplicado pelo próprio cliente.
 *
 * @author felipe.batista
 */
public class AplicarDesconto implements Desconto {

    private static final double POR_CENTO = 100d;

    /**
     * Construtor.
     */
    public AplicarDesconto() {
    }

    /**
     * Método para aplicar o desconto por produto.
     *
     * @param pedido
     * @param codigoCupom
     * @return Desconto
     */
    public double aplicar(Pedido pedido, String codigoCupom) {
        double desconto = 0;
        for (Produto produto : pedido.getCesta().getItens()) {
            if (produto.getCuponsDeDesconto() != null && !produto.getCuponsDeDesconto().isEmpty()) {
                double valor = 0;
                for (CupomDesconto cupom : produto.getCuponsDeDesconto()) {
                    if (cupom.getCodigo().equals(codigoCupom)) {
                        valor = cupom.getValorDesconto() / POR_CENTO;
                    }
                }
                double valorDesconto = produto.getPreco() * (valor);
                desconto += valorDesconto;
            }
        }
        return desconto;
    }
}
