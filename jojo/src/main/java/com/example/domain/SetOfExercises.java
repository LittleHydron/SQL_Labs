package com.example.domain;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class SetOfExercises {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "date_of_start")
    private Date dateOfStart;
    @Basic
    @Column(name = "date_of_end")
    private Date dateOfEnd;
    @ManyToOne
    @JoinColumn(name = "program_id", referencedColumnName = "id", nullable = false)
    private Program programByProgramId;
    @ManyToOne
    @JoinColumn(name = "trainer_id", referencedColumnName = "id", nullable = false)
    private Trainer trainerByTrainerId;
    @ManyToOne
    @JoinColumn(name = "trainee_id", referencedColumnName = "id", nullable = false)
    private Trainee traineeByTraineeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateOfStart() {
        return dateOfStart;
    }

    public void setDateOfStart(Date dateOfStart) {
        this.dateOfStart = dateOfStart;
    }

    public Date getDateOfEnd() {
        return dateOfEnd;
    }

    public void setDateOfEnd(Date dateOfEnd) {
        this.dateOfEnd = dateOfEnd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SetOfExercises that = (SetOfExercises) o;
        return Objects.equals(id, that.id) && Objects.equals(dateOfStart, that.dateOfStart) && Objects.equals(dateOfEnd, that.dateOfEnd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateOfStart, dateOfEnd);
    }

    public Program getProgramByProgramId() {
        return programByProgramId;
    }

    public void setProgramByProgramId(Program programByProgramId) {
        this.programByProgramId = programByProgramId;
    }

    public Trainer getTrainerByTrainerId() {
        return trainerByTrainerId;
    }

    public void setTrainerByTrainerId(Trainer trainerByTrainerId) {
        this.trainerByTrainerId = trainerByTrainerId;
    }

    public Trainee getTraineeByTraineeId() {
        return traineeByTraineeId;
    }

    public void setTraineeByTraineeId(Trainee traineeByTraineeId) {
        this.traineeByTraineeId = traineeByTraineeId;
    }
}
