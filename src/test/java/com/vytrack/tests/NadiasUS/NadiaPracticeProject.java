package com.vytrack.tests.NadiasUS;


import com.vytrack.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class NadiaPracticeProject {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        //1. Open a chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

        //2. Go to https://qa1.vytrack.com/user/login
        driver.get("https://qa1.vytrack.com/user/login");
    }

    @Test
    public void TC1()throws InterruptedException{


        // 1. User logs in with valid credentials.
        WebElement usernameBtn = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        usernameBtn.sendKeys("storemanager79");
        WebElement passwordBtn = driver.findElement(By.id("prependedInput2"));
        passwordBtn.sendKeys("UserUser123");
        WebElement LoginBtn = driver.findElement(By.xpath("//button[@id='_submit']"));
        LoginBtn.click();

        Thread.sleep(3000);

        //2.Fleet
        //WebElement FleetMenu = driver.findElement(By.xpath("//span[@class='title title-level-1'])[2]"));
        WebElement FleetMenu = driver.findElement(By.xpath("//ul[@class='nav-multilevel main-menu']/li[2]"));
        FleetMenu.click();
        Thread.sleep(3000);

        //3.Vehicles.
        WebElement VehicleBtn = driver.findElement(By.xpath("//span[.='Vehicles']"));

        //WebElement VehicleBtn = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/div/div/ul/li[3]/a/span"));
        VehicleBtn.click();
        Thread.sleep(3000);

        //4.Test all buttons are not selected.
        List<WebElement> AllChecboxes = driver.findElements(By.xpath("//input[@data-role='select-row-cell']"));
        for(WebElement eachCheckbox : AllChecboxes){
            if (eachCheckbox.isSelected()){
                System.out.println("All checkboxes are selected");
            }else{
                System.out.println("All checkboxes are not selected");
            }
        }
        Thread.sleep(3000);

        //5.Checkbox button for all cars is checked.
        WebElement FirstCheckbox = driver.findElement(By.xpath("//button//input[@type='checkbox']"));
        FirstCheckbox.click();

       // driver.quit();
    }
}
