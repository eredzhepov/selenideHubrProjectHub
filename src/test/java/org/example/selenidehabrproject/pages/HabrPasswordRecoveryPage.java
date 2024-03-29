package org.example.selenidehabrproject.pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HabrPasswordRecoveryPage {
    private static final  By RECOVERY_FIELD = By.cssSelector("#reminder_form");
    private static final By ENTER_BUTTON = By.cssSelector(".form-additional-message__link:first-child");
    private static final By SIGN_UP_BUTTON = By.cssSelector(".form-additional-message__link:last-child");
    private static final By SUBMIT_BUTTON = By.cssSelector("button[name='go']");
    private static final By EMAIL_INPUT_FIELD = By.cssSelector("input[type='email']");
    public Boolean recoveryFieldIsDisplayed(){

        return $(RECOVERY_FIELD).exists();
    }
    public void comeBackToLoginPage(){
        $(ENTER_BUTTON)
                .click();
    }

    public void signUpButtonClick() {
        $(SIGN_UP_BUTTON)
                .shouldBe(Condition.visible)
                .click();
    }
    public Boolean subnitButtonIsDisable() {
        return $(SUBMIT_BUTTON).isEnabled();
    }

    public void setEmailInputField(String yourEmail){
        $(EMAIL_INPUT_FIELD).sendKeys(yourEmail);
    }

}
