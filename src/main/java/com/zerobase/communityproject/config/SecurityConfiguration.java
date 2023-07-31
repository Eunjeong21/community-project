package com.zerobase.communityproject.config;

import com.zerobase.communityproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class SecurityConfiguration {
  private final UserService userService;

  @Bean
  PasswordEncoder getPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }
  @Bean
  UserAuthenticationFailureHandler getFailureHandler() {
    return new UserAuthenticationFailureHandler();
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.csrf((csrf) -> csrf.disable());
    http
        .authorizeHttpRequests((request) -> request
        .requestMatchers("read/**", "user/register").permitAll()
        .requestMatchers("create/**", "update/**", "delete/**").hasAnyRole("USER")
        .anyRequest().permitAll()
    );
    http
        .formLogin(formLogin -> formLogin
        .loginPage("/login")
        .failureHandler(getFailureHandler())
        .permitAll()
    );
    http
        .logout((logout) ->
        logout.deleteCookies("remove")
            .invalidateHttpSession(false)
            .logoutUrl("/logout")
            .logoutSuccessUrl("/logout-complete")
    );
    return http.build();
  }
  public void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userService).passwordEncoder(getPasswordEncoder());
  }



}
