package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "Atendimento")
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "DATA")
    private LocalDateTime data;
    @Column(name = "LOCALIDADE")
    private String localidade;
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private StatusAtendimento statusAtendimento;

    @ManyToOne
    @JoinColumn(name = "PSICOLOGO_ID")
    private Psicologo psicologo;

    @ManyToOne
    @JoinColumn(name = "PACIENTE_ID")
    private Paciente paciente;

    public Atendimento() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public StatusAtendimento getStatusAtendimento() {
        return statusAtendimento;
    }

    public void setAgendado(StatusAtendimento statusAtendimento) {
        this.statusAtendimento = statusAtendimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atendimento that = (Atendimento) o;
        return Objects.equals(id, that.id) && Objects.equals(data, that.data) && Objects.equals(localidade, that.localidade) && Objects.equals(statusAtendimento, that.statusAtendimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data, localidade, statusAtendimento);
    }

    @Override
    public String toString() {
        return "Atendimento{" +
                "id=" + id +
                ", data=" + data +
                ", localidade='" + localidade + '\'' +
                ", agendado=" + statusAtendimento +
                ", psicologo=" + psicologo +
                ", paciente=" + paciente +
                '}';
    }
}
