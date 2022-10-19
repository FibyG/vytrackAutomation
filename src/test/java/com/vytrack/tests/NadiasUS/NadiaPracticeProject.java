package com.vytrack.tests.NadiasUS;


import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.VYTrack_Login;
import com.vytrack.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class NadiaPracticeProject extends TestBase {

    @Test
    public void TC1()throws InterruptedException{

        driver.get(ConfigurationReader.getProperty("env"));
        VYTrack_Login.vy_login(driver,ConfigurationReader.getProperty("username.store_manager2"),ConfigurationReader.getProperty("password"));

        Thread.sleep(3000);

        //2.Fleet
        //WebElement FleetMenu = driver.findElement(By.xpath("//span[@class='title title-level-1'])[2]"));
        WebElement FleetMenu = driver.findElement(By.xpath("//ul[@class='nav-multilevel main-menu']/li[2]"));
        //li[@class='dropdown dropdown-level-1'])[1]
       Actions actions = new Actions(driver);
       actions.moveToElement(FleetMenu).pause(4000).perform();
        //FleetMenu.click();
        //Thread.sleep(3000);

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

        @Test
        public void TC2()throws InterruptedException{
        driver.get(ConfigurationReader.getProperty("env"));
        VYTrack_Login.vy_login(driver,ConfigurationReader.getProperty("username.store_manager2"),ConfigurationReader.getProperty("password"));

            //2.Fleet
            //WebElement FleetMenu = driver.findElement(By.xpath("//span[@class='title title-level-1'])[2]"));
            WebElement FleetMenu = driver.findElement(By.xpath("//ul[@class='nav-multilevel main-menu']/li[2]"));
            //li[@class='dropdown dropdown-level-1'])[1]
            Actions actions = new Actions(driver);
            actions.moveToElement(FleetMenu).pause(4000).perform();
            //FleetMenu.click();
            //Thread.sleep(3000);

            //3.Vehicles.
            WebElement VehicleBtn = driver.findElement(By.xpath("//span[.='Vehicles']"));

            //WebElement VehicleBtn = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/div/div/ul/li[3]/a/span"));
            VehicleBtn.click();
            Thread.sleep(3000);

            //4.Test all buttons are not selected
            List<WebElement> AllChecboxes = driver.findElements(By.xpath("//input[@data-role='select-row-cell']"));
            for(WebElement eachCheckbox : AllChecboxes){
                if (eachCheckbox.isSelected()){
                    System.out.println("All checkboxes are selected");
                }else{
                    System.out.println("All checkboxes are not selected");
                }
            }
            Thread.sleep(3000);

            //5.One of any cars is checked.
            // WebElement AnyCarIsSelected = driver.findElement(By.xpath("//*[@id=\"grid-custom-entity-grid-1473493499\"]/div[2]/div[2]/div[2]/div/table/tbody/tr[2]/td[1]/input"));
            WebElement AnyCarIsSelected = driver.findElement(By.xpath("//table[@class='grid table-hover table table-bordered table-condensed']//tbody//tr[1]//td[1]"));

            AnyCarIsSelected.click();
            //driver.quit();
        }

}
