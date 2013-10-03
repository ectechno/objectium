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

/**
 * @author 99xcsro
 * BrowserDriverProvider is responsible of providing a single browser driver instance all throught the application.
 * 
 */
public final class BrowserDriverProvider {

    private static BrowserDriverProvider provider = null;

    private WebDriver driver;

    private BrowserDriverProvider() {

    }

    /**
     * Initilize and/or return a singleton BrowserDriverProivder.
     * @return A Singleton instance of the BrowserDriverProvider
     */
    public static BrowserDriverProvider getInstance() {
        if (provider == null) {
            synchronized (BrowserDriverProvider.class) {
                if (provider == null) {
                    provider = new BrowserDriverProvider();
                }
            }
        }

        return provider;

    }

    /**
     * @return current active webdriver instance
     */
    public WebDriver getBrowserDriver() {
        return driver;
    }

    
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

}
