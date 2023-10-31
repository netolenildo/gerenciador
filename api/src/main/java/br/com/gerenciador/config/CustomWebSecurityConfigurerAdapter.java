package br.com.gerenciador.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class CustomWebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.builder()
                .username("admin")
                .password("{noop}admin")
                .roles("ADMIN")
                .build();

        UserDetails comum = User.builder()
                .username("comum")
                .password("{noop}comum")
                .roles("COMUM")
                .build();

        return new InMemoryUserDetailsManager(admin,comum);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(auth ->
            auth.requestMatchers("*/usuarios","*/usuarios/*").hasRole("ADMIN")
                .requestMatchers("*/veiculos","*/veiculos/*","*/movimentacoes","*/movimentacoes/*")
                .hasAnyRole("COMUM", "ADMIN").anyRequest().authenticated()
            )
        .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
