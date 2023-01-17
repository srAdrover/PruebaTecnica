package com.example.pruebatecnica.dtos;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SuperHeroDto {

	final int id;
	final String superHeroName;
	final String firstName;
	final String secondName;
	final String power;
}
