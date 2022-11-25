package com.example.service.impl;

import com.example.domain.Exercise;
import com.example.exception.ExerciseNotFoundException;
import com.example.repository.ExerciseRepository;
import com.example.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService {
    @Autowired
    ExerciseRepository exerciseRepository;

    @Transactional
    @Override
    public void update(Integer id, Exercise uExercise) {
        Exercise exercise = exerciseRepository.findById(id)
                .orElseThrow(() -> new ExerciseNotFoundException(id));
        //update
        exercise.setNumberOfReps(uExercise.getNumberOfReps());
        exercise.setDurationInMin(uExercise.getDurationInMin());
        exercise.setName(uExercise.getName());
        exercise.setDistanceInMeters(uExercise.getDistanceInMeters());
        exerciseRepository.save(exercise);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        Exercise exercise = exerciseRepository.findById(id)
                .orElseThrow(() -> new ExerciseNotFoundException(id));
        exerciseRepository.delete(exercise);
    }

    @Override
    public Exercise findById(Integer id) {
        return exerciseRepository.findById(id).orElseThrow(() -> new ExerciseNotFoundException(id));
    }

    @Transactional
    @Override
    public Exercise create(Exercise entity) {
        return exerciseRepository.save(entity);
    }

    @Override
    public List<Exercise> findAll() {
        return exerciseRepository.findAll();
    }
}
