package com.vytrack.tests.US2_user_should_access_to_the_Oroinc_page;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.VYTrack_Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class VerifyTheQuestionIcon extends TestBase {
    @Test
    public void test1() throws InterruptedException {
        driver.get(ConfigurationReader.getProperty("env"));
        // Step 1 - Log in with correct credentials.
        VYTrack_Login.vy_login(driver, ConfigurationReader.getProperty("username.store_manager1"), ConfigurationReader.getProperty("password"));
        Thread.sleep(3000);
        WebElement questionIcon = driver.findElement(By.xpath("//i[@class='fa-question-circle']"));
        questionIcon.click();
        Thread.sleep(3000);
        for (String eachWindow : driver.getWindowHandles()) {
            driver.switchTo().window(eachWindow);
            System.out.println("eachWindow = " + eachWindow);
            System.out.println("driver.getTitle() = " + driver.getTitle());

        }
    }
}
