package com.course.pages;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class Google {
	public static SelenideElement page = $("#mainContent");
	
	public static void openGoogleSearch() {
		open("http://google.com/ncr");
	}
	
	public static void search(String text) {
		$("#lst-ib").setValue(text).pressEnter();
	}
	
	public static void assertResultsCount(int count) {
		$$(".srg>.g").shouldHaveSize(count);
	}
	
	public static void asssertFirstResultHasText(String text) {
		$(".srg>.g:nth-child(1)").find(".st").shouldHave(text(text));
	}
	
	public static void openFirstResult() {
		$(".srg>.g:nth-child(1)").find(".r>a").click();
	}
}
