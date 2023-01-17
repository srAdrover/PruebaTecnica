package com.example.pruebatecnica.exceptions;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class InternalException extends Exception {

	final ErrorMessage errorMessage;
	final Exception exception;
}
