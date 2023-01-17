package com.example.pruebatecnica.controllers;

import com.example.pruebatecnica.dtos.SuperHeroDto;
import com.example.pruebatecnica.exceptions.InternalException;
import com.example.pruebatecnica.services.SuperHeroService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public List<SuperHeroDto> getAllSuperHeroes() throws InternalException {

		return this.superHeroService.getAllSuperHeroes();
	}

	@GetMapping("/superHero/{heroID}")
	public SuperHeroDto getSuperHeroById(@PathVariable final int heroID) throws InternalException {

		return this.superHeroService.getSuperHeroById(heroID);
	}

	@GetMapping("/superHeroByName/{superHeroName}")
	public List<SuperHeroDto> getSuperHeroesByName(@PathVariable final String superHeroName) throws InternalException {

		return this.superHeroService.getSuperHeroesByName(superHeroName);
	}

	@PostMapping("/updateSuperHero")
	public String updateSuperHero(@RequestBody final SuperHeroDto superHero) throws InternalException {

		return this.superHeroService.updateSuperHero(superHero);
	}

	@DeleteMapping("/deleteSuperHero/{heroID}")
	public String deleteSuperHero(@PathVariable final int heroID) throws InternalException {

		return this.superHeroService.deleteSuperHero(heroID);
	}
}
