package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LogOutTest {

    public static void main(String[] args) throws InterruptedException {

        // Setup Edge driver
       WebDriverManager.edgedriver().setup();

        // Launch browser
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("react-burger-menu-btn")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("logout_sidebar_link")).click();
        Thread.sleep(5000);

        driver.quit();
    }
}