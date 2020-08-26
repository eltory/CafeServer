package com.rest.api.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.rest.api.common.CacheKey;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CacheService {

	@Caching(evict = {
			@CacheEvict(value = CacheKey.CAFE, key = "#cafeId"),
			@CacheEvict(value = CacheKey.CAFES, key = "#cafeName")
	})
	public boolean deleteCafeCache(long cafeId, String cafeName) {
		log.debug("deleteCafeCache - cafeId {}, cafeName {}", cafeId, cafeName);
		return true;
	}
}
