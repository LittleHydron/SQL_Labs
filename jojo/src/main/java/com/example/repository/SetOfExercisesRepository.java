package com.example.repository;

import com.example.domain.SetOfExercises;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SetOfExercisesRepository extends JpaRepository<SetOfExercises, Integer> {
}
