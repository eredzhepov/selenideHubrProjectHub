package org.example.selenidehabrproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;

public class HabrSignUpPage {
    private static final By SIGN_UP_SHADOW_BOX_TITLE = By.cssSelector(".shadow-box__title");
    private static final By REGISTRATION_BUTTON = By.cssSelector("#registration_button");
    private static final By EMAIL_INPUT_FIELD = By.cssSelector("input[type = 'email']");
    private static final By NICK_INPUT_FIELD = By.cssSelector("#nickname_field");
    private static final By PASSWORD_INPUT_FIELD = By.cssSelector("#password_field");
    private static final By REPEAT_PASSWORD_INPUT_FIELD = By.cssSelector("#password_repeat");
    public String getSignUpShadowBoxTitle(){
        String title = $(SIGN_UP_SHADOW_BOX_TITLE).text();
        return  title;
    }
    public Boolean registrationButtonIsDisabled(){
        return $(REGISTRATION_BUTTON).isEnabled();
    }
    public void setEmailInputField(String emailText){
        $(EMAIL_INPUT_FIELD).sendKeys(emailText);
    }

    public void setNickInputField(String nickText){
        $(NICK_INPUT_FIELD).sendKeys(nickText);
    }

    public void setPasswordInputField(String password){
        $(PASSWORD_INPUT_FIELD).sendKeys(password);
    }
    public void setPasswordRepeatInputField(String password){
        $(REPEAT_PASSWORD_INPUT_FIELD).sendKeys(password);
    }
}
