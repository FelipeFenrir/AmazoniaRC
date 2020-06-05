package br.com.amazoniarc.newbuy.model;

import br.com.amazoniarc.newbuy.enums.CategoriaFilme;
import br.com.amazoniarc.newbuy.enums.TipoMidia;
import java.util.List;

/**
 * Representação do modelo de produto do tipo Filme.
 *
 * @author felipe.batista
 */
public class Filme extends EmMidia {

    private CategoriaFilme categoria;

    /**
     * Construtor padrão.
     */
    Filme() {
    }

    /**
     * Construtor Completo.
     * @param descricao
     * @param preco
     * @param peso
     * @param comprimento
     * @param altura
     * @param largura
     * @param diametro
     * @param cuponsDeDesconto
     * @param tipomidia
     * @param categoria
     */
    Filme(String descricao, Double preco, String peso,
            Double comprimento, Double altura, Double largura, String diametro,
            List<CupomDesconto> cuponsDeDesconto, TipoMidia tipomidia,
            CategoriaFilme categoria) {
        super(descricao, preco, peso, comprimento, altura, largura, diametro,
                cuponsDeDesconto, tipomidia);
        this.categoria = categoria;
    }

    public CategoriaFilme getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaFilme categoria) {
        this.categoria = categoria;
    }
}
