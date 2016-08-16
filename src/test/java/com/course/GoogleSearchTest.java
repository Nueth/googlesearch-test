package com.course;

import org.junit.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.course.pages.Google.*;


public class GoogleSearchTest extends BaseTest {
	@Test
	public void testSearchFlow() {
		openGoogleSearch();
		search("Selenium automates browsers");
		assertResultsCount(10);
		asssertFirstResultHasText("Selenium automates browsers");
		openFirstResult();
		page.shouldBe(visible);
	}
}
