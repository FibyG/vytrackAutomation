package com.vytrack.tests.Jamil;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.VYTrack_Login;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class test1 extends TestBase {

    @Test
    public void test1(){

        driver.get(ConfigurationReader.getProperty("env"));
        VYTrack_Login.vy_login(driver,ConfigurationReader.getProperty("username.store_manager1"),ConfigurationReader.getProperty("password"));

        WebElement activitiesModule = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[5]"));

        BrowserUtils.sleep(3);

        Actions actions = new Actions(driver);
        actions.moveToElement(activitiesModule).perform();

        WebElement calendarEvents = driver.findElement(By.linkText("Calendar Events"));
        calendarEvents.click();

        WebElement createCalendarEvent = driver.findElement(By.xpath("//a[@title='Create Calendar event']"));
        createCalendarEvent.click();
        ////body[@id='tinymce']
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe")));
        WebElement textBox = driver.findElement(By.xpath("//body[@id='tinymce']"));
        textBox.sendKeys("Scrum daily meeting");

        BrowserUtils.sleep(3);
        driver.switchTo().defaultContent();


        WebElement titleBox = driver.findElement(By.xpath("//input[@name='oro_calendar_event_form[title]']"));
        titleBox.sendKeys("meeting");

        WebElement repeatRadioButton = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        repeatRadioButton.click();

        BrowserUtils.sleep(3);

        WebElement saveAndClose = driver.findElement(By.xpath("//button[@class='btn btn-success action-button']"));
        saveAndClose.click();

        BrowserUtils.sleep(3);

        WebElement result = driver.findElement(By.xpath("//div//p"));
        String actualResult = result.getText();
        String expectedResult = "Scrum daily meeting";

        BrowserUtils.sleep(3);

        Assert.assertEquals(actualResult,expectedResult);

    }


}
