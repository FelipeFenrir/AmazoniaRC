package br.com.amazoniarc.newbuy.model;

import br.com.amazoniarc.newbuy.enums.TipoMidia;

/**
 * Representação de produtos em diferentes midias.
 * @author felipe.batista
 */
public class EmMidia extends Produto {

    private TipoMidia tipomidia;

    public TipoMidia getTipomidia() {
        return tipomidia;
    }

    public void setTipomidia(TipoMidia tipomidia) {
        this.tipomidia = tipomidia;
    }
}
