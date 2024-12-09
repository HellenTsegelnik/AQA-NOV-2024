package org.prog.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

// add method which checks goods id on position X
// if X < 0 -> throw exception
// if X > goods count -> throw exception
// if 0 <= X <= goods_amount -> scroll to item, then print goods id for that item
public class AlloUaPage {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://allo.ua/");
            WebElement searchInput = driver.findElement(By.id("search-form__input"));
            searchInput.sendKeys("iphone");
            searchInput.sendKeys(Keys.ENTER);

            List<WebElement> searchResults =
                    new WebDriverWait(driver, Duration.ofSeconds(60))
                            .until(ExpectedConditions.numberOfElementsToBeMoreThan(By.className("products-layout__item"), 2));

            Actions actions = new Actions(driver);
            actions.moveToElement(searchResults.get(2));
            actions.perform();
            int positionX = 2; // проверка второго товара
            checkGoodsId(driver,  searchResults,positionX);

        } finally {
            driver.quit();}}

        public static void checkGoodsId (WebDriver driver, List < WebElement > goods,int positionX){
            if (positionX < 0) {
                throw new IllegalArgumentException("Fault, goods does not exists");
            }
            if (positionX >= goods.size()) {
                throw new IllegalArgumentException("Fault, exceeds goods");
            }

            // Получаем элемент на позиции X
            WebElement selectedItem = goods.get(positionX);

            // Прокручиваем страницу до элемента
           
            executeSearch ("arguments[0].scrollIntoView(true);", selectedItem);

            // Получаем ID товара
            String goodsId = selectedItem.getAttribute("<span class=\"p-tabs__sku-value\">1095976</span>"); // Замените "data-id" на актуальный атрибут
            if (goodsId == null) {
                System.out.println("ID not find " + positionX);
            } else {
                System.out.println("ID goods " + positionX + ": " + goodsId);
            }
        }

    private static void executeSearch(String s, WebElement selectedItem) {
    }
}