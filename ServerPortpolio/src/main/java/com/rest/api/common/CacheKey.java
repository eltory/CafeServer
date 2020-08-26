package com.rest.api.common;

public class CacheKey {

	public static final int DEFAULT_EXPIRE_SEC = 60; 
	
	// User
    public static final String USER = "user";
    public static final int USER_EXPIRE_SEC = 60 * 5; 
    
    // Cafe
    public static final String CAFE = "post";
    public static final String CAFES = "posts";
    public static final int CAFE_EXPIRE_SEC = 60 * 5;
}
