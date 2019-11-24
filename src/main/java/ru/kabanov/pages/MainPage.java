package ru.kabanov.pages;

import cucumber.api.java.ru.Когда;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.kabanov.steps.BaseSteps;

import java.util.List;

/**
 * Created by yasup on 20.11.2019.
 */
public class MainPage extends BasePage {

    @FindBy(xpath = "//span[@class='lg-menu__text'][text()='Ипотека']")
    public WebElement ipoteka;

    @FindBy(xpath = "//li[@class='lg-menu__item']")
    public List<WebElement> items;

    @FindBy(xpath = "//li[@class='lg-menu__sub-item']/a")
    public List<WebElement> subItems;

    public MainPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void subItemChoice(String item) {
        waitElementIsDisplayed(ipoteka);
        ipoteka.click();
        for (WebElement element : subItems){
            if (element.getText().equals(item)){
                waitElementIsDisplayed(element);
                element.click();
                return;
            }
        }
    }
}
