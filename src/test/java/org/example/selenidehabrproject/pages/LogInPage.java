package org.example.selenidehabrproject.pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LogInPage {
    private static final By SHADOW_BOX = By.cssSelector(".shadow-box");
    public Boolean shadowBoxIsVisible(){
        return $(SHADOW_BOX)
                .shouldBe(Condition.visible)
                .exists();
    }
    private static final By FORGOT_PASSWORD_BUTTON = By.cssSelector(".form__remind-password-link");
    public void clickForgotPasswordButton(){
        $(FORGOT_PASSWORD_BUTTON)
                .shouldBe(Condition.visible)
                .click();
    }


}
