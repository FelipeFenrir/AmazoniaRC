package br.com.amazoniarc.newbuy.business.venda;

import br.com.amazoniarc.newbuy.interfaces.Pagamento;
import br.com.amazoniarc.newbuy.model.Pedido;
import br.com.amazoniarc.newbuy.interfaces.Venda;

/**
 * Representação de Ação de Pagamento.
 * @author felipe.batista
 */
public class EfetuarPagamento implements Venda {

    private final Pedido pedido;
    private final Pagamento pagamento;

    /**
     * Construtor Personalizado.
     * @param pedido
     * @param pagamento
     */
    public EfetuarPagamento(Pedido pedido, Pagamento pagamento) {
        this.pedido = pedido;
        this.pagamento = pagamento;
    }

    /**
     * Método de conclusão de Compra.
     */
    public void concluir() {
        pagamento.pagar(pedido);
    }
}
