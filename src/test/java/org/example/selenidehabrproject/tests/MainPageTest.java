package org.example.selenidehabrproject.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import org.example.selenidehabrproject.pages.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.jupiter.api.Assertions.*;

public class MainPageTest {
    MainPage mainPage;
    LogInPage logInPage;
    HabrPasswordRecoveryPage habrPasswordRecoveryPage;
    HabrSignUpPage habrSignUpPage;
    HabrAllFlowsPage habrAllFlowsPage;
    @BeforeAll
    public static void setUppAll(){
        Configuration.browserSize ="1200x800";
    }
    @BeforeEach
    public void setUp(){

        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        Configuration.browserCapabilities = new ChromeOptions().setPageLoadStrategy(PageLoadStrategy.EAGER);
        mainPage = page();
        logInPage = page();
        habrPasswordRecoveryPage = page();
        habrSignUpPage = page();
        habrAllFlowsPage = page();
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
    @Test
    @Tag("4")
    @DisplayName("Переход в окно регистрации с попап окна Восстановление пароля")
    public void goToSignUpFromRecoveryPassswordWindow() {
        String actualTitle = "Регистрация";
        mainPage.logInButtonClick();
        logInPage.clickForgotPasswordButton();
        habrPasswordRecoveryPage.signUpButtonClick();
        assertEquals(actualTitle, habrSignUpPage.getSignUpShadowBoxTitle(), "Заголовок на странице регистрации не совпадает");
    }
    @Test
    @Tag("5")
    @DisplayName("Восстановление пароля, кнопка Отправить не активна")
    public void recoveryPageSendButtonIsDisabled() {
        mainPage.logInButtonClick();
        logInPage.clickForgotPasswordButton();
        assertFalse(habrPasswordRecoveryPage.subnitButtonIsDisable(), "Кнопка Отправить активна");
    }
    @Test
    @Tag("6")
    @DisplayName("Восстановление пароля, кнопка Отправить активна если в инпут ввести любой текст")
    public void recoveryPageSendButtonIsEnable() {
        String yourEmail = "usertestovich@mail.ru";
        mainPage.logInButtonClick();
        logInPage.clickForgotPasswordButton();
        habrPasswordRecoveryPage.setEmailInputField(yourEmail);
        assertTrue(habrPasswordRecoveryPage.subnitButtonIsDisable(), "Кнопка Отправить не активна");
    }
    @Test
    @Tag("7")
    @DisplayName("Регистрация, кнопка Зарегестрировать  не активна если в инпутgens не заполнены")
    public void signUpButtonIsDisabled() {
        mainPage.logInButtonClick();
        logInPage.clickForgotPasswordButton();
        habrPasswordRecoveryPage.signUpButtonClick();
        assertFalse(habrSignUpPage.registrationButtonIsDisabled(), "Кнопка Зарегестрироваться активна");
    }
    @Test
    @Tag("8")
    @DisplayName("Регистрация, кнопка Зарегестрировать   активна если все инпуты заполнены")
    public void signUpButtonIsEnable() {
        String yourEmail = "usertestovich@mail.ru";
        String yourNick = "monk";
        String yourPassword = "12345678";
        mainPage.logInButtonClick();
        logInPage.clickForgotPasswordButton();
        habrPasswordRecoveryPage.signUpButtonClick();
        habrSignUpPage.setEmailInputField(yourEmail);
        habrSignUpPage.setNickInputField(yourNick);
        habrSignUpPage.setPasswordInputField(yourPassword);
        habrSignUpPage.setPasswordRepeatInputField(yourPassword);
        assertTrue(habrSignUpPage.registrationButtonIsDisabled(), "Кнопка Зарегестрироваться не активна");
    }
    @Test
    @Tag("9")
    @DisplayName("Появление Попап окна с настройками страницы ")
    public void totgglePopapWindowArize() {
        mainPage.userMenuToggleButtonClick();
        assertTrue(mainPage.popapToggleWindowIsDisplayed(), "Попап окно с настройками не появилось");
    }
    @Test
    @Tag("10")
    @DisplayName("Смена языка интерфейса")
    public void switchInterfaceLanguage() {
        String expectedlChangedToggleSummary = "Page settings";
        mainPage.userMenuToggleButtonClick();
        mainPage.clickRadioButtonEnglishInterface();
        assertEquals(expectedlChangedToggleSummary, mainPage.getTogglePopapWidowSummary(), "Заголовок интерфейса не соответствует");
    }
    @Test
    @Tag("11")
    @DisplayName("Сохранение изменений языка интерфейса")
    public void changeInterfaceLanguage() {
        String expectedlMyFeedSummary = "My feed";
        mainPage.userMenuToggleButtonClick();
        mainPage.clickRadioButtonEnglishInterface();
        mainPage.saveButtonClick();
        assertEquals(expectedlMyFeedSummary, mainPage.getMyFeedSummary(), "Заголовок на странице не соответствует, язык не изменен");
    }
    @Test
    @Tag("12")
    @DisplayName("Возвращение текущих настроек - изменений языка интерфейса")
    public void changeInterfaceLanguage1() {
        String expectedlMyFeedSummary = "Моя лента";
        mainPage.userMenuToggleButtonClick();
        mainPage.clickRadioButtonRussianInterface();
        mainPage.saveButtonClick();
        assertEquals(expectedlMyFeedSummary, mainPage.getMyFeedSummary(), "Заголовок на странице не соответствует, язык не изменен");
    }
    @Test
    @Tag("13")
    @DisplayName("При помощи поиска, ввести  и отправить запрос")
    public void findRequst() {
        String yourRequest = "Reforge";
        mainPage.searchButtonClick();
        mainPage.findYourRequest(yourRequest);
        assertEquals(yourRequest, mainPage.getSearchFieldText(), "Текст в поле поиска не соответствует");
    }
    @Test
    @Tag("14")
    @DisplayName("Раскрытие настроек ленты")
    public void openFeedProperty() {
        mainPage.clickFeedProperty();
        assertTrue(mainPage.feedPropertyIsDisplayed(), "Окно с настройками не отобразились");
    }
    @Test
    @Tag("15")
    @DisplayName("Заголовок на странице с потоками - отображается")
    public void flowsSuammaryDisplay() {
        mainPage.clickAllFlows();
        assertTrue(habrAllFlowsPage.flowsSummaryIsDisplayed(), "Заголовок на странице с потоками не отобразился");
    }
    @Test
    @Tag("16")
    @DisplayName("Все 6 пунктов меню на вкладке все потоки")
    public void allMenuItemsAtTheAllflowsPage() {
        int expectedAmount = 6;
        mainPage.clickAllFlows();
        assertEquals(expectedAmount, habrAllFlowsPage.getMenuPunctsAmount(), "Количество пунктов меню не совпадает");
    }
    @Test
    @Tag("17")
    @DisplayName("Соответствие всех пунктов меню ")
    public void equalityAllMenuItemsAtTheAllflowsPage() {
        String[] expectedMenuPunctsArr = {"Статьи", "Посты", "Новости", "Хабы", "Авторы", "Компании"};
        int amount = habrAllFlowsPage.getAllFlowsMenuList().size();
        ElementsCollection actualMenuPunct = habrAllFlowsPage.getAllFlowsMenuList();
        String[] actualMenuPuncts = {};
        for(int i = 0; i < amount; i++){
            actualMenuPuncts[i] = actualMenuPunct.get(i).getText();
        }
        mainPage.clickAllFlows();
        for(int i = 0; i < amount; i++){
            assertEquals(expectedMenuPunctsArr[i],  actualMenuPuncts[i], "Пункты меню не совпадают");
        }
    }

}
