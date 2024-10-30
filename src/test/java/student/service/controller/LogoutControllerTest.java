package student.service.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogoutControllerTest {

    @Test
    public void logout_ShouldReturnLogoutMessage() {
        LogoutController logoutController = new LogoutController();

        String result = logoutController.logout(null);

        assertEquals("Вы вышли из системы", result);
    }
}