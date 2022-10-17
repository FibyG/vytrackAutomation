package com.vytrack.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class BrowserUtils {
    //Methods are static because we do not want ot create an object to use these methods. We will call this methods by class name.
    //how you all this method. BrowserUtils. sleep(3);
    public static void sleep(int seconds) {
        try {

            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Exception happened in sleep method");
        }
    }
//  Method info:
//  Name: verifyTitle()
//• Return type: void
//• Arg1: WebDriver
//• Arg2: String expectedTitle
    public static void verifyTitle(WebDriver driver, String expectedTitle){
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    //logs into Vytrack test environment
    public static void loginVytrack(){
        String username = ConfigurationReader.getProperty("username.driver1");
        String password = ConfigurationReader.getProperty("password");

        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        Driver.getDriver().findElement(By.xpath("//input[@id='prependedInput']")).sendKeys(username);
        Driver.getDriver().findElement(By.xpath("//input[@id='prependedInput2']")).sendKeys(password);

        Driver.getDriver().findElement(By.xpath("//button[@id='_submit']")).click();

    }


    //navigates vytrack calendar event page from home page
    public static void calendarEventsPage(){
        WebElement calendarEventsLink = Driver.getDriver().findElement(By.xpath("//a[@href='/calendar/event']/span"));
        WebElement activities = Driver.getDriver().findElement(By.xpath("//li[@class='dropdown dropdown-level-1'][3]/a/span"));

        activities.click();
        calendarEventsLink.click();
    }

}
