package com.course.googlesearch.testconfigs;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import com.google.common.io.Files;
import org.junit.After;
import org.junit.BeforeClass;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;
import java.io.IOException;

public class BaseTest {
	@BeforeClass
	public static void setup() {
		Configuration.browser = System.getProperty("driver.browser");
	}
	
	@Attachment(type = "image/png")
	public static byte[] screenshot(byte[] dataForScreenshot) {
		return dataForScreenshot;
	}
	
	@After
	public void tearDown() throws IOException {
		File SelenideScreenshot = Screenshots.takeScreenShotAsFile();
		screenshot(Files.toByteArray(SelenideScreenshot));
		
	}
}
