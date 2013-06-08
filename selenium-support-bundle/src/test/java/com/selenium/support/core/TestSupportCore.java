/*
The MIT License (MIT)

Copyright (c) 2013 Suren Rodrigo, 99X Technology (Pvt) Ltd.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 */

package com.selenium.support.core;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class TestSupportCore {

	private final WebDriver driver;
	private final WebElement driverReturnWebElement;

	public TestSupportCore() {
		driver = mock(WebDriver.class);
		driverReturnWebElement = mock(WebElement.class);
		BrowserDriverProvider.getInstance().setDriver(driver);

	}

	@Test
	public void testSeleniumObjectSendKeys() throws Exception {
		getInputBoxForTest().sendKeys("username");
		verify(driverReturnWebElement).sendKeys("username");
	}

	@Test
	public void testSeleniumObjectClick() throws Exception {
		getButtonForTest().click();
		verify(driverReturnWebElement).click();
	}

	@Test
	public void testSeleniumObjectSubmit() throws Exception {
		getInputBoxForTest().submit();
		verify(driverReturnWebElement).submit();
	}

	@Test
	public void testSeleniumObjectClear() throws Exception {
		getInputBoxForTest().clear();
		verify(driverReturnWebElement).clear();
	}

	@Test
	public void testSeleniumObjectGetTagName() throws Exception {
		when(driverReturnWebElement.getTagName()).thenReturn("input");
		String tagName = getInputBoxForTest().getTagName();
		verify(driverReturnWebElement).getTagName();
		Assert.assertEquals(tagName, "input");

	}

	@Test
	public void testSeleniumObjectGetAttribute() throws Exception {
		when(driverReturnWebElement.getAttribute("id")).thenReturn(
				"loginUserName");
		String filedId = getInputBoxForTest().getAttribute("id");
		verify(driverReturnWebElement).getAttribute("id");
		Assert.assertEquals("loginUserName", filedId);
	}

	@Test
	public void testSeleniumObjectIsSelected() throws Exception {
		when(driverReturnWebElement.isSelected()).thenReturn(true);
		Assert.assertTrue(getInputBoxForTest().isSelected());
		verify(driverReturnWebElement).isSelected();

	}

	@Test
	public void testSeleniumObjectIsEnabled() throws Exception {
		when(driverReturnWebElement.isEnabled()).thenReturn(true);
		Assert.assertTrue(getInputBoxForTest().isEnabled());
		verify(driverReturnWebElement).isEnabled();

	}

	@Test
	public void testSeleniumObjectGetText() throws Exception {
		when(driverReturnWebElement.getText()).thenReturn("OK");
		Assert.assertEquals("OK", getButtonForTest().getText());
		verify(driverReturnWebElement).getText();

	}

	@Test
	public void testSeleniumObjectFindElements() throws Exception {
		List<WebElement> foundElementList = mock(List.class);
		By searchQuery = mock(By.class);
		when(driverReturnWebElement.findElements(searchQuery)).thenReturn(
				foundElementList);
		Assert.assertEquals(foundElementList, getInputBoxForTest()
				.findElements(searchQuery));
		verify(driverReturnWebElement).findElements(searchQuery);

	}

	@Test
	public void testSeleniumObjectFindElement() throws Exception {
		WebElement foundElement = mock(WebElement.class);
		By searchQuery = mock(By.class);
		when(driverReturnWebElement.findElement(searchQuery)).thenReturn(
				foundElement);
		Assert.assertEquals(foundElement,
				getInputBoxForTest().findElement(searchQuery));
		verify(driverReturnWebElement).findElement(searchQuery);

	}

	@Test
	public void testSeleniumObjectIsDisplayed() throws Exception {
		when(driverReturnWebElement.isDisplayed()).thenReturn(true);
		Assert.assertTrue(getInputBoxForTest().isDisplayed());
		verify(driverReturnWebElement).isDisplayed();
	}

	@Test
	public void testSeleniumObjectGetLocation() throws Exception {
		Point elementLocation = mock(Point.class);
		when(driverReturnWebElement.getLocation()).thenReturn(elementLocation);
		Assert.assertEquals(elementLocation, getButtonForTest().getLocation());
		verify(driverReturnWebElement).getLocation();

	}

	@Test
	public void testSeleniumObjectGetSize() throws Exception {
		Dimension elementSize = mock(Dimension.class);
		when(driverReturnWebElement.getSize()).thenReturn(elementSize);
		Assert.assertEquals(elementSize, getButtonForTest().getSize());
		verify(driverReturnWebElement).getSize();

	}

	@Test
	public void testSeleniumObjectGetCssValue() throws Exception {
		String displayValue = "block";
		when(driverReturnWebElement.getCssValue("display")).thenReturn(
				displayValue);
		Assert.assertEquals(displayValue,
				getInputBoxForTest().getCssValue("display"));
		verify(driverReturnWebElement).getCssValue("display");

	}

	@Test
	public void testWaitForElementToLoad() throws Exception {
		InputBox boxToBeDisplayed = getInputBoxForTest();
		when(boxToBeDisplayed.getText()).thenReturn(
				"I am a lazy loaded input text box");
		ExpectedCondition<SeleniumObject> expectedCondition = mock(ExpectedCondition.class);
		when(expectedCondition.apply(driver)).thenReturn(boxToBeDisplayed);
		InputBox inputBox = (InputBox) BrowserDriverUtil
				.waitForExpectedConditon(expectedCondition);
		Assert.assertEquals("I am a lazy loaded input text box",
				inputBox.getText());

	}

	@Test(expected = TimeoutException.class)
	public void testWaitForElementToLoadWithTimeout() throws Exception {
		ExpectedCondition<SeleniumObject> expectedCondition = mock(ExpectedCondition.class);
		when(expectedCondition.apply(driver)).thenThrow(
				NoSuchElementException.class);
		BrowserDriverUtil.waitForExpectedConditon(expectedCondition, 2);

	}

	@Test
	public void testWaitForElementTextToLoad() throws Exception {
		final InputBox inputBox = getInputBoxForTest();
		when(inputBox.getText()).thenReturn("Selenium Text");
		ExpectedCondition<Boolean> expectedCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver webDriver) {
				webDriver = BrowserDriverProvider.getInstance()
						.getBrowserDriver();
				return webDriver.findElement(inputBox.getIdentifier())
						.getText().equals("Selenium Text");
			}
		};
		Assert.assertTrue(BrowserDriverUtil
				.waitForExpectedConditon(expectedCondition));

	}

	private Button getButtonForTest() {
		By identifier = mock(By.class);
		Button button = new Button(identifier);
		when(driver.findElement(button.getIdentifier())).thenReturn(
				driverReturnWebElement);
		return button;
	}

	private InputBox getInputBoxForTest() {
		By identifier = mock(By.class);
		InputBox username = new InputBox(identifier);
		when(driver.findElement(username.getIdentifier())).thenReturn(
				driverReturnWebElement);
		return username;
	}

	public static class Button extends SeleniumObject {

		public Button(By identifier) {
			this.setIdentifier(identifier);
		}
	}

	public static class InputBox extends SeleniumObject {

		public InputBox(By identifier) {
			this.setIdentifier(identifier);
		}
	}
}
