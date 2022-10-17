package com.vytrack.tests.pin_bap;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.VYTrack_Login;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US3_UsingPinbar extends TestBase {

    @Test
    public void messages_verification_test(){
        driver.get(ConfigurationReader.getProperty("env"));

        VYTrack_Login.vy_login(driver,ConfigurationReader.getProperty("username.driver1"),ConfigurationReader.getProperty("password"));

        BrowserUtils.sleep(3);

        //location first text
        WebElement howToUseThisSpace = driver.findElement(By.xpath("//a[.='Learn how to use this space']"));
        BrowserUtils.sleep(5);
        howToUseThisSpace.sendKeys(Keys.ENTER);
        BrowserUtils.sleep(5);

        //verify user sees "How To Use Pinbar"
        WebElement howToUseThisPinbar = driver.findElement(By.xpath("//h3[text()='How To Use Pinbar']"));
        String actualText = howToUseThisPinbar.getText();

        String expectedText = "How To Use Pinbar";
        Assert.assertEquals(actualText,expectedText,"text do not match");
        //locating second text
        //verify user sees “Use the pin icon on the right top corner of the page to create fast access link in the pinbar."
        String expected = "Use the pin icon on the right top corner of the page to create fast access link in the pinbar.";
        WebElement useThePinIcon = driver.findElement(By.xpath("//p[1]"));

        System.out.println("useThePinIcon.isDisplayed() = " + useThePinIcon.isDisplayed());
        Assert.assertEquals(useThePinIcon.getText(),expected,"Text does not match");


    }
    @Test
    public void picture_verification_test(){
        //log in to VY Track page
        driver.get(ConfigurationReader.getProperty("env"));
        VYTrack_Login.vy_login(driver,ConfigurationReader.getProperty("username.store_manager1"),ConfigurationReader.getProperty("password"));

        //locating "Learn how to use this space" and navigating the link
        WebElement howToUseThisSpace = driver.findElement(By.xpath("//a[.='Learn how to use this space']"));
        BrowserUtils.sleep(5);
        howToUseThisSpace.sendKeys(Keys.ENTER);
        BrowserUtils.sleep(5);

        //verifying user sees image by comparing expected image source with actual image source
        WebElement image = driver.findElement(By.xpath("//img[1]"));
        String expectedSource = "/bundles/oronavigation/images/pinbar-location.jpg";
        String actualSource = image.getAttribute("src");
        Assert.assertTrue(actualSource.contains(expectedSource),"Image source does not match");







    }

}
