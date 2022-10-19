package com.vytrack.tests.US1_Modules_Verification;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.VYTrack_Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;


public class VerifyMainModulesTruckDriverTC2 extends TestBase {


    @Test
    public void test1() {
        driver.get(ConfigurationReader.getProperty("env"));
        // Step 1 - Log in with correct credentials.
        VYTrack_Login.vy_login(driver, ConfigurationReader.getProperty("username.driver1"), ConfigurationReader.getProperty("password"));

        // Step 2 - Verify drivers should view 4 modules names:

        List<WebElement> FourModules = new ArrayList<>(driver.findElements(By.xpath("//ul[@class='nav-multilevel main-menu']/li")));
        for (WebElement each : FourModules) {
            System.out.println(each.getText());
        }

    }
}
