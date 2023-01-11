package com.example.pruebatecnica.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class SuperHeroDto {
	final int id;
	final String superHeroName;
	final String firstName;
	final String secondName;
	final String power;
}
