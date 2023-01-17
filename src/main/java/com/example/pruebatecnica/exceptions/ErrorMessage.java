package com.example.pruebatecnica.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessage {

	GET_ALL_HEROES(1, "We have any problem to get all the heroes"),
	GET_HERO_BY_ID(2, "We have any problem to get you hero"),
	GET_HEROES_BY_NAMES(3, "We have any problem to get your heroes by name"),
	UPDATE_HERO(4, "We have any problem to update your hero"),
	DELETE_HERO(5, "We have any problem to delete your hero");

	private final int code;
	private final String message;

}
