package com.rest.api.advice;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rest.api.service.ResponseService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestControllerAdvice
public class ExceptionAdvice {

	private final ResponseService rspService;
	
	
}
