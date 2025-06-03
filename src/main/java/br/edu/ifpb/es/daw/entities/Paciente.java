package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Paciente")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Nome")
    private String nome;
    @Column(name = "CPF", unique = true)
    private Long cpf;
    @Column(name = "RG")
    private Long rg;
    @Embedded
    private ContatoEmergencia contatoEmergencia;
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
    @Column(name = "Infos_Adicionais")
    private String infoAdicionais;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Atendimento> atendimentos = new ArrayList<>();

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Prontuario> prontuarios = new ArrayList<>();

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pagamento> pagamentos = new ArrayList<>();

    public Paciente() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getInfoAdicionais() {
        return infoAdicionais;
    }

    public void setInfoAdicionais(String infoAdicionais) {
        this.infoAdicionais = infoAdicionais;
    }

    public ContatoEmergencia getContatoEmergencia() {
        return contatoEmergencia;
    }

    public void setContatoEmergencia(ContatoEmergencia contatoEmergencia) {
        this.contatoEmergencia = contatoEmergencia;
    }

    public List<Atendimento> getAtendimentos() {
        return atendimentos;
    }

    public void setAtendimentos(List<Atendimento> atendimentos) {
        this.atendimentos = atendimentos;
    }

    public List<Prontuario> getProntuarios() {
        return prontuarios;
    }

    public void setProntuarios(List<Prontuario> prontuarios) {
        this.prontuarios = prontuarios;
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return Objects.equals(id, paciente.id) && Objects.equals(nome, paciente.nome) && Objects.equals(cpf, paciente.cpf) && Objects.equals(rg, paciente.rg) && Objects.equals(contatoEmergencia, paciente.contatoEmergencia) && Objects.equals(enderecoPessoal, paciente.enderecoPessoal) && Objects.equals(enderecoTrabalho, paciente.enderecoTrabalho) && Objects.equals(infoAdicionais, paciente.infoAdicionais) && Objects.equals(atendimentos, paciente.atendimentos) && Objects.equals(prontuarios, paciente.prontuarios) && Objects.equals(pagamentos, paciente.pagamentos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cpf, rg, contatoEmergencia, enderecoPessoal, enderecoTrabalho, infoAdicionais, atendimentos, prontuarios, pagamentos);
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf=" + cpf +
                ", rg=" + rg +
                ", contatoEmergencia=" + contatoEmergencia +
                ", enderecoPessoal=" + enderecoPessoal +
                ", enderecoTrabalho=" + enderecoTrabalho +
                ", info_adicionais='" + infoAdicionais + '\'' +
                ", atendimentos=" + atendimentos +
                ", prontuarios=" + prontuarios +
                ", pagamentos=" + pagamentos +
                '}';
    }
}
