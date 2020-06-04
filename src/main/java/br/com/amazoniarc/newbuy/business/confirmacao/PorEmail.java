package br.com.amazoniarc.newbuy.business.confirmacao;

import br.com.amazoniarc.newbuy.model.Cliente;
import br.com.amazoniarc.newbuy.model.Pedido;
import br.com.amazoniarc.newbuy.interfaces.ConfimacaoCompra;

/**
 * Implementa a Confirmação de Compra via E-mail.
 * @author felipe.batista
 */
public class PorEmail implements ConfimacaoCompra {

    private final Cliente cliente;
    private final Pedido pedido;

    /**
     * Construtor Personalizado.
     * @param cliente
     * @param pedido
     */
    public PorEmail(Cliente cliente, Pedido pedido) {
        this.cliente = cliente;
        this.pedido = pedido;
    }

    /**
     * Método de envio de Email para confirmação de Compra.
     */
    public void confirmar() {
        System.out.println("Enviando confirmação para o e-mail " + cliente.getEmail());
    }

}
