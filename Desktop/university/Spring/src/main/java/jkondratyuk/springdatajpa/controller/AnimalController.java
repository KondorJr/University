package jkondratyuk.springdatajpa.controller;

import jkondratyuk.springdatajpa.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jkondratyuk.springdatajpa.dto.request.AnimalRequest;
import jkondratyuk.springdatajpa.dto.response.AnimalResponse;
import jkondratyuk.springdatajpa.exception.WrongInputDataException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/animal")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @PostMapping
    public void saveAnimal(@RequestBody AnimalRequest animalRequest) throws WrongInputDataException {
        animalService.save(animalRequest);
    }

    @GetMapping
    public List<AnimalResponse> findAll(){
      return animalService.findAll();
    }
}
