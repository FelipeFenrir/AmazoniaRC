package br.com.amazoniarc.newbuy.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Modelo de representação de uma cesta de compras.
 * @author felipe.batista
 */
public class Cesta extends Identificador {

    private final List<Produto> itens = new ArrayList<Produto>();

    /**
     * Obtem a lista de produtos na cesta.
     * @return Lista de Produtos da cesta.
     */
    public List<Produto> getItens() {
        return itens;
    }

    /**
     * Adiciona um produto na cesta.
     * @param produto
     */
    public void addItem(Produto produto) {
        itens.add(produto);
    }

    /**
     * Obtem a quantidade total de produtos na cesta.
     * @return A quantidade de itens.
     */
    public long getQtdTotal() {
        return itens.size();
    }

    /**
     * Obtem o valor total dentro da cesta.
     * @return O valor total.
     */
    public double getVlTotal() {
        double total = 0d;

        for (Produto produto : itens) {
            total += produto.getPreco();
        }

        return total;
    }
}
