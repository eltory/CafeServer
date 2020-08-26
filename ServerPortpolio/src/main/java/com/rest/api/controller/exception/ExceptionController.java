package com.rest.api.controller.exception;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.api.model.response.CommonResult;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/exception")
public class ExceptionController {
	
	@GetMapping(value = "/entrypoint")
	public CommonResult entrypointException() {
		throw new 
	}
	
	@GetMapping(value = "accessdenied")
	public CommonResult accessdeniedException() {
		throw new AccessDeniedException("");
	}
}
