package com.example.pruebatecnica.repositories;

import com.example.pruebatecnica.dtos.SuperHeroDto;
import java.util.List;

public interface SuperHeroRepository {
	List<SuperHeroDto> findAllSuperHeroes();

	SuperHeroDto findHeroById(final int heroId);

	List<SuperHeroDto> findSuperHeroesByyName(final String superHeroName);


}
