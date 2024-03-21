package org.example.selenidehabrproject.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private static final By LOG_IN_BUTTON = By.xpath("//a/button[contains(text(), 'Войти')]");

    private static final By USER_MENU_TOGGLE_BUTTON = By.cssSelector(".tm-header-user-menu__toggle");
    public void logInButtonClick(){
        $(LOG_IN_BUTTON).click();
    }
}
