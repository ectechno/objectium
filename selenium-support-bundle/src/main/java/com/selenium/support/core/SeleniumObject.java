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

    private By identifier;
    private WebDriver driver;

    /**
     * Create an empty Selenium object with initialized driver.
     */
    public SeleniumObject() {
        driver = BrowserDriverProvider.getInstance().getBrowserDriver();
    }

    /**
     * {@inheritDoc}
     */
    public final void click() {
        getElement().click();
    }

    private WebElement getElement() {
        return driver.findElement(identifier);
    }

    /**
     * {@inheritDoc}
     */
    public final void submit() {
        getElement().submit();
    }

    /**
     * {@inheritDoc}
     */
    public final void sendKeys(CharSequence... charSequences) {
        getElement().sendKeys(charSequences);
    }

    /**
     * {@inheritDoc}
     */
    public final void clear() {
        getElement().clear();
    }

    /**
     * {@inheritDoc}
     */
    public final String getTagName() {
        return getElement().getTagName();
    }

    /**
     * {@inheritDoc}
     */
    public final String getAttribute(String s) {
        return getElement().getAttribute(s);
    }

    /**
     * {@inheritDoc}
     */
    public final boolean isSelected() {
        return getElement().isSelected();
    }

    /**
     * {@inheritDoc}
     */
    public final boolean isEnabled() {
        return getElement().isEnabled();
    }

    /**
     * {@inheritDoc}
     */
    public final String getText() {
        return getElement().getText();
    }

    /**
     * {@inheritDoc}
     */
    public final List<WebElement> findElements(By by) {
        return getElement().findElements(by);
    }

    /**
     * {@inheritDoc}
     */
    public final WebElement findElement(By by) {
        return getElement().findElement(by);
    }

    /**
     * {@inheritDoc}
     */
    public final boolean isDisplayed() {
        return getElement().isDisplayed();
    }

    /**
     * {@inheritDoc}
     */
    public final Point getLocation() {
        return getElement().getLocation();
    }

    /**
     * {@inheritDoc}
     */
    public final Dimension getSize() {
        return getElement().getSize();
    }

    /**
     * {@inheritDoc}
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
