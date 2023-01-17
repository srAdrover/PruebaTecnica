package com.example.pruebatecnica.services;

import static com.example.pruebatecnica.exceptions.ErrorMessage.DELETE_HERO;
import static com.example.pruebatecnica.exceptions.ErrorMessage.GET_ALL_HEROES;
import static com.example.pruebatecnica.exceptions.ErrorMessage.GET_HEROES_BY_NAMES;
import static com.example.pruebatecnica.exceptions.ErrorMessage.GET_HERO_BY_ID;
import static com.example.pruebatecnica.exceptions.ErrorMessage.UPDATE_HERO;
import static java.util.stream.Collectors.toList;

import com.example.pruebatecnica.dtos.SuperHeroDto;
import com.example.pruebatecnica.exceptions.InternalException;
import com.example.pruebatecnica.repositories.SuperHeroRepository;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class SuperHeroService {

	private final SuperHeroRepository superHeroRepository;

	public SuperHeroService(final SuperHeroRepository superHeroRepository) {

		this.superHeroRepository = superHeroRepository;
	}

	public List<SuperHeroDto> getAllSuperHeroes() throws InternalException {

		try {
			return this.superHeroRepository.findAllSuperHeroes();
		} catch (final DataAccessException dataAccessException) {
			throw InternalException.builder()
				.errorMessage(GET_ALL_HEROES)
				.exception(dataAccessException)
				.build();
		}
	}

	public SuperHeroDto getSuperHeroById(final int heroID) throws InternalException {

		try {
			return this.superHeroRepository.findHeroById(heroID);
		} catch (final EmptyResultDataAccessException dataAccessException) {
			return SuperHeroDto.builder().build();
		} catch (final DataAccessException dataAccessException) {
			throw InternalException.builder()
				.errorMessage(GET_HERO_BY_ID)
				.exception(dataAccessException)
				.build();
		}
	}

	public List<SuperHeroDto> getSuperHeroesByName(final String superHeroName) throws InternalException {

		try {
			return this.superHeroRepository.findAllSuperHeroes().stream()
				.filter(superHero -> superHero.getSuperHeroName().toLowerCase().contains(superHeroName.toLowerCase()))
				.collect(toList());
		} catch (final DataAccessException dataAccessException) {
			throw InternalException.builder()
				.errorMessage(GET_HEROES_BY_NAMES)
				.exception(dataAccessException)
				.build();
		}
	}

	public String updateSuperHero(final SuperHeroDto superHero) throws InternalException {

		try {
			final int rowsModified = this.superHeroRepository.updateSuperHero(superHero.getId(),
																			  superHero.getSuperHeroName(),
																			  superHero.getFirstName(),
																			  superHero.getSecondName(),
																			  superHero.getPower());
			return "You have updated " + rowsModified + " rows";
		} catch (final DataAccessException dataAccessException) {
			throw InternalException.builder()
				.errorMessage(UPDATE_HERO)
				.exception(dataAccessException)
				.build();
		}
	}

	public String deleteSuperHero(final int heroID) throws InternalException {

		try {
			final int rowsDeleted = this.superHeroRepository.deleteSuperHero(heroID);

			return "You have deleted " + rowsDeleted + " rows";
		} catch (final DataAccessException dataAccessException) {
			throw InternalException.builder()
				.errorMessage(DELETE_HERO)
				.exception(dataAccessException)
				.build();
		}
	}
}
