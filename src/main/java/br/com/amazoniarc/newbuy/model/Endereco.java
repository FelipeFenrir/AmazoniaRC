package br.com.amazoniarc.newbuy.model;

/**
 * Representação de modelo de endereço.
 * @author felipe.batista
 */
public class Endereco extends Identificador {

    private String rua;
    private String bairro;
    private Integer numero;
    private String cidade;
    private String cep;

    /**
     * Construtor personalizado.
     * @param rua
     * @param bairro
     * @param numero
     * @param cidade
     * @param cep
     */
    public Endereco(String rua, String bairro, Integer numero, String cidade, String cep) {
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.cidade = cidade;
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

}