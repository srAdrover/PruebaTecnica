package com.example.pruebatecnica.repositories;

import static java.util.Objects.nonNull;

import com.example.pruebatecnica.dtos.SuperHeroDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SuperHeroRepositoryImpl implements SuperHeroRepository {

	private final JdbcTemplate jdbcTemplate;
	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public SuperHeroRepositoryImpl(final JdbcTemplate jdbcTemplate, final NamedParameterJdbcTemplate namedParameterJdbcTemplate) {

		this.jdbcTemplate = jdbcTemplate;
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	private final static RowMapper<SuperHeroDto> rowMapper = (sh, rowNum) -> SuperHeroDto.builder()
		.id(sh.getInt("HeroID"))
		.superHeroName(sh.getString("HeroName"))
		.firstName(sh.getString("FirstName"))
		.secondName(sh.getString("SecondName"))
		.power(sh.getString("Power"))
		.build();

	@Override
	public List<SuperHeroDto> findAllSuperHeroes() {

		final String query = "SELECT * FROM SuperHeroes";

		return this.jdbcTemplate.query(query, rowMapper);
	}

	@Override
	public SuperHeroDto findHeroById(final int heroID) {

		final String query = "SELECT * FROM SuperHeroes WHERE heroID = ?";

		return this.jdbcTemplate.queryForObject(query, rowMapper, heroID);
	}

	@Override
	public int updateSuperHero(final int heroID,
							   final String heroName,
							   final String firstName,
							   final String secondName,
							   final String power) {

		final MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		final List<String> fieldsToUpdate = new ArrayList<>();

		parameterSource.addValue("heroId", heroID);

		if (nonNull(heroName)) {
			fieldsToUpdate.add("HeroName = :heroName");
			parameterSource.addValue("heroName", heroName);
		}
		if (nonNull(firstName)) {
			fieldsToUpdate.add("FirstName = :firstName");
			parameterSource.addValue("heroName", heroName);
		}
		if (nonNull(secondName)) {
			fieldsToUpdate.add("SecondName = :secondName");
			parameterSource.addValue("SecondName", secondName);
		}
		if (nonNull(power)) {
			fieldsToUpdate.add("Power = :power");
			parameterSource.addValue("Power", power);
		}

		if (!fieldsToUpdate.isEmpty()) {
			final String query = "UPDATE SuperHeroes SET " + String.join(", ", fieldsToUpdate) + " WHERE HeroId = :heroId";

			return this.namedParameterJdbcTemplate.update(query, parameterSource);
		}
		return 0;
	}
}
