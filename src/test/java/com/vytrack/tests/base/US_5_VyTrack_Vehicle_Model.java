package com.vytrack.tests.base;

import com.cydeo.pages.VyTrackVehicleLoginPage;
import com.cydeo.utilities.ConfigurationReader;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class US_5_VyTrack_Vehicle_Model {
    public US_5_VyTrack_Vehicle_Model() {

    }
    VyTrackVehicleLoginPage vyTrackVehicleLoginPage;


    @BeforeMethod
    public void setup(){
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        vyTrackVehicleLoginPage = new VyTrackVehicleLoginPage();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
    }
        @Test
        public void view_column_on_vehicle_module_store_manager_2(){
        vyTrackVehicleLoginPage.inputUserName.sendKeys(ConfigurationReader.getProperty("username.store_manager2"));

        vyTrackVehicleLoginPage.inputPassword.sendKeys(ConfigurationReader.getProperty("password"));
        vyTrackVehicleLoginPage.loginButton.click();
            BrowserUtils.sleep(3);
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(vyTrackVehicleLoginPage.fleetButton).perform();

        vyTrackVehicleLoginPage.vehicleModule.click();

    }

    @Test

    public void view_column_on_vehicle_module_driver_1(){
        vyTrackVehicleLoginPage.inputUserName.sendKeys(ConfigurationReader.getProperty("username.driver1"));
        vyTrackVehicleLoginPage.inputPassword.sendKeys(ConfigurationReader.getProperty("password"));
        vyTrackVehicleLoginPage.loginButton.click();
        BrowserUtils.sleep(5);
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(vyTrackVehicleLoginPage.fleetButton).pause(500).perform();
        vyTrackVehicleLoginPage.vehicleModule.click();

        Assert.assertEquals(vyTrackVehicleLoginPage.dontHvaPermissionText.getText(), "You do not have permission to perform this action.");



    }
}
