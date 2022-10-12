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

public class VerifyMainModulesManagersTC1 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test1() {
        driver.get("https://qa2.vytrack.com/user/login");
        // Step 1 - Log in with correct credentials.
        WebElement usernameInput = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        usernameInput.sendKeys("storemanager79");
        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        passwordInput.sendKeys("UserUser123");
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        // Step 2 - Verify managers should view all 8 modules names:
        //1) Dashboards:
        WebElement verifyDashboards = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
        // verifyDashboards.isDisplayed();
        Assert.assertTrue(verifyDashboards.isDisplayed());

        //2) Fleet:
        WebElement verifyFleets = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[2]"));
        Assert.assertTrue(verifyFleets.isDisplayed());

        //3) Customers:
        WebElement verifyCustomer = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[3]"));
        Assert.assertTrue(verifyCustomer.isDisplayed());

        //4) Sales:
        WebElement verifySales = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[4]"));
        Assert.assertTrue(verifySales.isDisplayed());

        //5) Activities:
        WebElement verifyActivities = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[5]"));
        Assert.assertTrue(verifyActivities.isDisplayed());

        //6) Marketing:
        WebElement verifyMarketing = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[6]"));
        Assert.assertTrue(verifyMarketing.isDisplayed());

        //7) Reports & Segments:
        WebElement verifyRepAndSeg = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[7]"));
        Assert.assertTrue(verifyRepAndSeg.isDisplayed());

        //8) System:
        WebElement verifySystem = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[8]"));
        Assert.assertTrue(verifySystem.isDisplayed());

    }
    @Test
    public void test2() {
        driver.get("https://qa2.vytrack.com/user/login");
        // Step 1 - Log in with correct credentials.
        WebElement usernameInput = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        usernameInput.sendKeys("salesmanager137");
        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        passwordInput.sendKeys("UserUser123");
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        // Step 2 - Verify managers should view all 8 modules names:
        //1) Dashboards:
        WebElement verifyDashboards = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
        // verifyDashboards.isDisplayed();
        Assert.assertTrue(verifyDashboards.isDisplayed());

        //2) Fleet:
        WebElement verifyFleets = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[2]"));
        Assert.assertTrue(verifyFleets.isDisplayed());

        //3) Customers:
        WebElement verifyCustomer = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[3]"));
        Assert.assertTrue(verifyCustomer.isDisplayed());

        //4) Sales:
        WebElement verifySales = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[4]"));
        Assert.assertTrue(verifySales.isDisplayed());

        //5) Activities:
        WebElement verifyActivities = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[5]"));
        Assert.assertTrue(verifyActivities.isDisplayed());

        //6) Marketing:
        WebElement verifyMarketing = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[6]"));
        Assert.assertTrue(verifyMarketing.isDisplayed());

        //7) Reports & Segments:
        WebElement verifyRepAndSeg = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[7]"));
        Assert.assertTrue(verifyRepAndSeg.isDisplayed());

        //8) System:
        WebElement verifySystem = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[8]"));
        Assert.assertTrue(verifySystem.isDisplayed());

    }

    @AfterMethod
    public void TearDownMethod() {
        driver.quit();
    }
}
