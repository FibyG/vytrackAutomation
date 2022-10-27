package com.cydeo.pages;

import com.cydeo.utilities.WebDriverFactory;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VyTrackVehicleLoginPage {
    public VyTrackVehicleLoginPage() {

        PageFactory.initElements(Driver.getDriver(), this);


    }

    @FindBy(xpath = "//input[@id='prependedInput']")
    public WebElement inputUserName;

    @FindBy(xpath = "//input[@id='prependedInput2']")
    public WebElement inputPassword;

    @FindBy(xpath = "//button[@id='_submit']")
    public WebElement loginButton;

    @FindBy(xpath = "(//span[@class='title title-level-1'])[2]")
    public WebElement fleetButton;


    @FindBy(xpath = "//a[.='Vehicles Model']")
    public WebElement vehicleModule;

    @FindBy(xpath = "//div[.='You do not have permission to perform this action.']")
    public WebElement dontHvaPermissionText;

}
