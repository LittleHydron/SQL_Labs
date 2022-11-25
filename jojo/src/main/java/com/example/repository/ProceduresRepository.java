package com.example.repository;

import com.example.domain.Simulator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface ProceduresRepository extends JpaRepository<Simulator, Integer> {
    @Procedure("InsertNamesIntoTrainerWorksIn")
    void insertNamesIntoTrainerWorksIn(int trainerId, int gymId);
    @Procedure("InsertIntoSimulator")
    void insertIntoSimulator(String simulatorName);
    @Procedure("InsertLinesToSimulator")
    void insertLinesToSimulator(int numberOfLines);
    @Procedure("CallMaxSalary")
    Double callMaxSalary();
    @Procedure("ProcCursor")
    void procCursor();
}
