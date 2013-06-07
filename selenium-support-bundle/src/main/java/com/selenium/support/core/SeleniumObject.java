package com.selenium.support.core;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Suren Rodrigo
 * SeleniumObject represent any element in the UI as an Selenium Object
 * You can convert any UI component object to UI object by extending from
 * SeleniumObject Class.
 */

public class SeleniumObject implements WebElement {
    /**
     * Uniquely Identifies the object.
     */
    private By identifier;

    /**
     * Webdriver that will be used within the object.
     */
    private WebDriver driver;

    /**
     * Create an empty Selenium object with initialized driver.
     */
    public SeleniumObject() {
        driver = BrowserDriverProvider.getInstance().getBrowserDriver();
    }

    /* (non-Javadoc)
     * @see org.openqa.selenium.WebElement#click()
     */
    public final void click() {
        getElement().click();
    }

    private WebElement getElement() {
        return driver.findElement(identifier);
    }

    /* (non-Javadoc)
     * @see org.openqa.selenium.WebElement#submit()
     */
    public final void submit() {
        getElement().submit();
    }

    /* (non-Javadoc)
     * @see org.openqa.selenium.WebElement#sendKeys(java.lang.CharSequence[])
     */
    public final void sendKeys(CharSequence... charSequences) {
        getElement().sendKeys(charSequences);
    }

    /* (non-Javadoc)
     * @see org.openqa.selenium.WebElement#clear()
     */
    public final void clear() {
        getElement().clear();
    }

    /* (non-Javadoc)
     * @see org.openqa.selenium.WebElement#getTagName()
     */
    public final String getTagName() {
        return getElement().getTagName();
    }

    /* (non-Javadoc)
     * @see org.openqa.selenium.WebElement#getAttribute(java.lang.String)
     */
    public final String getAttribute(String s) {
        return getElement().getAttribute(s);
    }

    /* (non-Javadoc)
     * @see org.openqa.selenium.WebElement#isSelected()
     */
    public final boolean isSelected() {
        return getElement().isSelected();
    }

    /* (non-Javadoc)
     * @see org.openqa.selenium.WebElement#isEnabled()
     */
    public final boolean isEnabled() {
        return getElement().isEnabled();
    }

    /* (non-Javadoc)
     * @see org.openqa.selenium.WebElement#getText()
     */
    public final String getText() {
        return getElement().getText();
    }

    /* (non-Javadoc)
     * @see org.openqa.selenium.WebElement#findElements(org.openqa.selenium.By)
     */
    public final List<WebElement> findElements(By by) {
        return getElement().findElements(by);
    }

    /* (non-Javadoc)
     * @see org.openqa.selenium.WebElement#findElement(org.openqa.selenium.By)
     */
    public final WebElement findElement(By by) {
        return getElement().findElement(by);
    }

    /* (non-Javadoc)
     * @see org.openqa.selenium.WebElement#isDisplayed()
     */
    public final boolean isDisplayed() {
        return getElement().isDisplayed();
    }

    /* (non-Javadoc)
     * @see org.openqa.selenium.WebElement#getLocation()
     */
    public final Point getLocation() {
        return getElement().getLocation();
    }

    /* (non-Javadoc)
     * @see org.openqa.selenium.WebElement#getSize()
     */
    public final Dimension getSize() {
        return getElement().getSize();
    }

    /* (non-Javadoc)
     * @see org.openqa.selenium.WebElement#getCssValue(java.lang.String)
     */
    public final String getCssValue(String s) {
        return getElement().getCssValue(s);
    }

    /**
     * Get the identifier of the object
     * @return the identifier for the object as a By object
     */
    public final By getIdentifier() {
        return identifier;
    }

    /**
     * Set the identifier of the object
     * @param identifier - Identifier of the object as a By Object
     * 
     */
    public final void setIdentifier(By identifier) {
        this.identifier = identifier;
    }
}
