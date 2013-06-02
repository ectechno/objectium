package com.selenium.support.core;

import org.openqa.selenium.*;

import java.util.List;

public class SeleniumObject implements WebElement {
	private By identifier;
	private WebDriver driver;

	public SeleniumObject() {
		driver = BrowserDriverProvider.getInstance().getBrowserDriver();
	}

	public void click() {
		getElement().click();
	}

	private WebElement getElement() {
		return driver.findElement(identifier);
	}

	public void submit() {
		getElement().submit();
	}

	public void sendKeys(CharSequence... charSequences) {
		getElement().sendKeys(charSequences);
	}

	public void clear() {
		getElement().clear();
	}

	public String getTagName() {
		return getElement().getTagName();
	}

	public String getAttribute(String s) {
		return getElement().getAttribute(s);
	}

	public boolean isSelected() {
		return getElement().isSelected();
	}

	public boolean isEnabled() {
		return getElement().isEnabled();
	}

	public String getText() {
		return getElement().getText();
	}

	public List<WebElement> findElements(By by) {
		return getElement().findElements(by);
	}

	public WebElement findElement(By by) {
		return getElement().findElement(by);
	}

	public boolean isDisplayed() {
		return getElement().isDisplayed();
	}

	public Point getLocation() {
		return getElement().getLocation();
	}

	public Dimension getSize() {
		return getElement().getSize();
	}

	public String getCssValue(String s) {
		return getElement().getCssValue(s);
	}

	public By getIdentifier() {
		return identifier;
	}

	public void setIdentifier(By identifier) {
		this.identifier = identifier;
	}
}
