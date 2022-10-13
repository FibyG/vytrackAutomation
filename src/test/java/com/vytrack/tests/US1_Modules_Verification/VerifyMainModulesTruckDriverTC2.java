package com.vytrack.tests.US1_Modules_Verification;

import com.vytrack.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class VerifyMainModulesTruckDriverTC2 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testCase1() {
        driver.get("https://qa2.vytrack.com/user/login");
        // Step 1 - Log in with correct credentials.
        WebElement usernameInput = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        usernameInput.sendKeys("user160");
        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        passwordInput.sendKeys("UserUser123");
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        // Step 2 - Verify drivers should view 4 modules names:
        //1) Fleet:
        WebElement verifyFleets = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
        Assert.assertTrue(verifyFleets.isDisplayed(), "Verify truck driver can see modules FAILED!");

        //2) Customers:
        WebElement verifyCustomer = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[2]"));
        Assert.assertTrue(verifyCustomer.isDisplayed(), "Verify truck driver can see modules FAILED!");

        //3) Activities:
        WebElement verifyActivities = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[3]"));
        Assert.assertTrue(verifyActivities.isDisplayed(), "Verify truck driver can see modules FAILED!");

        //4) System:
        WebElement verifySystem = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[4]"));
        Assert.assertTrue(verifySystem.isDisplayed(), "Verify truck driver can see modules FAILED!");
    }

    @AfterMethod
    public void TearDownMethod() {
        driver.quit();
    }

}
