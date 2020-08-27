package com.rest.api.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Bean
	@Override
	public AuthenticationManager authenticationManager() throws Exception{
		return super.authenticationManager();
	}
	
	@Override
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers("/v2/api-docs", "/swagger-resource/**", "/swagger-ui.html", "/webjars/**",
				"/swagger/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.httpBasic().disable()	// rest api
		.csrf().disable()		// rest api
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)	// jwt token base
		.and()
		.authorizeRequests()	// next request
		.antMatchers("/*/signin", "/*/signup").permitAll()	// register, sign in for anyone
		.antMatchers(HttpMethod.GET, "hello/**").permitAll()
		.anyRequest().permitAll();
	}
	
//	@Override
//	protected void cofigure(HttpSecurity http) throws Exception{
//		http
//		.httpBasic().disable()
//		.csrf().disable()
//		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//		.and()
//		.authorizeRequests()
//		.antMatchers("/*/signin", "/*/signin/**", "/*/signup", "/*/signup/**", "/social/**").permitAll() 
//        .antMatchers(HttpMethod.GET, "/exception/**", "/helloworld/**","/actuator/health", "/v1/board/**", "/favicon.ico").permitAll(); 
//        .and()
//        .exceptionHandling().accessDeniedHandler(new CustomAccessDeniedHandler())
//        .and()
//        .exceptionHandling().authenticationEntryPoint(new CustomAuthenticationEntryPoint())
//        .and()
//        .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class);
//	}
}
