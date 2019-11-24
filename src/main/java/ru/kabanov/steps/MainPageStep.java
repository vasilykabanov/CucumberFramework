package ru.kabanov.steps;

import org.openqa.selenium.WebElement;
import ru.kabanov.pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by yasup on 20.11.2019.
 */
public class MainPageStep {

//    @Step("выбран пункт меню Ипотека{0}")
//    public void stepIsClickedIpoteka(WebElement element){
//        new MainPage().ipoteka.click();
//    }

    @Step("Пользователь зашел на форму заполнения \"(.*)\"")
    public void stepIpotekaChoice(String item) {
        new MainPage().ipotekaChoice(item);
    }
}
