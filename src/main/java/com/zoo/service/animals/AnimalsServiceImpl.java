package com.zoo.service.animals;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.zoo.data.animals.AnimalsDao;
import com.zoo.model.animals.Animal;

@Stateless
public class AnimalsServiceImpl implements AnimalsService {

    @Inject
    private Logger log;

    @Inject
    private AnimalsDao animalsDao;

	@Override
	public List<Animal> findAnimals() {
		log.info("AnimalsService.findAnimals");

		return animalsDao.findAll();
	}
}
