package br.com.amazoniarc.newbuy.model;

import java.util.Random;

/**
 * Representação do identificador unico.
 * @author felipe.batista
 */
public class Identificador {
    private static final Integer MAX_ID = 100;

    private final Integer id;

    /**
     * Construtor.
     */
    Identificador() {
        Random random = new Random();
        this.id = random.nextInt(MAX_ID);
    }

    public Integer getId() {
        return id;
    }
}
