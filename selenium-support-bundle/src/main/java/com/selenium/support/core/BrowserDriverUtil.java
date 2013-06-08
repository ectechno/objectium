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

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author 99xcsro
 * Provides a set of extended features for the Selenium WebDriver, the methods found in this class have either enhanced an existing feature or have
 * created a whole new feature using the WebDriver
 */
public final class BrowserDriverUtil {
    private BrowserDriverUtil() {

    }

    private static final int TIMEOUT = 120;

    /**
     * Wait for certain 'expectedConditon' to be statisfied or TIMEOUT time to exceed
     * @param <T> - Type of the 'expectedCondition'
     * @param expectedCondition - an instance of ExpectedCondition
     * @return an object of type T, this is normaly what's expected in the ExpectedConditon
     * 
     */
    public static <T> T waitForExpectedConditon(ExpectedCondition<T> expectedCondition) {
        return waitForExpectedConditon(expectedCondition, TIMEOUT);
    }

    /**
     * Wait for certain 'expectedConditon' to be statisfied or 'timeout' time to exceed
     * @param <T> - Type of the 'expectedCondition'
     * @param expectedCondition - an instance of ExpectedCondition
     * @param timeout - defines how long should we wait for the ExpectedCondition in seconds
     * @return an object of type T, this is normaly what's expected in the ExpectedConditon
     */
    public static <T> T waitForExpectedConditon(ExpectedCondition<T> expectedCondition, int timeout) {
        WebDriver driver = BrowserDriverProvider.getInstance().getBrowserDriver();
        return new WebDriverWait(driver, timeout).until(expectedCondition);
    }
}
