package br.com.amazoniarc.newbuy.model;

import br.com.amazoniarc.newbuy.enums.TipoEndereco;

import java.util.List;
import java.util.Map;

/**
 * Modelo de representação de um Cliente.
 * @author felipe.batista
 */
public class Cliente extends Identificador {

    private String nome;
    private String telefone;
    private String email;
    private String cpf;
    private String rg;
    private Map<TipoEndereco, Endereco> enderecos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Map<TipoEndereco, Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Map<TipoEndereco, Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Endereco getEnderecoEntrega() {
        return enderecos.get(TipoEndereco.ENTREGA);
    }

    public Endereco getEnderecoCobranca() {
        return enderecos.get(TipoEndereco.COBRANCA);
    }
}