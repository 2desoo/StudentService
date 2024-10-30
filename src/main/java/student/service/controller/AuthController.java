package student.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер аутентификации, который обрабатывает запросы на получение токенов доступа.
 * Этот контроллер предоставляет метод для получения токенов доступа от сторонних провайдеров
 * OAuth 2.0, таких как GitHub и Google, после успешной аутентификации пользователя.
 */
@RestController
public class AuthController {

    @Autowired
    private OAuth2AuthorizedClientService authorizedClientService;


    /**
     * Обрабатывает GET-запрос для получения токенов доступа.
     * Этот метод проверяет аутентифицированного пользователя и извлекает токены доступа
     * от GitHub и Google, если они доступны. Токены возвращаются в формате строки.
     *
     * @param principal объект, представляющий аутентифицированного пользователя
     * @return строка, содержащая токены доступа для GitHub и Google
     */
    @GetMapping("/auth/token")
    public String getAccessToken(@AuthenticationPrincipal OAuth2User principal) {
        String githubAccessToken = "Not available";
        String googleAccessToken = "Not available";

        if (principal != null) {
            OAuth2AuthorizedClient githubClient = authorizedClientService.loadAuthorizedClient(
                    "github",
                    principal.getName()
            );
            if (githubClient != null) {
                githubAccessToken = githubClient.getAccessToken().getTokenValue();
            }

            OAuth2AuthorizedClient googleClient = authorizedClientService.loadAuthorizedClient(
                    "google",
                    principal.getName()
            );
            if (googleClient != null) {
                googleAccessToken = googleClient.getAccessToken().getTokenValue();
            }
        }

        // Формируем строку с результатами
        return String.format("GitHub Access Token: %s Google Access Token: %s", githubAccessToken, googleAccessToken);
    }
}


