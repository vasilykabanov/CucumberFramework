package ru.kabanov.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import org.openqa.selenium.WebElement;
import ru.kabanov.pages.FinishedHousingPage;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by yasup on 20.11.2019.
 */
public class ScenarioStep {

    MainPageStep mainPageStep = new MainPageStep();
    FinishedHousingPageStep finishedHousingPageStep = new FinishedHousingPageStep();

    @Когда("пользователь зашел на форму заполнения \"(.*)\"")
    public void whenIpotekaChoice(String item) {
        mainPageStep.stepIpotekaChoice(item);
    }

    @Тогда("^выполнен скролл до фрейма$")
    public void thenScrollIntoView() {
        finishedHousingPageStep.scrollIntoViewStep();
    }

    @Когда("^заполняются поля$")
    public void whenFillFields(DataTable fields) {
        finishedHousingPageStep.finishedHousingPage.switchToFrame();
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> finishedHousingPageStep.fillFieldsStep(field, value));
    }

    @Когда("^снята галочка \"есть зарплатная карта Cбербанка\"$")
    public void whenIsCheckedPaidCardCheckbox() {
        finishedHousingPageStep.isCheckedPaidCardCheckboxStep();
    }

    @Тогда("^дождаемся появления \"есть возможность подтвердить доход справкой\"$")
    public void thenWaitVisibilityOfElement() {
        finishedHousingPageStep.waitVisibilityOfElementStep();
    }

    @Тогда("^ставится галочка \"молодая семья\"$")
    public void thenIsCheckedYoungFamilyCheckbox() {
        finishedHousingPageStep.isCheckedYoungFamilyCheckboxStep();
    }

    @Тогда("^проверяются значения полей$")
    public void checkFields(DataTable dataTable) {
        dataTable.asMap(String.class, String.class)
                .forEach((field, expectedValue) -> finishedHousingPageStep.checkFillFieldsStep(field, expectedValue));
    }

}
