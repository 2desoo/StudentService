package student.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers("/api/students").permitAll()
                        .anyRequest().authenticated())
                .httpBasic(withDefaults())
                .oauth2Login(oauth2 -> oauth2
                        .loginPage("/login/oauth2/code/github") // Замените на вашу страницу входа
                        .defaultSuccessUrl("/auth/token", true) // URL после успешной аутентификации
                        .failureUrl("/login?error")); // URL при ошибке аутентификации

        return http.build();
    }
}