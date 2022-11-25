package com.example.service;

public interface ProceduresService {
    void insertNamesIntoTrainerWorksIn(int trainerId, int gymId);
    void insertIntoSimulator(String simulatorName);
    void insertLinesToSimulator(int numberOfLines);
    Double callMaxSalary();
    void procCursor();
}
