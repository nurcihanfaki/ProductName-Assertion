package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Main {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void startTest() {
        driver.get("http:www.amazon.com");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella");
        searchBox.submit();
        WebElement resultTextElement = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div"));
        String actualStr = resultTextElement.getText();
        String expectedStr = "Nutella";
        Assert.assertTrue(actualStr.contains(expectedStr)); //Nutella yazısı olduğunu test ediyoruz
        //Assert.assertFalse olmadığını test ediyoruz
        //Assert.assertEquals eşit olduğunu test ediyoruz
    }
}