package com.course.googlesearch.pages;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.Assert.assertEquals;

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
		results.get(index-1).shouldHave(text(text));
	}
	@Step
	public static void followResult(int index) {
		results.get(index-1).find(".r>a").click();
	}
	public static void assertCurrentUrl(String expectedUrl) {
		assertEquals(expectedUrl,url());
	}
}
