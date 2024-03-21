package org.example.selenidehabrproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

public class LogInPage {
    private static final By SHADOW_BOX = By.cssSelector(".shadow-box");
    public Boolean shadowBoxIsVisible(){

        return $(SHADOW_BOX).exists();
    }
}
