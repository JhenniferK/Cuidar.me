package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Prontuario")
public class Prontuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "DATA_REGISTRO")
    private LocalDateTime dataRegistro;

    @ManyToOne
    @JoinColumn(name = "PSICOLOGO_ID")
    private Psicologo psicologo;

    @ManyToOne
    @JoinColumn(name = "PACIENTE_ID")
    private Paciente paciente;

    public Prontuario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public Psicologo getPsicologo() {
        return psicologo;
    }

    public void setPsicologo(Psicologo psicologo) {
        this.psicologo = psicologo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prontuario that = (Prontuario) o;
        return Objects.equals(id, that.id) && Objects.equals(descricao, that.descricao) && Objects.equals(dataRegistro, that.dataRegistro) && Objects.equals(psicologo, that.psicologo) && Objects.equals(paciente, that.paciente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, dataRegistro, psicologo, paciente);
    }

    @Override
    public String toString() {
        return "Prontuario{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", dataRegistro=" + dataRegistro +
                ", psicologo=" + psicologo +
                ", paciente=" + paciente +
                '}';
    }
}
