package org.example.selenidehabrproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;

public class HabrSignUpPage {
    private static final By SIGN_UP_SHADOW_BOX_TITLE = By.cssSelector(".shadow-box__title");
    private static final By REGISTRATION_BUTTON = By.cssSelector("#registration_button");

    public String getSignUpShadowBoxTitle(){
        String title = $(SIGN_UP_SHADOW_BOX_TITLE).text();
        return  title;
    }
    public Boolean registrationButtonIsDisabled(){
        return $(REGISTRATION_BUTTON).isEnabled();
    }
}
