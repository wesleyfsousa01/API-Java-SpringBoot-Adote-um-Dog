package com.adoteumdog.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

@Entity
public class Dog implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String name;
    private String raca;
    private Integer idadeEmMeses;
    private String cor;
    private String descricao;
    private Boolean vacinado;
    private Integer quantidadeDeDonos;
    private Boolean isAdotado = false;
    private String telefone;
    private String nomeDono;
    private Byte[] foto;

    public Dog() {
    }

    public Dog(Long id, String name, String raca, Integer idadeEmMeses,
               String cor, String descricao, Boolean vacinado,
               Integer quantidadeDeDonos, Boolean isAdotado,
               String telefone, String nomeDono, Byte[] foto)
    {
        this.id = id;
        this.name = name;
        this.raca = raca;
        this.idadeEmMeses = idadeEmMeses;
        this.cor = cor;
        this.descricao = descricao;
        this.vacinado = vacinado;
        this.quantidadeDeDonos = quantidadeDeDonos;
        this.isAdotado = isAdotado;
        this.telefone = telefone;
        this.nomeDono = nomeDono;
        this.foto = foto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Integer getIdadeEmMeses() {
        return idadeEmMeses;
    }

    public void setIdadeEmMeses(Integer idadeEmMeses) {
        this.idadeEmMeses = idadeEmMeses;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getVacinado() {
        return vacinado;
    }

    public void setVacinado(Boolean vacinado) {
        this.vacinado = vacinado;
    }

    public Integer getQuantidadeDeDonos() {
        return quantidadeDeDonos;
    }

    public void setQuantidadeDeDonos(Integer quantidadeDeDonos) {
        this.quantidadeDeDonos = quantidadeDeDonos;
    }

    public Boolean getAdotado() {
        return isAdotado;
    }

    public void setAdotado(Boolean adotado) {
        isAdotado = adotado;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNomeDono() {
        return nomeDono;
    }

    public void setNomeDono(String nomeDono) {
        this.nomeDono = nomeDono;
    }

    public Byte[] getFoto() {
        return foto;
    }

    public void setFoto(Byte[] foto) {
        this.foto = foto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(id, dog.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", raca='" + raca + '\'' +
                ", idadeEmMeses='" + idadeEmMeses + '\'' +
                ", cor='" + cor + '\'' +
                ", descricao='" + descricao + '\'' +
                ", vacinado=" + vacinado +
                ", quantidadeDeDonos=" + quantidadeDeDonos +
                ", isAdotado=" + isAdotado +
                ", telefone='" + telefone + '\'' +
                ", nomeDono='" + nomeDono + '\'' +
                ", foto=" + Arrays.toString(foto) +
                '}';
    }
}
