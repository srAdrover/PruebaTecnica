package com.example.pruebatecnica.controllers;

import com.example.pruebatecnica.dtos.SuperHeroDto;
import com.example.pruebatecnica.services.SuperHeroService;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SuperHeroController {

	private final SuperHeroService superHeroService;

	public SuperHeroController(final SuperHeroService superHeroService) {
		this.superHeroService = superHeroService;
	}

	@RequestMapping("/allSuperHeroes")
	public List<SuperHeroDto> getAllSuperHeroes() {
		return this.superHeroService.getAllSuperHeroes();
	}
}
