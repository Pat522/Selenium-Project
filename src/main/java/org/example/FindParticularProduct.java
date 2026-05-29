package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

public class FindParticularProduct {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://www.saucedemo.com/");

        // Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        List<WebElement> products = driver.findElements(
                By.className("inventory_item")
        );

        JavascriptExecutor js = (JavascriptExecutor) driver;

        boolean found = false;

        for (WebElement product : products)
        {
            String name = product.findElement(By.className("inventory_item_name")).getText();

            if (name.contains("Red"))
            {
                found = true;

            } else {
                js.executeScript("arguments[0].style.display='none';", product);
            }
        }

        if (found)
        {
            System.out.println("Products found");
        } else {
            System.out.println("No products found");
        }

        Thread.sleep(4000);

        //driver.quit();
    }
}


