package ru.kabanov.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.kabanov.pages.FinishedHousingPage;
import ru.yandex.qatools.allure.annotations.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertTrue;

/**
 * Created by yasup on 21.11.2019.
 */
public class FinishedHousingPageStep {

    FinishedHousingPage finishedHousingPage = new FinishedHousingPage();

    @Step("выполнен скролл до элемента")
    public void scrollIntoViewStep() {
        finishedHousingPage.scrollIntoView(finishedHousingPage.calculateTitle);
    }

    @Step("поле {0} заполняется значением {1}")
    public void fillFieldsStep(String field, String value) {
        finishedHousingPage.fillField(field, value);
    }

    @Step("снимается галочка \"есть зарплатная карта Cбербанка\"")
    public void isCheckedPaidCardCheckboxStep() {
        finishedHousingPage.isCheckedPaidCardCheckbox();
    }

    @Step("дождаемся появления \"есть возможность подтвердить доход справкой\"")
    public void waitVisibilityOfElementStep() {
        finishedHousingPage.waitVisibilityOfElement();
    }

    @Step("ставится галочка \"молодая семья\"")
    public void isCheckedYoungFamilyCheckboxStep() {
        finishedHousingPage.isCheckedYoungFamilyDiscountCheckbox();
    }

    @Step("поле {0} заполнено значением {1}")
    public void checkFillFieldsStep(String field, String expectedValue) {
        String actualValue = finishedHousingPage.getTextField(field);
        Assert.assertEquals("В поле " + field + " актуальное значение равно - " + actualValue + ". Ожидалось " + expectedValue,
                expectedValue, actualValue);

    }
}
