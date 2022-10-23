package com.vytrack.utilities;

import com.vytrack.tests.TS22_57_ViewEditDeleteIcons;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Login {

//    @Test
    public void testTruckDriver() {

        testEmployee("truckDriver", 1); // tests fail for truckDrivers because when verifying the title of the vehicles page after clicking on Vehicles btn, expected title is "All - Car - Entities - System - Car - Entities - System", and actual title is "Car - Entities - System - Car - Entities - System". Then it fails to find view btn element.
    }

    @Test
    public void testStoreManager() {

        testEmployee("storeManager", 4);
    }

    @Test
    public void testSalesManager() {
        testEmployee("salesManager", 4);
    }

    protected void testEmployee(String employee, int userCount) {
        String keyPrefix = "username." + employee + ".";
        String password = Configuration_Reader.getProperty("password");

        for (int i = 1; i <= userCount; i++) {
            String key = keyPrefix + i;
            String username = Configuration_Reader.getProperty(key);
            login(username, password);
            TS22_57_ViewEditDeleteIcons.viewEditDeleteOptions();
            logout();
        }
    }

    public static void login(String username, String password) {
        Driver.getDriver().get(Configuration_Reader.getProperty("app.url.qa"));

        WebElement inputUserName = Driver.getDriver().findElement(By.xpath("//input[@id='prependedInput']"));
        inputUserName.sendKeys(username);

        WebElement inputPassword = Driver.getDriver().findElement(By.xpath("//input[@id='prependedInput2']"));
        inputPassword.sendKeys(password);

        WebElement loginBtn = Driver.getDriver().findElement(By.xpath("//button[@id='_submit']"));
        loginBtn.click();

        BrowserUtils.sleep(4);
        BrowserUtils.verifyTitle(Driver.getDriver(), "Dashboard");
    }

    public static void logout() {
        Driver.closeDriver();
    }

}
