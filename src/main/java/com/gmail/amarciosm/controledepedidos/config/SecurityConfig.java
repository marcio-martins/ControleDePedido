package com.gmail.amarciosm.controledepedidos.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private Environment environment;
	
	private static final String[] PUBLIC_MATCHERS = {
		"/h2-console/**"
	};
	
	private static final String[] PUBLIC_MATCHERS_GET = {
		"/produtos/**",
		"/categorias/**"
	};
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		
		// para permitir acesso do banco do java (H2)
		if(Arrays.asList(environment.getActiveProfiles()).contains("test")) {
			httpSecurity.headers().frameOptions().disable();
		}
		
		// acesso básico de multiplas fontes 
		httpSecurity.cors()
		// disabilitar proteção contra ataque CSRF, pois nossa aplicação é stateless
		.and().csrf().disable();
		
		// permite acessar sem autorizar
		httpSecurity.authorizeRequests()
			.antMatchers(HttpMethod.GET, PUBLIC_MATCHERS_GET).permitAll() // só método get
			.antMatchers(PUBLIC_MATCHERS).permitAll() // todos os métodos
			.anyRequest().authenticated();
		
		// impede criação de sessão do lado do usuário
		httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
	// definicao acesso básico de multiplas fontes 
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		return (CorsConfigurationSource) source;
	}
	
}
