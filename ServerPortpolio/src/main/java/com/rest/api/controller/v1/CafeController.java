package com.rest.api.controller.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.api.domain.Cafe;
import com.rest.api.model.response.ListResult;
import com.rest.api.service.CafeService;
import com.rest.api.service.ResponseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@Api(tags = {"1. Cafe"})
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1")
public class CafeController {

	private final CafeService cafeService;
	private final ResponseService responseService;
	
//	@ApiImplicitParams({
//		@ApiImplicitParam(name = "X-AUTH-TOKEN", value = )
//	})

	
	@ApiOperation(value = "카페이름으로 검색", notes = "카페이름으로 등록된 모든 카페검색")
	@GetMapping(value = "/cafe/{cafeName}")
	public ListResult<Cafe> findCafeByName(@PathVariable String name){
		return responseService.getListResult(cafeService.findAllCafes(name));
	}
	
	
}
