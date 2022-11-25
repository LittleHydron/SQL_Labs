package com.example.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name="program", schema="GYM_Database")
public class Program {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "difficulty_level")
    private Integer difficultyLevel;
    @OneToMany(mappedBy = "programByProgramId")
    private Set<SetOfExercises> setsOfExcercisesById;
    @ManyToMany(mappedBy = "programs")
    private Set<Exercise> exercises;

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

    public Integer getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDificultyLevel(Integer dificultyLevel) {
        this.difficultyLevel = dificultyLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Program program = (Program) o;
        return Objects.equals(id, program.id) && Objects.equals(name, program.name) && Objects.equals(difficultyLevel, program.difficultyLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, difficultyLevel);
    }

    public Set<SetOfExercises> getSetsOfExcercisesById() {
        return setsOfExcercisesById;
    }

    public void setSetsOfExcercisesById(Set<SetOfExercises> setsOfExcercisesById) {
        this.setsOfExcercisesById = setsOfExcercisesById;
    }

    public Set<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(Set<Exercise> exercises) {
        this.exercises = exercises;
    }
}
