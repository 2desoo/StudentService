package student.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Конфигурация безопасности для приложения.
 * Этот класс настраивает безопасность веб-приложения с использованием OAuth 2.0,
 * позволяя пользователям аутентифицироваться через сторонние провайдеры, такие как Google и GitHub.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Настраивает цепочку фильтров безопасности.
     *
     * @param http объект HttpSecurity для настройки безопасности приложения
     * @return настроенная цепочка фильтров безопасности
     * @throws Exception если произошла ошибка во время настройки безопасности
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers("/login").permitAll() // Открываем доступ к кастомной странице логина
                        .anyRequest().authenticated()) // Все остальные запросы требуют аутентификации
                .oauth2Login(oauth2 -> oauth2
                        .defaultSuccessUrl("/auth/token", true));

        // Настройка выхода
        http.logout(logout -> logout
                .logoutSuccessUrl("/login") // Перенаправление на страницу логина после выхода
                .invalidateHttpSession(true) // Инвалидация сессии
                .clearAuthentication(true)); // Очистка аутентификации
        return http.build();
    }
}