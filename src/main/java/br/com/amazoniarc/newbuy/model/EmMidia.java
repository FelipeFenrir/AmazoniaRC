package br.com.amazoniarc.newbuy.model;

import br.com.amazoniarc.newbuy.enums.TipoMidia;
import java.util.List;

/**
 * Representação de produtos em diferentes midias.
 * @author felipe.batista
 */
public class EmMidia extends Produto {

    private TipoMidia tipomidia;

    /**
     * Construtor padrão.
     */
    EmMidia() {
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
     */
    EmMidia(String descricao, Double preco, String peso,
            Double comprimento, Double altura, Double largura,
            String diametro, List<CupomDesconto> cuponsDeDesconto,
            TipoMidia tipomidia) {
        super(descricao, preco, peso, comprimento, altura, largura, diametro,
                cuponsDeDesconto);
        this.tipomidia = tipomidia;
    }

    public TipoMidia getTipomidia() {
        return tipomidia;
    }

    public void setTipomidia(TipoMidia tipomidia) {
        this.tipomidia = tipomidia;
    }
}
