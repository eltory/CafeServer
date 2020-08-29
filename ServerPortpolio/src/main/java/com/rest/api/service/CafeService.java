package com.rest.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.api.advice.exception.CafeNotFoundException;
import com.rest.api.common.CacheKey;
import com.rest.api.domain.Cafe;
import com.rest.api.repo.cafe.CafeJpaRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class CafeService {
	
	private final CafeJpaRepo cafeJpaRepo;
	private final CacheService cacheServise;
	
	@Cacheable(value = CacheKey.CAFE, key = "#name", unless = "#result == null")
	public Cafe findCafe(String name) {
		return Optional.ofNullable(cafeJpaRepo.findByName(name)).orElseThrow(CafeNotFoundException::new);
	}

	@Cacheable(value = CacheKey.CAFES, key = "#name", unless = "#result == null")
	public List<Cafe> findAllCafes(String name) {
		return cafeJpaRepo.findAllByName(findCafe(name));
	}
	
	@Cacheable(value = CacheKey.CAFE, key = "#cafeId", unless = "#result == null")
	public Cafe getCafe(long cafeId) {
		return cafeJpaRepo.findById(cafeId).orElseThrow(CafeNotFoundException::new);
	}
	
	public boolean deleteCafe(long cafeId) {
		cafeJpaRepo.delete(getCafe(cafeId));
		//cacheServise.deleteCafeCache(cafe, cafeName)
		return true;
	}
	
}
