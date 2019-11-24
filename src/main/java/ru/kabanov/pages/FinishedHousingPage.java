package ru.kabanov.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.kabanov.steps.BaseSteps;

/**
 * Created by yasup on 21.11.2019.
 */
public class FinishedHousingPage extends BasePage {

    JavascriptExecutor executeScript = (JavascriptExecutor) BaseSteps.getDriver();

    @FindBy(xpath = "//*[contains(text(),'«Сбербанк» - Ипотека на готовое жилье')]")
    public WebElement title;

    @FindBy(xpath = "//*[@class='t-header-big'][text()='​Рассчитайте ипотеку']")
    public WebElement calculateTitle;

    @FindBy(xpath = "//iframe[@id='iFrameResizer0']")
    private WebElement iFrame;

    @FindBy(id = "estateCost")
    public WebElement estateCost;

    @FindBy(id = "initialFee")
    public WebElement initialFee;

    @FindBy(id = "creditTerm")
    public WebElement creditTerm;

    @FindBy(xpath = "//input[@data-test-id='paidToCard']")
    public WebElement paidCardCheckbox;

    @FindBy(xpath = "//input[@data-test-id='canConfirmIncome']")
    private WebElement canConfirmIncomeCheckbox;

    @FindBy(xpath = "//input[@data-test-id='youngFamilyDiscount']")
    private WebElement youngFamilyDiscountCheckbox;

    @FindBy(xpath = "//span[@data-test-id='amountOfCredit']")
    private WebElement amountOfCredit;

    @FindBy(xpath = "//span[@data-test-id='monthlyPayment']")
    private WebElement monthlyPayment;

    @FindBy(xpath = "//span[@data-test-id='requiredIncome']")
    private WebElement requiredIncome;

    @FindBy(xpath = "//span[@data-test-id='rate']")
    private WebElement rate;

    public FinishedHousingPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void switchToFrame() {
        BaseSteps.getDriver().switchTo().frame(iFrame);
    }

    public void fillField(String fieldName, String fieldValue) {
        switch (fieldName) {
            case "Стоимость недвижимости":
                fieldInput(estateCost, fieldValue);
                break;
            case "Первоначальный взнос":
                fieldInput(initialFee, fieldValue);
                break;
            case "Срок кредита":
                fieldInput(creditTerm, fieldValue);
                break;
            default:
                throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице");
        }
    }

    public void isCheckedPaidCardCheckbox() {
        executeScript.executeScript("arguments[0].click();", paidCardCheckbox);
    }

    public void waitVisibilityOfElement() {
        executeScript.executeScript("arguments[0].scrollIntoView(true);", canConfirmIncomeCheckbox);
    }

    public void isCheckedYoungFamilyDiscountCheckbox() {
        executeScript.executeScript("arguments[0].click();", youngFamilyDiscountCheckbox);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getTextField(String field) {
        switch (field) {
            case "Сумма кредита":
                return amountOfCredit.getText();
            case "Ежемесячный платеж":
                return monthlyPayment.getText();
            case "Необходимый доход":
                return requiredIncome.getText();
            case "Процентная ставка":
                return rate.getText();
            default:
                throw new AssertionError("Поле не объявлено на странице");
        }
    }
}
