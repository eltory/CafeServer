package com.rest.api.controller.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.api.domain.CafeEntity;
import com.rest.api.model.response.ListResult;
import com.rest.api.repo.cafe.CafeJpaRepo;
import com.rest.api.service.ResponseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@Api(tags = {"1. Cafe"})
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1")
public class CafeController {

	private final CafeJpaRepo cafeJpaRepo;
	private final ResponseService responseService;
	
//	@ApiImplicitParams({
//		@ApiImplicitParam(name = "X-AUTH-TOKEN", value = )
//	})
	
	@ApiOperation(value = "search cafe list", notes = "search all the cafe list")
	@GetMapping(value = "/cafes")
	public ListResult<CafeEntity> findAllCafe(){
		return responseService.getListResult(cafeJpaRepo.findAll());
	}
	
	
	
}
