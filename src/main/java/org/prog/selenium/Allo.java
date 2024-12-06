package org.prog.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Allo {

    public static void main(String[]args);
    WebDriver driver = null;
        try {
        // 1. open browser
        driver = new ChromeDriver();
        // 2. open google.com
        driver.get("https://allo.ua/");
        // 3. enter 'iphone' to search field
        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys("iphone");
        searchInput.sendKeys(Keys.ENTER);
        List<WebElement> searchItem = new WebDriverWait(driver, Duration.ofSeconds(5L))
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(By.tagName("h1"), 1));

        int count = 0;
        for (WebElement webElement : searchItem ){
            if (webElement.getText().contains("iphone")) {
                count++;

            }
            System.out.println( "first iphone :"+ webElement.getText());

            // close browser
        } finally {
            driver.quit();
    }
}
    }
