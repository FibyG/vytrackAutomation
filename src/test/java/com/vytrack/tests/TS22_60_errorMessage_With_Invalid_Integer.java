package com.vytrack.tests;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.VYTrack_Login;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TS22_60_errorMessage_With_Invalid_Integer extends TestBase {

    @Test
    public void errorMessage_With_Invalid_Integer() {
//        driver.get("https://qa1.vytrack.com/user/login");
//
//        WebElement userName = driver.findElement(By.name("_username"));
//        userName.sendKeys("storemanager79");
//
//        WebElement password = driver.findElement(By.name("_password"));
//        password.sendKeys("UserUser123" + Keys.ENTER);
        driver.get(ConfigurationReader.getProperty("env"));

        VYTrack_Login.vy_login(driver,ConfigurationReader.getProperty("username.store_manager1"),ConfigurationReader.getProperty("password"));

        WebElement activities = driver.findElement(By.xpath("//ul[@class='nav-multilevel main-menu']/li[5]"));

        Actions action = new Actions(driver);
        action.moveToElement(activities).pause(2000).perform();
        BrowserUtils.sleep(3);

      WebElement calenderPage = driver.findElement
      (By.xpath("//span[text()='Calendar Events']"));
      action.moveToElement(calenderPage).click().perform();

        WebElement createCalenderEvent = driver.findElement(By.xpath("//a[@title='Create Calendar event']"));
        action.moveToElement(createCalenderEvent).pause(2000).click().perform();

        WebElement checkBox= driver.findElement(By.xpath("//input[@data-name='recurrence-repeat']"));
        action.moveToElement(checkBox).click().perform();

        WebElement repeatDay= driver.findElement(By.xpath("//label[@class='fields-row']/input[3]"));

        repeatDay.clear();
        repeatDay.sendKeys("-1");
        WebElement Text1 = driver.findElement(By.xpath("//span/span/span[ . ='The value have not to be less than 1.']"));

        Assert.assertTrue(Text1.isDisplayed());

        BrowserUtils.sleep(3);

        repeatDay.clear();
        repeatDay.sendKeys("100");
        WebElement Text2 = driver.findElement(By.xpath("//span/span/span[ . ='The value have not to be more than 99.']"));

        Assert.assertTrue(Text2.isDisplayed());


    }

}
