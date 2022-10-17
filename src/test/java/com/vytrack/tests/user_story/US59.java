package com.vytrack.tests.user_story;

import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VYTrack_Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US59 {

    @Test(priority = 1)
    public void tc1(){
        //logs into vytrack environment
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        VYTrack_Login.vy_login(Driver.getDriver(), ConfigurationReader.getProperty("username.driver1"), ConfigurationReader.getProperty("password"));
        //goes to the calendar event page
        WebElement calendarEventsLink = Driver.getDriver().findElement(By.xpath("//a[@href='/calendar/event']/span"));
        WebElement activities = Driver.getDriver().findElement(By.xpath("//li[@class='dropdown dropdown-level-1'][3]/a/span"));
        activities.click();
        calendarEventsLink.click();

        //click create new event button
        WebElement createEventBtn = Driver.getDriver().findElement(By.xpath("//a[@class='btn main-group btn-primary pull-right ']"));
        createEventBtn.click();

        //selects the repeat checkbox
        WebElement checkbox = Driver.getDriver().findElement(By.xpath("//div[@class='controls']/input[@type='checkbox'][@data-name='recurrence-repeat']"));
        if(checkbox.isSelected()){
            System.out.println("checkbox already selected");
        }else{
            checkbox.click();
        }

        //compares the default value of the text box with expected value
        WebElement repeatField = Driver.getDriver().findElement(By.xpath("//label[@class='fields-row']/input[3]"));
        repeatField.click();
        repeatField.click();
        Assert.assertEquals(repeatField.getAttribute("value"), "1");
        Driver.closeDriver();
    }

    @Test(priority = 2)
    public void tc2(){
        //logs into vytrack environment
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        VYTrack_Login.vy_login(Driver.getDriver(), ConfigurationReader.getProperty("username.driver1"), ConfigurationReader.getProperty("password"));

        //goes to the calendar event page
        WebElement calendarEventsLink = Driver.getDriver().findElement(By.xpath("//a[@href='/calendar/event']/span"));
        WebElement activities = Driver.getDriver().findElement(By.xpath("//li[@class='dropdown dropdown-level-1'][3]/a/span"));
        activities.click();
        calendarEventsLink.click();

        //click create new event button
        WebElement createEventBtn = Driver.getDriver().findElement(By.xpath("//a[@class='btn main-group btn-primary pull-right ']"));
        createEventBtn.click();

        //selects the repeat checkbox
        WebElement checkbox = Driver.getDriver().findElement(By.xpath("//div[@class='controls']/input[@type='checkbox'][@data-name='recurrence-repeat']"));
        if(checkbox.isSelected()){
            System.out.println("checkbox already selected");
        }else{
            checkbox.click();
        }

        //clears the value of the "repeat every" text box
        WebElement repeatField = Driver.getDriver().findElement(By.xpath("//label[@class='fields-row']/input[3]"));
        repeatField.clear();

        //Compares expected/actual text of error message
        WebElement errorText = Driver.getDriver().findElement(By.xpath("//span[@class='validation-failed']/span/span"));
        Assert.assertEquals(errorText.getText(),"This value should not be blank.");

        Driver.closeDriver();
    }



}
