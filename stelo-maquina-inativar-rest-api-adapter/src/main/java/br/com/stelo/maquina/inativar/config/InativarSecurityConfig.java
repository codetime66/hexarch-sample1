package br.com.stelo.maquina.inativar.config;

import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import br.com.stelo.oauth.client.config.resourceserver.OAuthResourceServer;

import br.com.stelo.oauth.client.config.resourceserver.OAuthResourceServer;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@Configuration
@EnableResourceServer
public class InativarSecurityConfig extends OAuthResourceServer {

	private static final String RESOURCE_ID = "stelo-ec";

	@Override
	@Order(-1)
	public void configure(HttpSecurity http) throws Exception {
		http
        .authorizeRequests().anyRequest().permitAll();
	}

	@Override
	public String resourceID() {
		return RESOURCE_ID;
	}

}
