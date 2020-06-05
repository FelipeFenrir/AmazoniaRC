package br.com.amazoniarc.newbuy.model;

import br.com.amazoniarc.newbuy.enums.CategoriaFilme;

/**
 * Representação do modelo de produto do tipo Filme.
 *
 * @author felipe.batista
 */
public class Filme extends EmMidia {

    private CategoriaFilme categoria;

    public CategoriaFilme getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaFilme categoria) {
        this.categoria = categoria;
    }
}
