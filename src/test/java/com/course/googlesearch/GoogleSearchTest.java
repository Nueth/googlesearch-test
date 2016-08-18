package com.course.googlesearch;

import com.course.googlesearch.testconfigs.BaseTest;
import org.junit.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.course.googlesearch.pages.GoogleSearch.*;
import static org.junit.Assert.assertEquals;


public class GoogleSearchTest extends BaseTest {
	@Test
	public void testSearchFlow() {
		visit();
		
		search("Selenium automates browsers");
		assertResultsCount(10);
		assertResultHasText(0, "Selenium automates browsers");
		
		followResult(0);
		$("#mainContent>h2").shouldBe(visible).shouldHave(exactText("What is Selenium?"));
		assertEquals("http://www.seleniumhq.org/", url());
	}
}
