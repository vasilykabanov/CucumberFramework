package ru.kabanov.steps;

import org.openqa.selenium.WebElement;
import ru.kabanov.pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by yasup on 20.11.2019.
 */
public class MainPageStep {

    @Step("Пользователь зашел на форму заполнения \"(.*)\"")
    public void stepIpotekaChoice(String item) {
        new MainPage().subItemChoice(item);
    }
}
