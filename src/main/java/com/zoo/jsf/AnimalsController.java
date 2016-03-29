package com.zoo.jsf;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import com.zoo.model.animals.Animal;
import com.zoo.service.animals.AnimalsService;

@ManagedBean
public class AnimalsController {

	@Inject
	AnimalsService animalsService;

	private List<Animal> animals;

    @PostConstruct
    public void init() {
    	animals = animalsService.findAnimals();
    }

    public List<Animal> getAnimals() {
        return animals;
    }
}
