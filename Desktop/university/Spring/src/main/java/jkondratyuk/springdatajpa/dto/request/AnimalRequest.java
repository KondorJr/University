package jkondratyuk.springdatajpa.dto.request;

import lombok.Getter;
import lombok.Setter;
import jkondratyuk.springdatajpa.entity.PetType;

import javax.validation.constraints.NotNull;

@Getter @Setter
public class AnimalRequest {

    @NotNull
    private String nickName;

    private PetType petType;

    private Integer idPerson;

}
