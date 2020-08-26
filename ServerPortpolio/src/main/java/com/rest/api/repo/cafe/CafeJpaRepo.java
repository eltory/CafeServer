package com.rest.api.repo.cafe;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.api.domain.CafeEntity;

public interface CafeJpaRepo extends JpaRepository<CafeEntity, Long>{
	Optional<CafeEntity> findByTel(String tel);
	Optional<CafeEntity> findByName(String name);
}
