package com.vytrack.tests.US1_Modules_Verification;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.VYTrack_Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;


public class VerifyMainModulesManagersTC1 extends TestBase {

    @Test
    public void test1() {
        driver.get(ConfigurationReader.getProperty("env"));
        // Step 1 - Log in with correct credentials.
        VYTrack_Login.vy_login(driver, ConfigurationReader.getProperty("username.store_manager1"), ConfigurationReader.getProperty("password"));

        // Step 2 - Verify store managers should view all 8 modules names:

        List<WebElement> mainMenuModules = new ArrayList<>(driver.findElements(By.xpath("//ul[@class='nav-multilevel main-menu']/li")));
        for (WebElement each : mainMenuModules) {
            System.out.println(each.getText());
        }
    }
    @Test
    public void test2() {
        driver.get(ConfigurationReader.getProperty("env"));
        // Step 1 - Log in with correct credentials.
        VYTrack_Login.vy_login(driver, ConfigurationReader.getProperty("username.sales_manager1"), ConfigurationReader.getProperty("password"));

        // Step 2 - Verify sales managers should view all 8 modules names:

        List<WebElement> mainMenuModules = new ArrayList<>(driver.findElements(By.xpath("//ul[@class='nav-multilevel main-menu']/li")));
        for (WebElement each : mainMenuModules) {
            System.out.println(each.getText());
        }
    }
}
