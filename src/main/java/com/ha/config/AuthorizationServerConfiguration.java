package com.ha.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.stereotype.Component;

@Component
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
	
	private AuthenticationManager authenticationManager;
	
	private ClientDetailsService clientDetailsService;
	private UserDetailsService usersDetailsService;
	private PasswordEncoder encoder;
	
	@Autowired
	private TokenStore tokenStore;
	
	@Autowired
	private DataSource dataSource;
	
	public AuthorizationServerConfiguration(AuthenticationConfiguration configure) throws Exception {
		this.authenticationManager = configure.getAuthenticationManager();
	}

	/**
     *  @param client = Client 에 대한 정보를 설정하는 부분 
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    	clients.jdbc(dataSource);
//        clients.inMemory()
//        	.withClient("client")
//        	.authorizedGrantTypes("password", "authorization_code", "refresh_token")
//        	.secret("secret")
//        	.scopes("all");//read
    }

    /**
     * @param OAuth2 서버가 작동하기 위한 Endpoint 에 대한 정보 설정
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
    	endpoints
    		.tokenStore(tokenStore)
    		.authenticationManager(authenticationManager);
    }
    
    /**
     * @param OAuth2 인증 서버 자체의 보안 정보를 설정하는 부분
     */    
    @Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		super.configure(security);
	}

	@Bean
    public TokenStore JdbcTokenStore(DataSource source) {
    	return new JdbcTokenStore(source);
    }
}
