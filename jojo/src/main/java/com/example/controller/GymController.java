package com.example.controller;

import com.example.domain.Gym;
import com.example.domain.Trainer;
import com.example.dto.GymDto;
import com.example.dto.GymTrainerDto;
import com.example.dto.assembler.GymDtoAssembler;
import com.example.service.GymService;
import com.example.service.TrainerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/gyms")
public class GymController {
    @Autowired
    private final GymService gymService;
    @Autowired
    private final TrainerService trainerService;
    @Autowired
    private final GymDtoAssembler gymDtoAssembler;

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    @PostMapping(value = "")
    public ResponseEntity<GymDto> addGym(@RequestBody GymDto gymDto) {
        Gym gym = new Gym();
        gym.setName(gymDto.getName());
        gym.setId(gymDto.getId());
        gym.setAddress(gymDto.getAddress());
        gym.setDateOfCreation(gymDto.getDateOfCreation());
        Set<Trainer> set = new HashSet<>();
        gymDto.getTrainersIds().forEach(id -> set.add(trainerService.findById(id)));
        gym.setTrainers(set);
        gym = gymService.create(gym);
        gymDto = gymDtoAssembler.toModel(gym);
        return new ResponseEntity<>(gymDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{gymId}")
    public ResponseEntity<?> updateGym(@RequestBody GymDto gymDto, @PathVariable Integer gymId) {
        Gym gym = new Gym();
        gym.setName(gymDto.getName());
        gym.setId(gymDto.getId());
        gym.setAddress(gymDto.getAddress());
        gym.setDateOfCreation(gymDto.getDateOfCreation());
        Set<Trainer> set = new HashSet<>();
        gymDto.getTrainersIds().forEach(id -> set.add(trainerService.findById(id)));
        gym.setTrainers(set);
        gymService.update(gymId, gym);
        return new ResponseEntity<>(gymDto, HttpStatus.OK);
    }

    @PutMapping(value="/add")
    public ResponseEntity<?> addTrainerToGym(@RequestBody GymTrainerDto gymTrainerDto){
        jdbcTemplate.update("INSERT trainer_works_in(gym_id, trainer_id) VALUES(?, ?)",
                gymTrainerDto.getGymId(), gymTrainerDto.getTrainerId());
        return new ResponseEntity<>(gymDtoAssembler.toModel(gymService.findById(gymTrainerDto.getGymId())), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{gymId}")
    public ResponseEntity<?> deleteGym(@PathVariable Integer gymId) {
        gymService.delete(gymId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{gymId}")
    public ResponseEntity<GymDto> getGym(@PathVariable Integer gymId) {
        Gym gym = gymService.findById(gymId);
        GymDto gymDto = gymDtoAssembler.toModel(gym);
        return new ResponseEntity<>(gymDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<GymDto>> getAllGyms() {
        List<Gym> gyms = gymService.findAll();
        CollectionModel<GymDto> gymsDtos = gymDtoAssembler.toCollectionModel(gyms);
        return new ResponseEntity<>(gymsDtos, HttpStatus.OK);
    }
}

