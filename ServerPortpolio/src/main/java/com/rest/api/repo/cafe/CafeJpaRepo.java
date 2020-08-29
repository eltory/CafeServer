package com.rest.api.repo.cafe;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.api.domain.Cafe;

public interface CafeJpaRepo extends JpaRepository<Cafe, Long>{
	Cafe findByName(String name);
	List<Cafe> findAllByName(Cafe cafe);
}
