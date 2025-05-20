package br.edu.ifpb.es.bdII.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Objects;

@Document(collection = "psicologo")
public class Psicologo {

    @Id
    private String id;
    private String crp;
    private String nome;
    private String email;
    private String senha;

    public Psicologo(String crp, String nome, String email, String senha) {
        this.crp = crp;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getCrp() {
        return crp;
    }

    public void setCrp(String crp) {
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Psicologo psicologo = (Psicologo) o;
        return Objects.equals(id, psicologo.id) && Objects.equals(crp, psicologo.crp) && Objects.equals(nome, psicologo.nome) && Objects.equals(email, psicologo.email) && Objects.equals(senha, psicologo.senha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, crp, nome, email, senha);
    }

    @Override
    public String toString() {
        return "Psicologo{" +
                "crp=" + crp +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
