package br.com.amazoniarc.newbuy.factory;

/**
 * Fabrica Generica.
 *
 * @author felipe.batista
 * @param <T>
 */
public class Fabrica<T> {

    private final Class<T> type;

    /**
     * Construtor.
     *
     * @param type
     */
    public Fabrica(Class<T> type) {
        this.type = type;
    }

    /**
     * Use a fabrica para pegar a instancia.
     *
     * @return Objeto.
     */
    public T getInstance() {
        try {
            //Classe Publica.
            return type.newInstance();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Cria a Fabrica.
     *
     * @param <V>
     * @param type
     * @return Objeto.
     */
    public static <V> Fabrica<V> getInstance(Class<V> type) {
        return new Fabrica<V>(type);
    }
}
