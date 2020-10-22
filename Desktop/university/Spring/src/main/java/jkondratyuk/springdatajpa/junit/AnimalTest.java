package jkondratyuk.springdatajpa.junit;

import jkondratyuk.springdatajpa.entity.Animal;
import jkondratyuk.springdatajpa.entity.PetType;
import org.junit.Test;

public class AnimalTest {
    Animal animal = new Animal();

    @Test
    public void setAnimalID(){
        animal.setId(1);
    }

    @Test
    public void setAnimalName(){
        animal.setNickName("Шарик");
    }

    @Test
    public void setAnimalType(){
        animal.setPetType(PetType.DOG);
    }
}
