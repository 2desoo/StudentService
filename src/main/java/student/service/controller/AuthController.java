package student.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private OAuth2AuthorizedClientService authorizedClientService;

    @GetMapping("/auth/token")
    public String getAccessToken(@AuthenticationPrincipal OAuth2User principal) {
        if (principal != null) {
            // Получаем авторизованный клиент
            OAuth2AuthorizedClient authorizedClient = authorizedClientService.loadAuthorizedClient(
                    "github", // Убедитесь, что здесь указано правильное имя вашего клиента
                    principal.getName()
            );

            if (authorizedClient != null) {
                // Извлекаем access_token
                String accessToken = authorizedClient.getAccessToken().getTokenValue();
                return accessToken;
            }
        }
        return "User not authenticated";
    }
}


