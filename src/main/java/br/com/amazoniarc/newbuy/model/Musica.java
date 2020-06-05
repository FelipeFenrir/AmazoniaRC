package br.com.amazoniarc.newbuy.model;

import br.com.amazoniarc.newbuy.enums.CategoriaMusica;
import br.com.amazoniarc.newbuy.enums.TipoMidia;
import java.util.List;

/**
 * Representação do modelo de produto do tipo Musica.
 *
 * @author felipe.batista
 */
public class Musica extends EmMidia {

    private CategoriaMusica categoria;

    /**
     * Construtor padrão.
     */
    Musica() {
    }

    /**
     * Construtor Completo.
     *
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
    Musica(String descricao, Double preco, String peso,
            Double comprimento, Double altura, Double largura, String diametro,
            List<CupomDesconto> cuponsDeDesconto, TipoMidia tipomidia,
            CategoriaMusica categoria) {
        super(descricao, preco, peso, comprimento, altura, largura, diametro,
                cuponsDeDesconto, tipomidia);
        this.categoria = categoria;
    }

    public CategoriaMusica getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaMusica categoria) {
        this.categoria = categoria;
    }
}
