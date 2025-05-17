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
    @Column(name = "Valor")
    private Integer valor;
    @Enumerated(EnumType.STRING)
    private Metodo metodo;
    @Column(name = "Status")
    private Boolean status;

    private LocalDateTime data;

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

    public Metodo getMetodo() {
        return metodo;
    }

    public void setMetodo(Metodo metodo) {
        this.metodo = metodo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pagamento pagamento = (Pagamento) o;
        return Objects.equals(id, pagamento.id) && Objects.equals(valor, pagamento.valor) && metodo == pagamento.metodo && Objects.equals(status, pagamento.status) && Objects.equals(data, pagamento.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, valor, metodo, status, data);
    }

    @Override
    public String toString() {
        return "Pagamento{" +
                "id=" + id +
                ", valor=" + valor +
                ", metodo='" + metodo + '\'' +
                ", status=" + status +
                ", data=" + data +
                '}';
    }
}
