package com.vytrack.tests;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TS22_57_ViewEditDeleteIcons {

    public static void viewEditDeleteOptions() {
        WebDriver driver = Driver.getDriver();

//      Handling Hover
//      1. Locating the Main Menu (Parent element)
        WebElement fleetDropdown = driver.findElement(By.xpath("//span[@class='title title-level-1']/i[@class='fa-asterisk menu-icon']"));

//      2. Instantiating Actions class
        Actions actions = new Actions(driver);

//      3. Hovering on Main Menu (Parent element)
        actions.moveToElement(fleetDropdown);

//      4. Locating the element from Sub Menu
        WebElement vehiclesOption = driver.findElement(By.xpath("//a[@href='entity/Extend_Entity_Carreservation']/span[.='Vehicles']"));

//      5. To mouseover(hover over) on Sub Menu element
        actions.moveToElement(vehiclesOption);

//      6. build() --> used to compile all the actions into a single step
        actions.click();
        actions.perform();

    }

}
