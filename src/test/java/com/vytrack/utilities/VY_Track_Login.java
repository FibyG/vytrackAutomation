package com.vytrack.utilities;

import com.vytrack.tests.TS22_57_ViewEditDeleteIcons;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class VY_Track_Login {

    @Test
    public void testTruckDriver() {

        testEmployee("truckDriver", 6);
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
            //           TS22_57_ViewEditDeleteIcons.viewEditDeleteOptions();
            logout();
        }
    }

    public static void login(String username, String password) {
        WebDriver driver = Driver.getDriver();
        driver.get(Configuration_Reader.getProperty("app.url.qa"));


        WebElement inputUserName = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        inputUserName.sendKeys(username);

        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        inputPassword.sendKeys(password);

        WebElement loginBtn = driver.findElement(By.xpath("//button[@id='_submit']"));
        loginBtn.click();

        BrowserUtils.sleep(4);
        BrowserUtils.verifyTitle(driver, "Dashboard");
    }

    public static void logout() {
        Driver.closeDriver();
    }

}
