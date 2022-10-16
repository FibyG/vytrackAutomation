package com.vytrack.utilities;

import org.openqa.selenium.WebDriver;
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

}
