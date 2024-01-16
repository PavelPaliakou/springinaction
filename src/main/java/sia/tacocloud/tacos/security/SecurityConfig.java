package sia.tacocloud.tacos.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize -> authorize
                    .requestMatchers("/design", "/orders").hasRole("USER")
                    .requestMatchers("/", "/**").permitAll()
                    .anyRequest().authenticated()
            );

        http.formLogin(formLogin -> formLogin.loginPage("/login").permitAll());

        http.oauth2Login( oauth2Login -> oauth2Login.loginPage("/login"));

        http.logout(logout -> logout
                        .logoutSuccessUrl("/")
                        .permitAll()
        );

        return http.build();
    }
}
