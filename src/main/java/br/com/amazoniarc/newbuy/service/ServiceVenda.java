package br.com.amazoniarc.newbuy.service;

import java.util.List;

import br.com.amazoniarc.newbuy.model.Cesta;
import br.com.amazoniarc.newbuy.interfaces.Venda;

/**
 * Serviços relacionados a Venda.
 * @author felipe.batista
 */
public class ServiceVenda {

    /**
     * Checkout da cesta com a lista de ações de venda.
     * @param cesta Lista de Itens.
     * @param acoes a serem executadas para a venda.
     */
    public void checkout(Cesta cesta, List<Venda> acoes) {
        for (Venda acao : acoes) {
            acao.concluir();
        }
    }
}
