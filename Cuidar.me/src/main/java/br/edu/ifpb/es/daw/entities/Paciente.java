package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Paciente")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "CPF", unique = true)
    private Long cpf;
    @Embedded
    private ContatoEmergencia contatoEmergencia;
    @Column(name = "RG")
    private Long rg;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="logradouro", column=@Column(name = "LOGRADOURO_PESSOAL")),
            @AttributeOverride(name="numero", column=@Column(name = "NUMER0_PESSOAL")),
            @AttributeOverride(name="cidade", column=@Column(name = "CIDADE_PESSOAL")),
            @AttributeOverride(name="estado", column=@Column(name = "ESTADO_PESSOAL"))
    })
    private Endereco enderecoPessoal;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="logradouro", column=@Column(name = "LOGRADOURO_TRABALHO")),
            @AttributeOverride(name="numero", column=@Column(name = "NUMER0_TRABALHO")),
            @AttributeOverride(name="cidade", column=@Column(name = "CIDADE_TRABALHO")),
            @AttributeOverride(name="estado", column=@Column(name = "ESTADO_TRABALHO"))
    })
    private Endereco enderecoTrabalho;
    @Column(name = "Info_Adicionais")
    private String info_adicionais;

    public Paciente(){

    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public Long getRg() {
        return rg;
    }

    public void setRg(Long rg) {
        this.rg = rg;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public ContatoEmergencia getContatoEmergencia() {
        return contatoEmergencia;
    }

    public void setContatoEmergencia(ContatoEmergencia contatoEmergencia) {
        this.contatoEmergencia = contatoEmergencia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return Objects.equals(cpf, paciente.cpf) && Objects.equals(contatoEmergencia, paciente.contatoEmergencia) && Objects.equals(rg, paciente.rg) && Objects.equals(enderecoPessoal, paciente.enderecoPessoal) && Objects.equals(enderecoTrabalho, paciente.enderecoTrabalho) && Objects.equals(info_adicionais, paciente.info_adicionais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf, contatoEmergencia, rg, enderecoPessoal, enderecoTrabalho, info_adicionais);
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "cpf=" + cpf +
                ", contatoEmergencia=" + contatoEmergencia +
                ", rg=" + rg +
                ", end_pessoal='" + enderecoPessoal + '\'' +
                ", end_trabalho='" + enderecoTrabalho + '\'' +
                ", info_adicionais='" + info_adicionais + '\'' +
                '}';
    }
}
