package com.example.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name="exercise", schema="GYM_Database")
public class Exercise {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "number_of_reps")
    private Integer numberOfReps;
    @Basic
    @Column(name = "distance_in_meters")
    private Double distanceInMeters;
    @Basic
    @Column(name = "duration_in_min")
    private Integer durationInMin;
    @ManyToMany
    @JoinTable(name = "programContains", schema = "GYM_Database", joinColumns = @JoinColumn(name = "exercise_id", referencedColumnName = "id", nullable = false), inverseJoinColumns = @JoinColumn(name = "program_id", referencedColumnName = "id", nullable = false))
    private Set<Program> programs;

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

    public Integer getNumberOfReps() {
        return numberOfReps;
    }

    public void setNumberOfReps(Integer numberOfReps) {
        this.numberOfReps = numberOfReps;
    }

    public Double getDistanceInMeters() {
        return distanceInMeters;
    }

    public void setDistanceInMeters(Double distanceInMeters) {
        this.distanceInMeters = distanceInMeters;
    }

    public Integer getDurationInMin() {
        return durationInMin;
    }

    public void setDurationInMin(Integer durationInMin) {
        this.durationInMin = durationInMin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exercise exercise = (Exercise) o;
        return Objects.equals(id, exercise.id) && Objects.equals(name, exercise.name) && Objects.equals(numberOfReps, exercise.numberOfReps) && Objects.equals(distanceInMeters, exercise.distanceInMeters) && Objects.equals(durationInMin, exercise.durationInMin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, numberOfReps, distanceInMeters, durationInMin);
    }

    public Set<Program> getPrograms() {
        return programs;
    }

    public void setPrograms(Set<Program> programs) {
        this.programs = programs;
    }
}
