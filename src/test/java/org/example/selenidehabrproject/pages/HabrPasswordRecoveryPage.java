package org.example.selenidehabrproject.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HabrPasswordRecoveryPage {
    private static final  By RECOVERY_FIELD = By.cssSelector("#reminder_form");
    private static final By ENTER_BUTTON = By.cssSelector(".form-additional-message__link:first-child");

    public Boolean recoveryFieldIsDisplayed(){

        return $(RECOVERY_FIELD).exists();
    }
    public void comeBackToLoginPage(){
        $(ENTER_BUTTON)
                .click();

    }

}
