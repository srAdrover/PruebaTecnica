package com.example.pruebatecnica.services;

import static java.util.stream.Collectors.toList;

import com.example.pruebatecnica.dtos.SuperHeroDto;
import com.example.pruebatecnica.repositories.SuperHeroRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SuperHeroService {

	// todo: focus exceptions

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

		return this.superHeroRepository.findAllSuperHeroes().stream()
			.filter(superHero -> superHero.getSuperHeroName().toLowerCase().contains(superHeroName.toLowerCase()))
			.collect(toList());
	}

	public String updateSuperHero(final SuperHeroDto superHero) {

		final int rowsModified = this.superHeroRepository.updateSuperHero(superHero.getId(),
																		  superHero.getSuperHeroName(),
																		  superHero.getFirstName(),
																		  superHero.getSecondName(),
																		  superHero.getPower());

		return "You have updated " + rowsModified + " rows";
	}
}
