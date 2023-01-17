package com.example.pruebatecnica.repositories;

import com.example.pruebatecnica.dtos.SuperHeroDto;
import java.util.List;

public interface SuperHeroRepository {

	List<SuperHeroDto> findAllSuperHeroes();

	SuperHeroDto findHeroById(final int heroID);

	int updateSuperHero(final int heroID,
						final String heroName,
						final String firstName,
						final String secondName,
						final String power);
}
