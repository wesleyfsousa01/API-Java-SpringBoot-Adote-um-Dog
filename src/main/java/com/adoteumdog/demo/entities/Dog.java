package com.adoteumdog.demo.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
    @Column(nullable = true)
    private String nome;
    @Column(nullable = false)
    @NotBlank(message = "A raça deve ser informada")
    private String raca;
    @Column(nullable = false)
    @NotNull(message = "A idade deve ser informada")
    private Integer idadeEmMeses;
    @Column(nullable = false)
    @NotBlank(message = "A cor do animal deve ser informada")
    private String cor;
    @Column(nullable = false)
    @NotBlank(message = "A descrição deve ser informada")
    private String descricao;
    @Column(nullable = false)
    @NotNull(message = "O status de vacinação deve ser informado")
    private Boolean vacinado;
    @Column(nullable = false)
    @NotNull(message = "A quantidade de donos deve ser informada")
    private Integer quantidadeDeDonos;
    @Column(nullable = false)
    @NotNull(message = "O status de adoção deve ser informado")
    private Boolean isAdotado = false;
    @Column(nullable = false)
    @NotBlank(message = "O telefone deve ser informado")
    private String telefone;
    @Column(nullable = false)
    @NotBlank(message = "O nome do Dono deve ser informado")
    private String nomeDono;
    @Lob
//    @Column(nullable = false)
//    @NotBlank(message = "Compo foto obrigatório")
    private byte[] foto;

    public Dog() {
    }

    public Dog(Long id, String name, String raca, Integer idadeEmMeses,
               String cor, String descricao, Boolean vacinado,
               Integer quantidadeDeDonos, Boolean isAdotado,
               String telefone, String nomeDono, byte[] foto)
    {
        this.id = id;
        this.nome = name;
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

    public Dog(Long id, String name, String raca, Integer idadeEmMeses, String cor, String descricao, Boolean vacinado, Integer quantidadeDeDonos, String telefone, String nomeDono, byte[] foto) {
        this.id = id;
        this.nome = name;
        this.raca = raca;
        this.idadeEmMeses = idadeEmMeses;
        this.cor = cor;
        this.descricao = descricao;
        this.vacinado = vacinado;
        this.quantidadeDeDonos = quantidadeDeDonos;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
    @Lob
    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
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
                ", name='" + nome + '\'' +
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
