package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.net.HttpURLConnection;
import java.net.URL;

public class LoginTest {

    public static void main(String[] args) {

        String url = "https://www.saucedemo.com/";
       // String url = "htp://wrong-url";

        try {
            // Check link status
            checkLinkStatus(url);

            // Setup Edge driver
            WebDriverManager.edgedriver().setup();

            // Launch browser
            WebDriver driver = new EdgeDriver();
            driver.get(url);

            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();

            driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
            Thread.sleep(1000);
            driver.findElement(By.id("remove-sauce-labs-backpack")).click();
            Thread.sleep(1000);
            driver.quit();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    // Method to check link status
    public static void checkLinkStatus(String urlString) {
        try {
            URL url = new URL(urlString);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int code = connection.getResponseCode();

            if (code >= 200 && code < 400) {
                System.out.println("Link is Valid");
            } else {
                System.out.println("Link is Broken");
            }

        } catch (Exception e) {
            System.out.println("Link is Invalid: " + e.getMessage());
        }
    }



}