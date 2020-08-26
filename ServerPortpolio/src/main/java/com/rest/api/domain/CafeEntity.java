package com.rest.api.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class CafeEntity extends TimeEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4909704185082701381L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 100, nullable = false)
	private String name;
	
	
	private String addressOld;
	
	private String addressNew;
	
	private String tel;
	
}
