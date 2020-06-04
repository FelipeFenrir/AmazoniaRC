package br.com.amazoniarc.newbuy.model;

import br.com.amazoniarc.newbuy.enums.CategoriaLeitura;

/**
 * Representação do modelo de produto do tipo ParaLeitura.
 * @author felipe.batista
 */
public class ParaLeitura extends EmMidia {

    private Integer numeroPaginas;
    private long codigoISBN;
    private CategoriaLeitura categoria;

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(Integer numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public long getCodigoISBN() {
        return codigoISBN;
    }

    public void setCodigoISBN(long codigoISBN) {
        this.codigoISBN = codigoISBN;
    }

    public CategoriaLeitura getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaLeitura categoria) {
        this.categoria = categoria;
    }
}
