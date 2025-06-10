package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Pagamento")
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "VALOR")
    private Integer valor;
    @Column(name = "DATA")
    private LocalDateTime data;
    @Enumerated(EnumType.STRING)
    private Metodo metodo;
    @Column(name = "STATUS")
    private StatusPagamento statusPagamento;

    @ManyToOne
    @JoinColumn(name = "PACIENTE_ID")
    private Paciente paciente;

    public Pagamento() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Metodo getMetodo() {
        return metodo;
    }

    public void setMetodo(Metodo metodo) {
        this.metodo = metodo;
    }

    public StatusPagamento getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(StatusPagamento statusPagamento) {
        this.statusPagamento = statusPagamento;
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
        Pagamento pagamento = (Pagamento) o;
        return Objects.equals(id, pagamento.id) && Objects.equals(valor, pagamento.valor) && metodo == pagamento.metodo && Objects.equals(statusPagamento, pagamento.statusPagamento) && Objects.equals(data, pagamento.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, valor, metodo, statusPagamento, data);
    }

    @Override
    public String toString() {
        return "Pagamento{" +
                "id=" + id +
                ", valor=" + valor +
                ", metodo='" + metodo + '\'' +
                ", status=" + statusPagamento +
                ", data=" + data +
                '}';
    }
}
