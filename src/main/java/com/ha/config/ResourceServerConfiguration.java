package com.ha.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		super.configure(resources);
	}

	/**
	 * 아래 http 는 해당하는 주소로 접근하려고 할때 AccessToken 값이 필요하다는 것을 보여주는 것을 표시한다.
	 * 
	 * http.authorizeRequests()
		.antMatchers("admin/**").access("hasIpAddress('10.0.0.1') or hasIpAddress('10.0.0.1')")
		            .antMatchers("user/**").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')");
        http.csrf().disable();
		http.cors();

	 */
	@Override
	public void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//			.antMatchers("/t1/test1").access("#oauth2.hasScope('read')");
		http.authorizeRequests()
			.antMatchers("/t1/**")
			.authenticated();
		
//		http.authorizeRequests()
//			.antMatchers("").
	}
	
	
}
