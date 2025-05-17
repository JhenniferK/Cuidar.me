package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Atendimento")
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Data")
    private LocalDateTime data;
    @Column(name = "Localidade")
    private String localidade;
    @Column(name = "Agendado")
    private Boolean agendado;

    public Atendimento(){

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

    public boolean isAgendado() {
        return agendado;
    }

    public void setAgendado(boolean agendado) {
        this.agendado = agendado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atendimento that = (Atendimento) o;
        return Objects.equals(id, that.id) && Objects.equals(data, that.data) && Objects.equals(localidade, that.localidade) && Objects.equals(agendado, that.agendado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data, localidade, agendado);
    }

    @Override
    public String toString() {
        return "Atendimento{" +
                "id=" + id +
                ", data=" + data +
                ", localidade='" + localidade + '\'' +
                ", agendado=" + agendado +
                '}';
    }
}
