package com.zoo.model.animals;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public abstract class Diet implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;

	private String carnivore;
	private String herbivore;

	public String getCarnivore() {
		return carnivore;
	}
	public void setCarnivore(String carnivore) {
		this.carnivore = carnivore;
	}
	public String getHerbivore() {
		return herbivore;
	}
	public void setHerbivore(String herbivore) {
		this.herbivore = herbivore;
	}
}