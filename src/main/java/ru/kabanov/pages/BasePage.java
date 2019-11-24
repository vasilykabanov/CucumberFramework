package ru.kabanov.pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.kabanov.steps.BaseSteps;

/**
 * Created by yasup on 20.11.2019.
 */
public class BasePage {

    public static WebDriverWait wait;
    public static BasePage currentPage;

    public BasePage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void scrollIntoView(WebElement element) {
        waitElementIsDisplayed(element);
        ((JavascriptExecutor) BaseSteps.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // поиск элемента по Xpath, с ожиданием кликабельности елемента
    public WebElement findElementXpath(String stringXpath) {
        return new WebDriverWait(BaseSteps.getDriver(), 5000, 200)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(stringXpath)));
    }

    public void waitElementIsDisplayed(WebElement element) {
        wait = new WebDriverWait(BaseSteps.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitElementToBeClickable(WebElement element) {
        waitElementIsDisplayed(element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void fieldInput(WebElement element, String value) {
        waitElementIsDisplayed(element);
        element.clear();
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        element.sendKeys(value);
        //element.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), value);
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void compareValues(String currentValue, String expectedValue) {
        if (!currentValue.equals(expectedValue)) {
            Assert.fail(currentValue + " не равно " + expectedValue);
        }
    }
}
