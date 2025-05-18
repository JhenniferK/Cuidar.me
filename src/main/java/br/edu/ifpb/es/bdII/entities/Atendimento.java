package br.edu.ifpb.es.bdII.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.Objects;

@Document(collection = "atendimentos")
public class Atendimento {

    @Id
    private String id;
    private String localidade;
    private LocalDateTime data;
    private boolean agendado;

    public Atendimento() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
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
        return agendado == that.agendado && Objects.equals(id, that.id) && Objects.equals(localidade, that.localidade) && Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, localidade, data, agendado);
    }

    @Override
    public String toString() {
        return "Atendimento{" +
                "id='" + id + '\'' +
                ", localidade='" + localidade + '\'' +
                ", data=" + data +
                ", agendado=" + agendado +
                '}';
    }
}
