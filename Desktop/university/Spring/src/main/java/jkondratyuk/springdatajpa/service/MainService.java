package jkondratyuk.springdatajpa.service;


import jkondratyuk.springdatajpa.entity.Animal;
import jkondratyuk.springdatajpa.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jkondratyuk.springdatajpa.entity.Person;
import jkondratyuk.springdatajpa.entity.PetType;
import jkondratyuk.springdatajpa.repository.PersonRepository;

import javax.transaction.Transactional;

@Service
public class MainService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AnimalRepository petRepository;

    @Transactional// manager.getTransaction.begin()------- manager.getTransaction.commit()
    public  void createInfo(){
        Person person = new Person();
        person.setFirstName("Jaroslav");
        person.setLastName("Kondratryuk");
        person.setAge(22);
        person = personRepository.save(person);

        Animal animal = new Animal();
        animal.setNickName("Archi");
        animal.setPetType(PetType.DOG);
        animal.setPerson(person);
        petRepository.save(animal);

        Animal animal2 = new Animal();
        animal2.setNickName("Berta");
        animal2.setPetType(PetType.DOG);
        animal2.setPerson(person);
        petRepository.save(animal2);
    }
    @Transactional
    public  void printAllPersons(){
        personRepository.findAll().forEach(person -> {
            System.out.println(person.getFirstName());
            System.out.println(person.getAnimals());
        });
    }
}
