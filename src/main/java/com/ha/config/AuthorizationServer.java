package com.ha.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.stereotype.Component;

//@Component
//@EnableAuthorizationServer
public class AuthorizationServer {

//	@Bean
//	public TokenStore JdbcTokenStore(DataSource source) {
//		return new JdbcTokenStore(source);
//	}
}
