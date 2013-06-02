package com.selenium.support.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserDriverUtil {
	public static final int TIMEOUT = 120;

	public static <T> T waitForExpectedConditon(
			ExpectedCondition<T> expectedCondition) {
		return waitForExpectedConditon(expectedCondition, TIMEOUT);
	}

	public static <T> T waitForExpectedConditon(
			ExpectedCondition<T> expectedCondition, int timeout) {
		WebDriver driver = BrowserDriverProvider.getInstance()
				.getBrowserDriver();
		return new WebDriverWait(driver, timeout).until(expectedCondition);
	}
}
