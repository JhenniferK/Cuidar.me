package br.edu.ifpb.es.bd.entities;

import java.util.Objects;

public class Psicologo {
    private Long crp;
    private String nome;
    private String email;
    private String senha;

    public Psicologo() {
    }

    public Long getCrp() {
        return crp;
    }

    public void setCrp(Long crp) {
        this.crp = crp;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Psicologo psicologo = (Psicologo) o;
        return Objects.equals(crp, psicologo.crp) && Objects.equals(nome, psicologo.nome) && Objects.equals(email, psicologo.email) && Objects.equals(senha, psicologo.senha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(crp, nome, email, senha);
    }

    @Override
    public String toString() {
        return "Psicologo{" +
                "crp=" + crp +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
