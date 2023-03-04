package com.adoteumdog.demo.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Dog implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(unique = true)
    private Long dogCode;
    @Column(nullable = true)
    private String name;
    @Column(nullable = false)
    @NotBlank(message = "A raça deve ser informada")
    private String race;
    @Column(nullable = false)
    @NotNull(message = "A idade deve ser informada")
    private Integer ageInMonths;
    @Column(nullable = false)
    @NotBlank(message = "A cor do animal deve ser informada")
    private String color;
    @Column(nullable = false)
    @NotBlank(message = "A descrição deve ser informada")
    private String description;
    @Column(nullable = false)
    @NotNull(message = "O status de vacinação deve ser informado")
    private Boolean vaccinated;
    @Column(nullable = false)
    @NotNull(message = "A quantidade de donos deve ser informada")
    private Integer amountOfOwners;
    @Column(nullable = false)
    @NotNull(message = "O status de adoção deve ser informado")
    private Boolean isAdopted = false;
    @Column(nullable = false)
    @NotBlank(message = "O telefone deve ser informado")
    private String phone;
    @Column(nullable = false)
    @NotBlank(message = "O nome do Dono deve ser informado")
    private String ownerName;
    @Lob
//    @Column(nullable = false)
//    @NotBlank(message = "Compo foto obrigatório")
    private byte[] photo;

    public Dog() {
    }

    public Dog(Long id, Long dogCode, String name, String race, Integer ageInMonths,
               String color, String description, Boolean vaccinated, Integer amountOfOwners,
               String phone, String nameOwner, byte[] photo) {
        this.id = id;
        this.dogCode = dogCode;
        this.name = name;
        this.race = race;
        this.ageInMonths = ageInMonths;
        this.color = color;
        this.description = description;
        this.vaccinated = vaccinated;
        this.amountOfOwners = amountOfOwners;
        this.phone = phone;
        this.ownerName = nameOwner;
        this.photo = photo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDogCode() {
        return dogCode;
    }

    public void setDogCode(Long dogCode) {
        this.dogCode = dogCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Integer getAgeInMonths() {
        return ageInMonths;
    }

    public void setAgeInMonths(Integer ageInMonths) {
        this.ageInMonths = ageInMonths;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(Boolean vaccinated) {
        this.vaccinated = vaccinated;
    }

    public Integer getAmountOfOwners() {
        return amountOfOwners;
    }

    public void setAmountOfOwners(Integer amountOfOwners) {
        this.amountOfOwners = amountOfOwners;
    }

    public Boolean getAdopted() {
        return isAdopted;
    }

    public void setAdopted(Boolean adopted) {
        isAdopted = adopted;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(dogCode, dog.dogCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dogCode);
    }
}
