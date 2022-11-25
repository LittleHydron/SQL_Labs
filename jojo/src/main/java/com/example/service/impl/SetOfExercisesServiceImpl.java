package com.example.service.impl;

import com.example.domain.SetOfExercises;
import com.example.exception.SetOfExercisesNotFoundException;
import com.example.repository.SetOfExercisesRepository;
import com.example.service.SetOfExercisesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Service
public class SetOfExercisesServiceImpl implements SetOfExercisesService {
    @Autowired
    SetOfExercisesRepository setOfExercisesRepository;

    @Transactional
    @Override
    public void update(Integer id, SetOfExercises uSetOfExercises) {
        SetOfExercises setOfExercises = setOfExercisesRepository.findById(id)
                .orElseThrow(() -> new SetOfExercisesNotFoundException(id));
        //update
        setOfExercises.setProgramByProgramId(uSetOfExercises.getProgramByProgramId());
        setOfExercises.setTrainerByTrainerId(uSetOfExercises.getTrainerByTrainerId());
        setOfExercises.setTraineeByTraineeId(uSetOfExercises.getTraineeByTraineeId());
        setOfExercises.setDateOfStart(uSetOfExercises.getDateOfStart());
        setOfExercises.setDateOfEnd(uSetOfExercises.getDateOfEnd());
        setOfExercisesRepository.save(setOfExercises);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        SetOfExercises setOfExercises = setOfExercisesRepository.findById(id)
                .orElseThrow(() -> new SetOfExercisesNotFoundException(id));
        setOfExercisesRepository.delete(setOfExercises);
    }

    @Override
    public SetOfExercises findById(Integer id) {
        return setOfExercisesRepository.findById(id).orElseThrow(() -> new SetOfExercisesNotFoundException(id));
    }

    @Transactional
    @Override
    public SetOfExercises create(SetOfExercises entity) {
        return setOfExercisesRepository.save(entity);
    }

    @Override
    public List<SetOfExercises> findAll() {
        return setOfExercisesRepository.findAll();
    }
}
