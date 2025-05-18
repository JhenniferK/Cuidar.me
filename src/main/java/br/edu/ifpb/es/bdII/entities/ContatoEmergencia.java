package br.edu.ifpb.es.bdII.entities;

import java.util.Objects;

public class ContatoEmergencia {
    private String nome;
    private Integer telefone;

    public ContatoEmergencia() {}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContatoEmergencia that = (ContatoEmergencia) o;
        return telefone == that.telefone && Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, telefone);
    }

    @Override
    public String toString() {
        return "ContatoEmergencia{" +
                "nome='" + nome + '\'' +
                ", telefone=" + telefone +
                '}';
    }
}
