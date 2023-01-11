package com.example.pruebatecnica.services;

import com.example.pruebatecnica.dtos.SuperHeroDto;
import com.example.pruebatecnica.repositories.SuperHeroRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SuperHeroService {

	private final SuperHeroRepository superHeroRepository;

	public SuperHeroService(final SuperHeroRepository superHeroRepository) {
		this.superHeroRepository = superHeroRepository;
	}

	public List<SuperHeroDto> getAllSuperHeroes() {

		return this.superHeroRepository.findAllSuperHeroes();
	}

	public SuperHeroDto getSuperHeroById(final int heroID) {

		return this.superHeroRepository.findHeroById(heroID);
	}

	public List<SuperHeroDto> getSuperHeroesByName(final String superHeroName) {

		return null;
	}
}
