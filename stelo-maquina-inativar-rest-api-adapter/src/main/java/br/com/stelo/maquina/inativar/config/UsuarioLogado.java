package br.com.stelo.maquina.inativar.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class UsuarioLogado {

	private final static String USERNAME = "user_name";

	public String getUserName() {

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal.getClass() == LinkedHashMap.class) {
			Map<Object, Object> map = (Map<Object, Object>) principal;
			return map.get(USERNAME).toString();
		}

		return null;
	}	
	
}
