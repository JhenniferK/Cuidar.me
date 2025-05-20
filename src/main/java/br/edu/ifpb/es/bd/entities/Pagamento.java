package br.edu.ifpb.es.bd.entities;

import java.util.Objects;
import java.time.LocalDateTime;

public class Pagamento {
    private Long id;
    private Integer valor;
    private Metodo metodo;
    private Boolean status;
    private LocalDateTime data;

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

    public Metodo getMetodo() {
        return metodo;
    }

    public void setMetodo(Metodo metodo) {
        this.metodo = metodo;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
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
                ", metodo=" + metodo +
                ", status=" + status +
                ", data=" + data +
                '}';
    }
}
