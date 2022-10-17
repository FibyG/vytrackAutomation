package com.vytrack.tests.US12_Accounts_Filters;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.VYTrack_Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Verify_Accounts_Filters extends TestBase {

    @Test
    public void accounts_Filters() throws InterruptedException {
        driver.get(ConfigurationReader.getProperty("env"));

        VYTrack_Login.vy_login(driver, ConfigurationReader.getProperty("username.store_manager1"), ConfigurationReader.getProperty("password"));

        BrowserUtils.sleep(4);

        BrowserUtils.verifyTitle(driver, "Dashboard");

        WebElement  customerButton = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[3]"));
        customerButton.click();

        WebElement  accountButton = driver.findElement(By.xpath("(//span[@class= 'title title-level-2'])[11]"));
        accountButton.click();

        WebElement filterIconButton = driver.findElement(By.xpath("//i[@class='fa-filter hide-text']"));
        filterIconButton.click();

        WebElement accountNameFilter = driver.findElement(By.xpath("(//div[@class='btn filter-criteria-selector oro-drop-opener oro-dropdown-toggle filter-default-value'])[1]"));
        accountNameFilter.isDisplayed();

        WebElement contactName = driver.findElement(By.xpath("(//div[@class='btn filter-criteria-selector oro-drop-opener oro-dropdown-toggle filter-default-value'])[2]"));
        contactName.isDisplayed();

        WebElement contactEmail = driver.findElement(By.xpath("(//div[@class='btn filter-criteria-selector oro-drop-opener oro-dropdown-toggle filter-default-value'])[3]"));
        contactEmail.isDisplayed();

        WebElement createdAt = driver.findElement(By.xpath("(//div[@class='btn filter-criteria-selector oro-drop-opener oro-dropdown-toggle filter-default-value'])[7]"));
        createdAt.isDisplayed();

        WebElement contactPhone = driver.findElement(By.xpath("(//div[@class='btn filter-criteria-selector oro-drop-opener oro-dropdown-toggle filter-default-value'])[4]"));
        contactPhone.isDisplayed();

        WebElement owner = driver.findElement(By.xpath("(//div[@class='btn filter-criteria-selector oro-drop-opener oro-dropdown-toggle filter-default-value'])[5]"));
        owner.isDisplayed();

        WebElement buisnessUnit = driver.findElement(By.xpath("(//div[@class='btn filter-criteria-selector oro-drop-opener oro-dropdown-toggle filter-default-value'])[6]"));
        buisnessUnit.isDisplayed();

        WebElement updatedAt = driver.findElement(By.xpath("(//div[@class='btn filter-criteria-selector oro-drop-opener oro-dropdown-toggle filter-default-value'])[8]"));
        updatedAt.isDisplayed();

   }



}
