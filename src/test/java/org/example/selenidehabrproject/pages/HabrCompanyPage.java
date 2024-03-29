package org.example.selenidehabrproject.pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;

public class HabrCompanyPage {
    private static final By PRICES_BOX = By.cssSelector(".tm-links");
    private static final By CONTACT_US_LINK = By.xpath("//a[contains(text(),'Контакты')]");
    private static final By CONTACT_BOX = By.cssSelector("#contacts");
    public String getCurrentUrlOfResult() {
        return webdriver().driver().getCurrentFrameUrl();
    }

    public Boolean pricesBoxIsdisplayed(){
        return $(PRICES_BOX)
                .shouldBe(Condition.visible)
                .isDisplayed();
    }

    public void clickContactUsLink(){
        $(CONTACT_US_LINK)
                .shouldBe(Condition.visible)
                .click();
    }

    public Boolean contactsBoxtsIsDisplay(){
        return $(CONTACT_BOX)
                .shouldBe(Condition.visible)
                .isDisplayed();
    }
}
