package com.example.domain;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name="trainee", schema="GYM_Database")
public class Trainee {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "date_of_registration")
    private Date dateOfRegistration;
    @Basic
    @Column(name = "telephone_number")
    private String telephoneNumber;
    @OneToMany(mappedBy = "traineeByTraineeId")
    private Set<SetOfExercises> setsOfExcercisesById;
    @ManyToOne
    @JoinColumn(name = "trainer_id", referencedColumnName = "id", nullable = false)
    private Trainer trainer;

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

    public Date getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(Date dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trainee trainee = (Trainee) o;
        return Objects.equals(id, trainee.id) && Objects.equals(name, trainee.name) && Objects.equals(dateOfRegistration, trainee.dateOfRegistration) && Objects.equals(telephoneNumber, trainee.telephoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, dateOfRegistration, telephoneNumber);
    }

    public Set<SetOfExercises> getSetsOfExcercisesById() {
        return setsOfExcercisesById;
    }

    public void setSetsOfExcercisesById(Set<SetOfExercises> setsOfExcercisesById) {
        this.setsOfExcercisesById = setsOfExcercisesById;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }
}
