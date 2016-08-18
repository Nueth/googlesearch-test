package com.course.googlesearch.pages;


import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GoogleSearch {
	public static ElementsCollection results = $$(".srg>.g");
	
	@Step
	public static void visit() {
		open("http://google.com/ncr");
	}
	
	@Step
	public static void search(String text) {
		$(By.name("q")).setValue(text).pressEnter();
	}
	
	public static void assertResultsCount(int count) {
		results.shouldHaveSize(count);
	}
	
	public static void assertResultHasText(int index, String text) {
		results.get(index).shouldHave(text(text));
	}
	
	@Step
	public static void followResult(int index) {
		results.get(index).find(".r>a").click();
	}
}
