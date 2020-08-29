package com.rest.api.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cafe extends BaseTime implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4909704185082701381L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 100, nullable = false)
	private String name;
	
	private String localCode;
	
	private String manageNo;
	
	private String siteAddress;
	
	private String roadAddress;
	
	private String tel;
	
	private String x;
	
	private String y;
}
