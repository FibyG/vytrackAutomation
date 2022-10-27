package com.vytrack.tests;


import com.cydeo.utilities.ConfigurationReader;
import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VYTrack_Utils;
import com.vytrack.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.w3c.dom.Text;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class VyTrackVehicleModel {
    /*
    Story5:  As a user, I want to view columns on the Vehicle models page.(web-table)
    AC #1: The store manager and sales manager should see 10 columns on the Vehicle Model page.
    Expected Column names:
    MODEL NAME, MAKE, CAN BE REQUESTED, CVVI, CO2 FEE (/MONTH), COST (DEPRECIATED), TOTAL COST (DEPRECIATED), CO2 EMISSIONS, FUEL TYPE, VENDORS


     */
    @Test
    public void view_column_on_vehicle_module_store_manager() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

        VYTrack_Utils.vy_login(Driver.getDriver(), ConfigurationReader.getProperty("username.store_manager2"), ConfigurationReader.getProperty("password"));


        WebElement fleetButton = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[2]"));
        BrowserUtils.sleep(2);
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(fleetButton).perform();
        BrowserUtils.sleep(2);

        WebElement vehicles_model = Driver.getDriver().findElement(By.xpath("//a[.='Vehicles Model']"));
        vehicles_model.click();
        BrowserUtils.sleep(2);
           List<WebElement> allElements = Driver.getDriver().findElements(By.xpath("//a[@class='grid-header-cell__link']"));

        List<String>Text = new ArrayList<>();

        for (WebElement eachText : allElements) {
            Text.add(eachText.getText());
        }
        System.out.println(Text);

            for (int i = 1; i <= 10; i++) {
                String actual = Text.get(i);
                Assert.assertEquals(actual, "MODEL NAME, MAKE, CAN BE REQUESTED, CVVI, CO2 FEE (/MONTH), COST (DEPRECIATED), TOTAL COST (DEPRECIATED), CO2 EMISSIONS, FUEL TYPE, VENDORS");



            }
    }
@Test
public void view_column_on_vehicle_module_driver(){
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        VYTrack_Utils.vy_login(Driver.getDriver(), ConfigurationReader.getProperty("username.driver1"), ConfigurationReader.getProperty("password"));

         WebElement fleetButton = Driver.getDriver().findElement(By.xpath("//a[@class='unclickable']"));
         BrowserUtils.sleep(2);
         Actions actions = new Actions(Driver.getDriver());
         actions.moveToElement(fleetButton).perform();
          BrowserUtils.sleep(2);
          WebElement vehicles_model = Driver.getDriver().findElement(By.xpath("//a[.='Vehicles Model']"));
          vehicles_model.click();
          BrowserUtils.sleep(2);
          WebElement permissiontext = Driver.getDriver().findElement(By.linkText("//div[.='You do not have permission to perform this action.']"));
          BrowserUtils.sleep(2);
          String actualpermissiontext = permissiontext.getText();
          String expectedpermissiontext = "You do not have permission to perform this action.";
          BrowserUtils.sleep(2);
          Assert.assertEquals(permissiontext, expectedpermissiontext);
          Driver.closeDriver();
}


}