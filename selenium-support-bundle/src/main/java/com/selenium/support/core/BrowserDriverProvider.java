package com.selenium.support.core;

import org.openqa.selenium.WebDriver;

public class BrowserDriverProvider {

    public static BrowserDriverProvider provider = null;
    private WebDriver driver;

    private BrowserDriverProvider() {

    }

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

    public WebDriver getBrowserDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
