package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class AddProduct
{
    public static void main(String[] args) throws InterruptedException
    {
        // Setup Edge driver
        WebDriverManager.edgedriver().setup();

        // Launch browser
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        Thread.sleep(1000);
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.className("shopping_cart_link")).click();
        Thread.sleep(5000);

            driver.findElement(By.id("remove-sauce-labs-backpack")).click();
            Thread.sleep(1000);

            int product = driver.findElements(By.className("inventory_item_name")).size();

            if(product> 0) {System.out.println("Product Added Successfully");
            } else {
                    System.out.println("Product Not Added");
            }
                    Thread.sleep(5000);

             driver.findElement(By.id("continue-shopping")).click();
             Thread.sleep(5000);

        driver.quit();

    }
}