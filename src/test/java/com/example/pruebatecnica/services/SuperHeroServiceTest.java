package com.example.pruebatecnica.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import com.example.pruebatecnica.dtos.SuperHeroDto;
import com.example.pruebatecnica.exceptions.InternalException;
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
	void getAllSuperHeroesTest() throws InternalException {

		final SuperHeroDto heroOne = SuperHeroDto.builder().id(1).build();
		final SuperHeroDto heroTwo = SuperHeroDto.builder().id(2).build();
		final SuperHeroDto heroThree = SuperHeroDto.builder().id(3).build();

		final List<SuperHeroDto> expectedHeroes = List.of(heroOne, heroTwo);
		final List<SuperHeroDto> noneExpectedHeroes = List.of(heroOne, heroThree);

		when(this.superHeroRepository.findAllSuperHeroes()).thenReturn(expectedHeroes);

		final List<SuperHeroDto> actualHeroes = this.superHeroService.getAllSuperHeroes();

		assertEquals(expectedHeroes, actualHeroes);
		assertNotEquals(noneExpectedHeroes, actualHeroes);
	}

	@Test
	void getSuperHeroByIdTest() throws InternalException {

		final SuperHeroDto expectedHeroOne = SuperHeroDto.builder().id(1).build();

		when(this.superHeroRepository.findHeroById(1)).thenReturn(expectedHeroOne);

		final SuperHeroDto actualHero = this.superHeroService.getSuperHeroById(1);

		assertEquals(expectedHeroOne, actualHero);
	}

	@Test
	void getSuperHeroesByNameTest() throws InternalException {

		final SuperHeroDto heroOne = SuperHeroDto.builder().id(1).superHeroName("Deku").build();
		final SuperHeroDto heroTwo = SuperHeroDto.builder().id(2).superHeroName("DekuTwo").build();
		final SuperHeroDto heroThree = SuperHeroDto.builder().id(3).superHeroName("AllMight").build();

		final List<SuperHeroDto> superHeroes = List.of(heroOne, heroTwo, heroThree);

		final List<SuperHeroDto> expectedHeroes = List.of(heroOne, heroTwo);

		when(this.superHeroRepository.findAllSuperHeroes()).thenReturn(superHeroes);

		final List<SuperHeroDto> actualHeroes = this.superHeroService.getSuperHeroesByName("deKU");

		assertEquals(expectedHeroes, actualHeroes);
	}

	@Test
	void updateSuperHeroByIdTest() throws InternalException {

		final SuperHeroDto superHeroToUpdate = SuperHeroDto.builder()
			.id(1)
			.superHeroName("HeroName")
			.firstName("FirstName")
			.secondName("SecondName")
			.power("Power")
			.build();

		when(this.superHeroRepository.updateSuperHero(superHeroToUpdate.getId(),
													  superHeroToUpdate.getSuperHeroName(),
													  superHeroToUpdate.getFirstName(),
													  superHeroToUpdate.getSecondName(),
													  superHeroToUpdate.getPower())).thenReturn(1);

		final String actual = this.superHeroService.updateSuperHero(superHeroToUpdate);
		final String expected = "You have updated 1 rows";

		assertEquals(expected, actual);
	}

	@Test
	void deleteSuperHeroTest() throws InternalException {

		when(this.superHeroRepository.deleteSuperHero(1)).thenReturn(1);

		final String actual = this.superHeroService.deleteSuperHero(1);

		final String expected = "You have deleted 1 rows";

		assertEquals(expected, actual);
	}

}