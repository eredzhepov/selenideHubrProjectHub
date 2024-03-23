package org.example.selenidehabrproject.tests;

import com.codeborne.selenide.Configuration;
import org.example.selenidehabrproject.pages.HabrPasswordRecoveryPage;
import org.example.selenidehabrproject.pages.LogInPage;
import org.example.selenidehabrproject.pages.MainPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPageTest {
    MainPage mainPage;
    LogInPage logInPage;
    HabrPasswordRecoveryPage habrPasswordRecoveryPage;
    @BeforeAll
    public static void setUppAll(){
        Configuration.browserSize ="1200x800";
    }
    @BeforeEach
    public void setUp(){
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        mainPage = page();
        logInPage = page();
        habrPasswordRecoveryPage = page();
        open("https://habr.com/ru/feed/");
    }
    @Test
    @Tag("1")
    @DisplayName("Тестирование кнопки Войти")
    public void shadowBoxFind(){
        mainPage.logInButtonClick();
        assertTrue(logInPage.shadowBoxIsVisible(), "Окно логина не отобразилось");
    }
    @Test
    @Tag("2")
    @DisplayName("Тестирование появления окна Восстановления пароля")
    public void passwordRecoveryWindowIsDisplayed() {
        mainPage.logInButtonClick();
        logInPage.clickForgotPasswordButton();
        assertTrue(habrPasswordRecoveryPage.recoveryFieldIsDisplayed(), "Попап окно Востановление пароля не появилось");
    }

    @Test
    @Tag("3")
    @DisplayName("Возврат с поля восстановления пароля на поля логина")
    public void comeBackToLogInPage() {
        mainPage.logInButtonClick();
        logInPage.clickForgotPasswordButton();
        habrPasswordRecoveryPage.comeBackToLoginPage();
        assertTrue(logInPage.shadowBoxIsVisible(), "Окно логина не отобразилось");
    }
}
