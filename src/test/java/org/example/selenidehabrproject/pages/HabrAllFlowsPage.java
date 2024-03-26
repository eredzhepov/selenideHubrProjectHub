package org.example.selenidehabrproject.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HabrAllFlowsPage {
    private static final By ALL_FLOWS_SUMMARY = By.cssSelector(".tm-section-name__text");
    private static final By ALL_FLOWS_MENU_LIST = By.cssSelector(".tm-tabs__tab-link.tm-tabs__tab-link");
    private static final By ADD_COMPANY_BUTTON = By.cssSelector(".tm-suggest-button");
    public Boolean flowsSummaryIsDisplayed(){
        return $(ALL_FLOWS_SUMMARY).isDisplayed();
    }

    public int getMenuPunctsAmount(){
        $(ALL_FLOWS_SUMMARY).shouldHave(text("Все потоки"));
        return $$(ALL_FLOWS_MENU_LIST)
                .size();
    }
    public ElementsCollection getAllFlowsMenuList() {
        return $$(ALL_FLOWS_MENU_LIST);
    }
    public void elementFlowsMenuClick(int i){
        getAllFlowsMenuList().get(i - 1).click();
    }
    public void clickAddCompanyButton(){
        $(ADD_COMPANY_BUTTON)
                .shouldBe(visible)
                .click();
    }
}
