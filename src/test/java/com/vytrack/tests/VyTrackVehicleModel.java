package com.vytrack.tests;

import com.vytrack.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;
/*
Story5:  As a user, I want to view columns on the Vehicle models page.(web-table)

AC #1: The store manager and sales manager should see 10 columns on the Vehicle Model page.
Expected Column names:
   MODEL NAME, MAKE, CAN BE REQUESTED, CVVI, CO2 FEE (/MONTH), COST (DEPRECIATED), TOTAL COST (DEPRECIATED), CO2 EMISSIONS, FUEL TYPE, VENDORS

 */

public class VyTrackVehicleModel {
    WebDriver driver;
    @BeforeMethod
    public void setup() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        driver.get("https://qa1.vytrack.com/user/login");
    }
        @Test
                public void test1() {
        // User log in as a Store Manager
            WebElement userNameBox = driver.findElement(By.xpath("//input[@id='prependedInput']"));
            userNameBox.sendKeys("storemanager79");
            WebElement passwordBox = driver.findElement(By.xpath("//input[@type='password']"));
            passwordBox.sendKeys("UserUser123");
            WebElement logInButton = driver.findElement(By.xpath("//button[@id='_submit']"));
            logInButton.click();
            WebElement fleetButton = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[2]"));
           // WebElement fleetButton = driver.findElement(By.xpath("//ul[@class='nav-multilevel main-menu']/li[2]"));
            fleetButton.click();
            WebElement vehicles_model = driver.findElement(By.xpath("//a[.='Vehicles Model']"));
            vehicles_model.click();
            List<WebElement> allElements = driver.findElements(By.xpath("//span[@class='grid-header-cell__label']"));
            for (WebElement eachElement : allElements) {
                eachElement.isDisplayed();
            }

            }
            @Test
    public void test2(){
// User log in as a driver
                WebElement userNameBox = driver.findElement(By.xpath("//input[@id='prependedInput']"));
                userNameBox.sendKeys("user160");
                WebElement passwordBox = driver.findElement(By.xpath("//input[@type='password']"));
                passwordBox.sendKeys("UserUser123");
                WebElement logInButton = driver.findElement(By.xpath("//button[@id='_submit']"));
                logInButton.click();
                WebElement fleetButton = driver.findElement(By.xpath("//span[@class='title title-level-1']"));
                fleetButton.click();
                WebElement vehicle_model = driver.findElement(By.xpath("//a[.='Vehicles Model']"));
                vehicle_model.click();
                



            }


            }








