package com.example.selenium;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AdditionTest {

    @Test
    public void testAddition() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Correct file path
        driver.get("file:///S:/my-webapp/src/main/webapp/index.html");

        driver.manage().window().maximize();

        WebElement num1 = driver.findElement(By.id("num1"));
        WebElement num2 = driver.findElement(By.id("num2"));

        num1.sendKeys("10");
        num2.sendKeys("20");

        driver.findElement(By.tagName("button")).click();

        Thread.sleep(2000);

        String result = driver.findElement(By.id("answer")).getText();

        assertEquals("Result: 30", result);

        driver.quit();
    }
}