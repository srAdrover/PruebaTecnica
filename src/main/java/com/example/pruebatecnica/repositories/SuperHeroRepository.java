package com.example.pruebatecnica.repositories;

import com.example.pruebatecnica.dtos.SuperHeroDto;
import java.util.List;

public interface SuperHeroRepository {
	List<SuperHeroDto> findAllSuperHeroes();
}