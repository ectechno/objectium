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

    /**
     * Set a new driver instance for the BrowserDriverProvider. 
     * @param driver - Current webdriver instance
     */
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

}
