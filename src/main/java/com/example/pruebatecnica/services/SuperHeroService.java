package com.example.pruebatecnica.services;

import java.util.List;
import com.example.pruebatecnica.dtos.SuperHeroDto;
import com.example.pruebatecnica.repositories.SuperHeroRepository;
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
}
