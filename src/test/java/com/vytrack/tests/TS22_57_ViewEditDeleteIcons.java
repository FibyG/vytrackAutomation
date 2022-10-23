package com.vytrack.tests;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class TS22_57_ViewEditDeleteIcons {

    public static void viewEditDeleteOptions() {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 120);
        wait.until(ExpectedConditions.titleIs("Dashboard"));
        BrowserUtils.verifyTitle(Driver.getDriver(), "Dashboard");

//      Handling Hover
//      1. Locating the Main Menu (Parent element)
        WebElement fleetDropdown = Driver.getDriver().findElement(By.xpath("(//li[@class='dropdown dropdown-level-1'])[1]"));

//      2. Instantiating Actions class
        Actions actions = new Actions(Driver.getDriver());

//      3. Hovering on Main Menu (Parent element)
        wait.until(ExpectedConditions.visibilityOf(fleetDropdown));
        actions.moveToElement(fleetDropdown).perform();

//      4. Locating the element from Sub Menu
        WebElement vehiclesOption = Driver.getDriver().findElement(By.xpath("//a[@href='entity/Extend_Entity_Carreservation']/span[.='Vehicles']"));

//      5. To mouseover(hover over) on Sub Menu element
        wait.until(ExpectedConditions.visibilityOf(vehiclesOption));
        actions.moveToElement(vehiclesOption).click().perform();

//      Verifying the title of the page after clicking
        wait.until(ExpectedConditions.titleIs("All - Car - Entities - System - Car - Entities - System"));
        BrowserUtils.verifyTitle(Driver.getDriver(), "All - Car - Entities - System - Car - Entities - System");

        WebElement threeDotBtn = Driver.getDriver().findElement(By.xpath("(//ul[@class='dropdown-menu dropdown-menu__action-cell launchers-dropdown-menu']/preceding-sibling::a)[1]"));
        actions.moveToElement(threeDotBtn).perform();
        wait.until(ExpectedConditions.visibilityOf(threeDotBtn));

        WebElement viewIcon = Driver.getDriver().findElement(By.xpath("(//ul[@class='nav nav-pills icons-holder launchers-list']//a[@title='View'])[1]"));
        actions.moveToElement(viewIcon).perform();
        wait.until(ExpectedConditions.visibilityOf(viewIcon));

        Assert.assertTrue(viewIcon.isDisplayed());
        System.out.println("viewIcon.getAttribute(\"title\") = " + viewIcon.getAttribute("title"));

        WebElement editIcon = Driver.getDriver().findElement(By.xpath("(//ul[@class='nav nav-pills icons-holder launchers-list']//a[@title='Edit'])[1]"));
        actions.moveToElement(editIcon).perform();
        wait.until(ExpectedConditions.visibilityOf(editIcon));

        Assert.assertTrue(editIcon.isDisplayed());
        System.out.println("editIcon.getAttribute(\"title\") = " + editIcon.getAttribute("title"));

        WebElement deleteIcon = Driver.getDriver().findElement(By.xpath("(//ul[@class='nav nav-pills icons-holder launchers-list']//a[@title='Delete'])[1]"));
        actions.moveToElement(deleteIcon).perform();
        wait.until(ExpectedConditions.visibilityOf(deleteIcon));

        Assert.assertTrue(deleteIcon.isDisplayed());
        System.out.println("deleteIcon.getAttribute(\"title\") = " + deleteIcon.getAttribute("title"));

        Driver.getDriver().navigate().refresh();

        List<WebElement> threeDotBtns = Driver.getDriver().findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu__action-cell launchers-dropdown-menu']/preceding-sibling::a"));
        System.out.println("threeDotBtns.size() = " + threeDotBtns.size());

        for (WebElement eachThreeDotBtn : threeDotBtns) {
            actions.moveToElement(eachThreeDotBtn).perform();
            wait.until(ExpectedConditions.visibilityOf(eachThreeDotBtn));
            System.out.println("eachThreeDotBtn.getText() = " + eachThreeDotBtn.getText());
        }
    }
}
