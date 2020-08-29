package com.rest.api.repo.cafe;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rest.api.domain.Cafe;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CafeJpaRepoTest {

	@Autowired
	private CafeJpaRepo cafeJpaRepo;
	
	@Test
	public void findByName_thenReturnCafes() {
		String name = "스타벅스";
		
		Optional<Cafe> cafes = cafeJpaRepo.findAllByName(name);
	
		assertNotNull(cafes);
	}
	
	@Test
	public void findByTel_thenReturnCafe() {
		String tel = "02";
	}
}
