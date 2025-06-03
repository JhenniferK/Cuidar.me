package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Psicologo")
public class Psicologo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long crp;
    @Column(name = "Nome")
    private String nome;
    @Column(name = "Email", unique = true)
    private String email;
    @Column(name = "Senha")
    private String senha;

    @OneToMany(mappedBy = "psicologo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Atendimento> atendimentos = new ArrayList<>();

    @OneToMany(mappedBy = "prontuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Prontuario> prontuarios = new ArrayList<>();

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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Psicologo psicologo = (Psicologo) o;
        return Objects.equals(crp, psicologo.crp) && Objects.equals(nome, psicologo.nome) && Objects.equals(email, psicologo.email) && Objects.equals(senha, psicologo.senha) && Objects.equals(atendimentos, psicologo.atendimentos) && Objects.equals(prontuarios, psicologo.prontuarios);
    }

    @Override
    public int hashCode() {
        return Objects.hash(crp, nome, email, senha, atendimentos, prontuarios);
    }

    @Override
    public String toString() {
        return "Psicologo{" +
                "crp=" + crp +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", Atendimentos=" + atendimentos + '\'' +
                ", prontuarios=" + prontuarios +
                '}';
    }
}