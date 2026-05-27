package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static io.github.bonigarcia.wdm.WebDriverManager.*;


public class CartTest {

    public static void main(String[] args) throws InterruptedException {

            // Setup Edge driver
            edgedriver().setup();

            // Launch browser
            WebDriver driver = new EdgeDriver();
            driver.get("https://www.saucedemo.com/");

            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();

            driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
            driver.findElement(By.name("add-to-cart-sauce-labs-bolt-t-shirt")).click();
            Thread.sleep(1000);
            driver.findElement(By.className("shopping_cart_link")).click();

            driver.findElement(By.id("checkout")).click();

            driver.findElement(By.id("first-name"))
                    .sendKeys("Santosh");

            driver.findElement(By.id("last-name"))
                    .sendKeys("Patak");

            driver.findElement(By.id("postal-code"))
                    .sendKeys("110001");

            driver.findElement(By.id("continue")).click();

            driver.findElement(By.id("finish")).click();

            String message = driver.findElement(By.className("complete-header"))
                    .getText();

            if(message.contains("Thank you")) {
                    System.out.println("Order Placed Successfully");
            }
            else {
                    System.out.println("Order Failed");
            }

            Thread.sleep(4000);

            driver.findElement(By.id("back-to-products")).click();
            Thread.sleep(4000);

            driver.quit();

    }
}