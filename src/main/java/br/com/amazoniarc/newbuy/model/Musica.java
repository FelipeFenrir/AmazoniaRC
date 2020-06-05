package br.com.amazoniarc.newbuy.model;

import br.com.amazoniarc.newbuy.enums.CategoriaMusica;

/**
 * Representação do modelo de produto do tipo Musica.
 *
 * @author felipe.batista
 */
public class Musica extends EmMidia {

    private CategoriaMusica categoria;

    public CategoriaMusica getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaMusica categoria) {
        this.categoria = categoria;
    }
}
