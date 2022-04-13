package com.touchtech.programa.anime.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class PlataformaAnimeSecurity extends WebSecurityConfigurerAdapter {
// Vinculado com Controller

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.GET, "/").permitAll() // permitir acesso de todos usuarios
                .anyRequest().authenticated()
                .and().formLogin().permitAll()
                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")); //se estiver logado e quer sair do sistema
    }
//  ALTERAR USUARIO
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//        auth.inMemoryAuthentication()
//                .withUser("andre").password("123").roles("ADMIN"); // Usuario, Senha, Controle de Acesso
//    }

    @Override
    public void configure (WebSecurity web) throws Exception{
        web.ignoring().antMatchers("/materialize/**", "/style/**");

    }
}
