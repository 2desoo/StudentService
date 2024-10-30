package student.service.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер выхода, который обрабатывает запросы на выход из системы.
 * Этот контроллер предоставляет метод для уведомления пользователя о том, что он вышел из системы.
 */
@RestController
public class LogoutController {

    /**
     * Обрабатывает GET-запрос для выхода из системы.
     * Этот метод возвращает сообщение о том, что пользователь успешно вышел из системы.
     *
     * @param principal объект, представляющий аутентифицированного пользователя
     * @return строка с сообщением о выходе из системы
     */
    @GetMapping("/logout")
    public String logout(@AuthenticationPrincipal OAuth2User principal) {
        return "Вы вышли из системы";
    }
}
