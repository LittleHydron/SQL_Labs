package com.example.domain;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name="trainer", schema="GYM_Database")
public class Trainer {
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
    @Column(name = "salary_in_dollars")
    private Double salaryInDollars;
    @OneToMany(mappedBy = "trainerByTrainerId")
    private Set<SetOfExercises> setOfExercisesById;
    @OneToMany(mappedBy = "trainer")
    private Set<Trainee> traineesById;
    @ManyToMany(mappedBy = "trainers")
    private Set<Gym> gyms;

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

    public Double getSalaryInDollars() {
        return salaryInDollars;
    }

    public void setSalaryInDollars(Double salaryInDollars) {
        this.salaryInDollars = salaryInDollars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trainer trainer = (Trainer) o;
        return Objects.equals(id, trainer.id) && Objects.equals(name, trainer.name) && Objects.equals(dateOfRegistration, trainer.dateOfRegistration) && Objects.equals(salaryInDollars, trainer.salaryInDollars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, dateOfRegistration, salaryInDollars);
    }

    public Set<SetOfExercises> getSetOfExercisesById() {
        return setOfExercisesById;
    }

    public void setSetOfExercisesById(Set<SetOfExercises> setOfExercisesById) {
        this.setOfExercisesById = setOfExercisesById;
    }

    public Set<Trainee> getTraineesById() {
        return traineesById;
    }

    public void setTraineesById(Set<Trainee> traineesById) {
        this.traineesById = traineesById;
    }

    public Set<Gym> getGyms() {
        return gyms;
    }

    public void setGyms(Set<Gym> gyms) {
        this.gyms = gyms;
    }
}
