package com.zoo.data.animals;

import javax.enterprise.context.ApplicationScoped;

import com.zoo.data.JpaDao;
import com.zoo.model.animals.Animal;

@ApplicationScoped
public class AnimalsDaoImpl extends JpaDao<Integer, Animal> implements AnimalsDao {

}