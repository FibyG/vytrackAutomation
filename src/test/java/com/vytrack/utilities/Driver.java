package com.vytrack.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    // Creating a private constructor, so we are closing access to the object of this class from outside classes
    private Driver() {
    }

    // Making our 'driver' instance private, so that it is not reachable from outside this class.
    // We make it static, because we want it to run before anything else, also we'll use it in static method
    private static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) { // if driver/browser was never opened

            String browserType = Configuration_Reader.getProperty("browser");

            // Depending on the browserType our switch statement will determine which browser to open
            switch (browserType) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

                case "safary":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }
        }
        // Same driver instance will be returned every time we call Driver.getDriver() method
        return driver;
    }
}
