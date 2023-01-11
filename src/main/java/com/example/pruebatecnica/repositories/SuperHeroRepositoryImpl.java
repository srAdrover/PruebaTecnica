package com.example.pruebatecnica.repositories;

import com.example.pruebatecnica.dtos.SuperHeroDto;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class SuperHeroRepositoryImpl implements SuperHeroRepository {

	private final JdbcTemplate jdbcTemplate;

	public SuperHeroRepositoryImpl(final JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<SuperHeroDto> findAllSuperHeroes() {

		final RowMapper<SuperHeroDto> rowMapper = (sh, rowNum) -> SuperHeroDto.builder()
				.id(sh.getInt("HeroID"))
				.superHeroName(sh.getString("HeroName"))
				.firstName(sh.getString("FirstName"))
				.secondName(sh.getString("SecondName"))
				.power(sh.getString("Power"))
				.build();

		final String query = "SELECT * FROM SuperHeroes";

		return this.jdbcTemplate.query(query, rowMapper);
	}
}
