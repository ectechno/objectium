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

public abstract class SeleniumObject implements WebElement {

    private By identifier;
    private WebDriver driver;

    /**
     * Create an empty Selenium object with initialized driver.
     */
    public SeleniumObject() {
        driver = BrowserDriverProvider.getInstance().getBrowserDriver();
    }

    /**
     * Click on the element.
     * {@inheritDoc}
     */
    public void click() {
        getElement().click();
    }

    private WebElement getElement() {
        return driver.findElement(identifier);
    }

    /**
     * Submit the parent form of the element.
     * {@inheritDoc}
     */
    public void submit() {
        getElement().submit();
    }

    /**
     * Type the charSequence (String) on the element.
     * {@inheritDoc}
     */
    public void sendKeys(CharSequence... charSequences) {
        getElement().sendKeys(charSequences);
    }

    /**
     * Clear the element content.
     * {@inheritDoc}
     */
    public void clear() {
        getElement().clear();
    }

    /**
     * @return name of the element's HTML tag.
     * {@inheritDoc}
     */
    public String getTagName() {
        return getElement().getTagName();
    }

    /**
     * @return the attribute s of the element.
     * {@inheritDoc}
     */
    public String getAttribute(String s) {
        return getElement().getAttribute(s);
    }

    /**
     * @return whether the element isSelected
     * {@inheritDoc}
     */
    public boolean isSelected() {
        return getElement().isSelected();
    }

    /**
     * @return Whether the element isSelected.
     * {@inheritDoc}
     */
    public boolean isEnabled() {
        return getElement().isEnabled();
    }

    /**
     * @return the text content of the element.
     * {@inheritDoc}
     */
    public String getText() {
        return getElement().getText();
    }

    /**
     * Find a list of elements by using the given identifier.
     * @param by - identifier of the elements needed to be found
     * @return a list of elements that matches the identifier 
     * {@inheritDoc}
     */
    public List<WebElement> findElements(By by) {
        return getElement().findElements(by);
    }

    /**
     * Find a single element by using the given identifier.
     * @param by - identifier of the element needed to be found
     * @return element that matches the identifier 
     * 
     * {@inheritDoc}
     */
    public WebElement findElement(By by) {
        return getElement().findElement(by);
    }

    /**
     * @return the displayed status of the element.
     * {@inheritDoc}
     */
    public boolean isDisplayed() {
        return getElement().isDisplayed();
    }

    /**
     * @return the location of the element in the screen as a Point.
     * {@inheritDoc}
     */
    public Point getLocation() {
        return getElement().getLocation();
    }

    /**
     * @return the dimentions of the element.
     * {@inheritDoc}
     */
    public Dimension getSize() {
        return getElement().getSize();
    }

    /**
     * @return the CSS value of the css attribute s that is set within the element's styles
     * @param s - the css attribute of the element
     * * {@inheritDoc}
     */
    public String getCssValue(String s) {
        return getElement().getCssValue(s);
    }

    /**
     * Get the identifier of the object.
     * @return the identifier for the object as a By object
     */
    public By getIdentifier() {
        return identifier;
    }

    /**
     * Set the identifier of the object
     * @param identifier - Identifier of the object as a By Object
     * 
     */
    public void setIdentifier(By identifier) {
        this.identifier = identifier;
    }
}
