package jkondratyuk.springdatajpa.service;

import jkondratyuk.springdatajpa.entity.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jkondratyuk.springdatajpa.dto.request.AnimalRequest;
import jkondratyuk.springdatajpa.dto.response.AnimalResponse;
import jkondratyuk.springdatajpa.entity.Person;
import jkondratyuk.springdatajpa.exception.WrongInputDataException;
import jkondratyuk.springdatajpa.repository.AnimalRepository;
import jkondratyuk.springdatajpa.repository.PersonRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private PersonRepository personRepository;

    @Transactional
    public AnimalResponse save(AnimalRequest animalRequest) throws WrongInputDataException {
        Animal animal = new Animal();
        animal.setNickName(animalRequest.getNickName());
        animal.setPetType(animalRequest.getPetType());
        animal.setPerson(findPersonById(animalRequest.getIdPerson()));
        return new AnimalResponse(animalRepository.save(animal));
    }

    @Transactional
    public List<AnimalResponse> findAll(){
        return animalRepository.findAll().stream().map(AnimalResponse::new).collect(Collectors.toList());
    }


    private Person findPersonById(Integer id) throws WrongInputDataException {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if(optionalPerson.isPresent()){
            return optionalPerson.get();
        }
        throw new WrongInputDataException("Person with id : "+id+" not found");
    }
}
