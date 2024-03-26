package org.example.selenidehabrproject.pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private static final By LOG_IN_BUTTON = By.xpath("//a/button[contains(text(), 'Войти')]");

    private static final By USER_MENU_TOGGLE_BUTTON = By.cssSelector(".tm-header-user-menu__toggle");
    private static final By POPAP_TOGGLE_WINDOW = By.cssSelector(".tm-page-settings-form");
    public void logInButtonClick(){
        $(LOG_IN_BUTTON).click();
    }
    public void userMenuToggleButtonClick() {
        $(USER_MENU_TOGGLE_BUTTON).click();
    }

    public Boolean popapToggleWindowIsDisplayed(){
        return $(POPAP_TOGGLE_WINDOW)
                .shouldBe(Condition.visible)
                .exists();
    }
}
