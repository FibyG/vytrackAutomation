package com.vytrack.tests;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.VYTrack_Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginFunction extends TestBase {
@Test
    public void vy_track_login_test(){
    driver.get(ConfigurationReader.getProperty("env"));

    VYTrack_Login.vy_login(driver,ConfigurationReader.getProperty("username"),ConfigurationReader.getProperty("password"));

    BrowserUtils.sleep(4);

    BrowserUtils.verifyTitle(driver,"Dashboard");



}
}
