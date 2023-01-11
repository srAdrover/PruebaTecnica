package com.example.pruebatecnica.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import com.example.pruebatecnica.dtos.SuperHeroDto;
import com.example.pruebatecnica.repositories.SuperHeroRepository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SuperHeroServiceTest {

	@Mock
	private SuperHeroRepository superHeroRepository;

	@InjectMocks
	private SuperHeroService superHeroService;

	@Test
	void getAllSuperHeroesTest() {

		final SuperHeroDto heroOne = SuperHeroDto.builder().id(1).build();
		final SuperHeroDto heroTwo = SuperHeroDto.builder().id(2).build();
		final SuperHeroDto heroThree = SuperHeroDto.builder().id(3).build();

		final List<SuperHeroDto> expectedHeroes = List.of(heroOne, heroTwo);
		final List<SuperHeroDto> noneExpectedHeroes = List.of(heroOne, heroThree);

		when(superHeroRepository.findAllSuperHeroes()).thenReturn(expectedHeroes);

		final List<SuperHeroDto> actualHeroes = this.superHeroService.getAllSuperHeroes();

		assertEquals(expectedHeroes, actualHeroes);
		assertNotEquals(noneExpectedHeroes, actualHeroes);
	}

	@Test
	void getSuperHeroByIdTest() {

		final SuperHeroDto expectedHeroOne = SuperHeroDto.builder().id(1).build();

		when(superHeroRepository.findHeroById(1)).thenReturn(expectedHeroOne);

		final SuperHeroDto actualHero = this.superHeroService.getSuperHeroById(1);

		assertEquals(expectedHeroOne, actualHero);
	}

}