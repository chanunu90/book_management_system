package com.kolis3.book_management_system.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Configuration
@Log4j2
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig{

    private final DataSource dataSource;


  @Bean
  public PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }

  @Bean
  public PersistentTokenRepository persistentTokenRepository() {
      JdbcTokenRepositoryImpl repo = new JdbcTokenRepositoryImpl();
      repo.setDataSource(dataSource);
      return repo;
  }

  
    @Bean
    public SecurityFilterChain filterChain(final HttpSecurity http) throws Exception {
    
      log.info("filter chain--------------------------------");

      //http.formLogin(Customizer.withDefaults());

      // /login 경로 로그인 페이지 띄우기
      http.formLogin(config -> {
        config.loginPage("/member/signin");
      });

    //   http.exceptionHandling(
    //     config -> config.accessDeniedHandler(new CustomAccessDeniedHandler())
    //   );

    //   http.rememberMe(config -> {
    //     config.tokenRepository(persistentTokenRepository());
    //     config.tokenValiditySeconds(60*60*24*7);
    //   });

    //   http.csrf(config -> {
    //     config.disable();
    //   });

    //   http.oauth2Login(config -> {
    //     config.loginPage("/member/signin");
    //     config.successHandler(new CustomOAuthSuccessHandler());

    //   });

      return http.build();
    }


    
}
