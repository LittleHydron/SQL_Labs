package com.example.controller;

import com.example.service.ProceduresService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping(value= "/api/procedures")
public class ProceduresController {
    @Autowired
    ProceduresService proceduresService;

    @PostMapping("/insertTrainerWorksIn/{trainerId}/{gymId}")
    public ResponseEntity<?> insertNamesIntoTrainerWorksIn(@PathVariable Integer trainerId, @PathVariable Integer gymId){
        proceduresService.insertNamesIntoTrainerWorksIn(trainerId, gymId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/insertIntoSimulator/{simulatorName}")
    public ResponseEntity<?> insertIntoSimulator(@PathVariable String simulatorName){
        proceduresService.insertIntoSimulator(simulatorName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/insertLinesToSimulator/{numberOfLines}")
    public ResponseEntity<?> insertIntoSimulator(@PathVariable Integer numberOfLines){
        proceduresService.insertLinesToSimulator(numberOfLines);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/procCursor")
    public ResponseEntity<?> procCursor(){
        proceduresService.procCursor();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getMaxSalary")
    public ResponseEntity<?> getMaxSalary(){
        return new ResponseEntity<>(proceduresService.callMaxSalary(), HttpStatus.OK);
    }
}
