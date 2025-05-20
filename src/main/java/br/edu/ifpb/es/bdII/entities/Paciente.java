package br.edu.ifpb.es.bdII.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Objects;

@Document(collection = "pacientes")
public class Paciente {

    @Id
    private String id;
    private String nome;
    private String cpf;
    private String rg;
    private Endereco enderecoPessoal;
    private Endereco enderecoTrabalho;
    private String contato;
    private ContatoEmergencia contatoEmergencia;
    private String infos_adicionais;

    public Paciente(String nome, String cpf, String rg, Endereco enderecoPessoal, Endereco enderecoTrabalho, String contato, ContatoEmergencia contatoEmergencia) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.enderecoPessoal = enderecoPessoal;
        this.enderecoTrabalho = enderecoTrabalho;
        this.contatoEmergencia = contatoEmergencia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

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

    public Endereco getEnderecoPessoal() {
        return enderecoPessoal;
    }

    public void setEnderecoPessoal(Endereco enderecoPessoal) {
        this.enderecoPessoal = enderecoPessoal;
    }

    public Endereco getEnderecoTrabalho() {
        return enderecoTrabalho;
    }

    public void setEnderecoTrabalho(Endereco enderecoTrabalho) {
        this.enderecoTrabalho = enderecoTrabalho;
    }

    public String getContato() { return contato; }

    public void setContato(String contato) { this.contato = contato; }

    public ContatoEmergencia getContatoEmergencia() {
        return contatoEmergencia;
    }

    public void setContatoEmergencia(ContatoEmergencia contatoEmergencia) {
        this.contatoEmergencia = contatoEmergencia;
    }

    public String getInfos_adicionais() {
        return infos_adicionais;
    }

    public void setInfos_adicionais(String infos_adicionais) {
        this.infos_adicionais = infos_adicionais;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return Objects.equals(id, paciente.id) && Objects.equals(nome, paciente.nome) && Objects.equals(cpf, paciente.cpf) && Objects.equals(rg, paciente.rg) && Objects.equals(enderecoPessoal, paciente.enderecoPessoal) && Objects.equals(enderecoTrabalho, paciente.enderecoTrabalho) && Objects.equals(contato, paciente.contato) && Objects.equals(contatoEmergencia, paciente.contatoEmergencia) && Objects.equals(infos_adicionais, paciente.infos_adicionais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cpf, rg, enderecoPessoal, enderecoTrabalho, contato, contatoEmergencia, infos_adicionais);
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id='" + id + '\'' +
                ", nome=" + nome +
                ", cpf=" + cpf +
                ", rg=" + rg +
                ", enderecoPessoal=" + enderecoPessoal +
                ", enderecoTrabalho=" + enderecoTrabalho +
                ", contato=" + contato +
                ", contatoEmergencia=" + contatoEmergencia +
                ", info_adicionais='" + infos_adicionais + '\'' +
                '}';
    }
}