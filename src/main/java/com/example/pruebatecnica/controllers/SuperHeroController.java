package com.example.pruebatecnica.controllers;

import com.example.pruebatecnica.dtos.SuperHeroDto;
import com.example.pruebatecnica.services.SuperHeroService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("prueba-tecnica")
public class SuperHeroController {

	private final SuperHeroService superHeroService;

	public SuperHeroController(final SuperHeroService superHeroService) {
		this.superHeroService = superHeroService;
	}

	@GetMapping("/allSuperHeroes")
	public List<SuperHeroDto> getAllSuperHeroes() {
		return this.superHeroService.getAllSuperHeroes();
	}

	@GetMapping("/superHero/{heroID}")
	public SuperHeroDto getSuperHeroById(@PathVariable final int heroID) {
		return this.superHeroService.getSuperHeroById(heroID);
	}
}
