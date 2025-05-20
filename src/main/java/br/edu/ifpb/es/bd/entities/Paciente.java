package br.edu.ifpb.es.bd.entities;

import java.util.Objects;

public class Paciente {
    private Long id;
    private Long cpf;
    private ContatoEmergencia contatoEmergencia;
    private Long rg;
    private Endereco enderecoPessoal;
    private Endereco enderecoTrabalho;
    private String info_adicionais;

    public Paciente(Long id, Long cpf, ContatoEmergencia contatoEmergencia, Long rg, Endereco enderecoPessoal, Endereco enderecoTrabalho, String info_adicionais) {
        this.id = id;
        this.cpf = cpf;
        this.contatoEmergencia = contatoEmergencia;
        this.rg = rg;
        this.enderecoPessoal = enderecoPessoal;
        this.enderecoTrabalho = enderecoTrabalho;
        this.info_adicionais = info_adicionais;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public ContatoEmergencia getContatoEmergencia() {
        return contatoEmergencia;
    }

    public void setContatoEmergencia(ContatoEmergencia contatoEmergencia) {
        this.contatoEmergencia = contatoEmergencia;
    }

    public Long getRg() {
        return rg;
    }

    public void setRg(Long rg) {
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

    public String getInfo_adicionais() {
        return info_adicionais;
    }

    public void setInfo_adicionais(String info_adicionais) {
        this.info_adicionais = info_adicionais;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return Objects.equals(id, paciente.id) && Objects.equals(cpf, paciente.cpf) && Objects.equals(contatoEmergencia, paciente.contatoEmergencia) && Objects.equals(rg, paciente.rg) && Objects.equals(enderecoPessoal, paciente.enderecoPessoal) && Objects.equals(enderecoTrabalho, paciente.enderecoTrabalho) && Objects.equals(info_adicionais, paciente.info_adicionais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cpf, contatoEmergencia, rg, enderecoPessoal, enderecoTrabalho, info_adicionais);
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", cpf=" + cpf +
                ", contatoEmergencia=" + contatoEmergencia +
                ", rg=" + rg +
                ", enderecoPessoal=" + enderecoPessoal +
                ", enderecoTrabalho=" + enderecoTrabalho +
                ", info_adicionais='" + info_adicionais + '\'' +
                '}';
    }
}
