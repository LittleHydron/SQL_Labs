package com.example.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name="gym", schema="GYM_Database")
public class Gym {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "date_of_creation")
    private Date dateOfCreation;
    @Basic
    @Column(name = "address")
    private String address;
    @ManyToMany
    @JoinTable(name = "trainer_works_in", schema = "GYM_Database", joinColumns = @JoinColumn(name = "gym_ID", referencedColumnName = "ID", nullable = false), inverseJoinColumns = @JoinColumn(name = "trainer_ID", referencedColumnName = "ID", nullable = false))
    private Set<Trainer> trainers;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gym gym = (Gym) o;
        return Objects.equals(id, gym.id) && Objects.equals(name, gym.name) && Objects.equals(dateOfCreation, gym.dateOfCreation) && Objects.equals(address, gym.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, dateOfCreation, address);
    }

    public Set<Trainer> getTrainers() {
        return trainers;
    }

    public void setTrainers(Set<Trainer> trainers) {
        this.trainers = trainers;
    }
}
