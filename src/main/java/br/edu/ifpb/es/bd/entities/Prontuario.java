package br.edu.ifpb.es.bd.entities;

import java.util.Objects;
import java.time.LocalDateTime;

public class Prontuario {
    private Long id;
    private String descricao;
    private LocalDateTime dataRegistro;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prontuario that = (Prontuario) o;
        return Objects.equals(id, that.id) && Objects.equals(descricao, that.descricao) && Objects.equals(dataRegistro, that.dataRegistro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, dataRegistro);
    }

    @Override
    public String toString() {
        return "Prontuario{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", dataRegistro=" + dataRegistro +
                '}';
    }
}
