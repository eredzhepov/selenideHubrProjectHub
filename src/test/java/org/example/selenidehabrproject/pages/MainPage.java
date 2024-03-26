package org.example.selenidehabrproject.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.conditions.Enabled;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {
    private static final By LOG_IN_BUTTON = By.xpath("//a/button[contains(text(), 'Войти')]");
    private static final By USER_MENU_TOGGLE_BUTTON = By.cssSelector(".tm-header-user-menu__toggle");
    private static final By POPAP_TOGGLE_WINDOW = By.cssSelector(".tm-page-settings-form");
    private static final By RADIO_BUTTON_ENGLISH_INTEFACE = By.cssSelector(".tm-page-settings-form .tm-page-settings-form__fieldset:nth-child(2) .tm-fieldset__container .tm-page-settings-form__input-wrapper:last-child");
    private static final By TOGLE_POPAP_WINDOW_SUMMARY = By.cssSelector(".tm-page-settings-form__title");
    private static final By SAVE_BUTTON = By.cssSelector(".btn_solid.btn_large");
    private static final By MY_FEED_SUMMARY = By.cssSelector(".tm-section-name__text");
    private static final By RADIO_BUTTON_RUSSIAN_INTERFACE = By.cssSelector(".tm-page-settings-form .tm-page-settings-form__fieldset:nth-child(2) .tm-fieldset__container .tm-page-settings-form__input-wrapper:first-child");
    private static final By SEARCH_BUTTON = By.cssSelector(".tm-svg-img.tm-header-user-menu__icon.tm-header-user-menu__icon_search.tm-header-user-menu__icon_dark");
    private static final By SERCH_FIELD = By.cssSelector(".tm-input-text-decorated__input");
    private static final By FEED_PROPERTY = By.cssSelector(".tm-navigation-filters-spoiler__button");
    private static final By MENU_LISTS = By.cssSelector(".tm-main-menu__section-content a");
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

    public void clickRadioButtonEnglishInterface(){
        $(RADIO_BUTTON_ENGLISH_INTEFACE).click();
    }

    public String getTogglePopapWidowSummary(){
        return $(TOGLE_POPAP_WINDOW_SUMMARY)
                .shouldBe(Condition.visible)
                .getText();
    }

    public void saveButtonClick(){
        $(SAVE_BUTTON)
                .shouldBe(Condition.visible)
                .click();
    }

    public String getMyFeedSummary(){
        return $(MY_FEED_SUMMARY)
                .shouldBe(Condition.visible)
                .getText();
    }

    public void clickRadioButtonRussianInterface(){
        $(RADIO_BUTTON_RUSSIAN_INTERFACE)
                .shouldBe(Condition.visible)
                .click();
    }

    public void searchButtonClick(){
        $(SEARCH_BUTTON)
                .shouldBe(Condition.visible)
                .click();
    }

    public void findYourRequest(String yourRequest){
        $(SERCH_FIELD)
                .shouldBe(Condition.visible)
                .sendKeys(yourRequest);
        $(SERCH_FIELD)
                .submit();
    }
    public String getSearchFieldText(){
        return $(SERCH_FIELD)
                .shouldBe(Condition.visible)
                .getAttribute("value");
    }

    public void clickFeedProperty(){
        $(FEED_PROPERTY)
                .shouldBe(Condition.visible)
                .click();
    }
    public Boolean feedPropertyIsDisplayed(){
        return $(FEED_PROPERTY).isDisplayed();
    }

    public void clickAllFlows(){
        $$(MENU_LISTS)
                .get(1)
                .shouldBe(Condition.visible)
                .click();
    }


}
