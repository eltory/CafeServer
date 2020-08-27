package com.rest.api.config.redis;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.CacheKeyPrefix;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.rest.api.common.CacheKey;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableCaching
@Configuration
public class RedisConfig {

	@Bean(name = "cacheManager")
	public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
		RedisCacheConfiguration configuration = RedisCacheConfiguration.defaultCacheConfig()
				.disableCachingNullValues()
				.entryTtl(Duration.ofSeconds(CacheKey.DEFAULT_EXPIRE_SEC))
				.computePrefixWith(CacheKeyPrefix.simple())
				.serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()));
	
		Map<String, RedisCacheConfiguration> cacheConfig = new HashMap<>();
		
		cacheConfig.put(CacheKey.CAFE, RedisCacheConfiguration.defaultCacheConfig()
				.entryTtl(Duration.ofSeconds(CacheKey.CAFE_EXPIRE_SEC)));
		cacheConfig.put(CacheKey.CAFES,  RedisCacheConfiguration.defaultCacheConfig()
				.entryTtl(Duration.ofSeconds(CacheKey.CAFE_EXPIRE_SEC)));
		
		return RedisCacheManager.RedisCacheManagerBuilder.fromConnectionFactory(connectionFactory)
				.cacheDefaults(configuration)
				.withInitialCacheConfigurations(cacheConfig)
				.build();
	}
}
