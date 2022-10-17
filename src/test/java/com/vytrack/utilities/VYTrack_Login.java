package com.vytrack.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VYTrack_Login {
    public static void vy_login(WebDriver driver, String username, String password){
        WebElement inputUserName = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        inputUserName.sendKeys(username);
        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        inputPassword.sendKeys(password);

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
    }

}
