package org.prog.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.prog.selenium.pages.AlloUaPage;
import org.prog.selenium.pages.GooglePage;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

//TODO: Move Allo.ua code to TestNG
//TODO: replace [// if X > goods count -> throw exception] with Assert
public class AlloUaTestNG {
    private WebDriver driver;
    private GooglePage googlePage;
    private AlloUaPage alloUaPage;
    @BeforeSuite
    public void setUp() {
        driver = new ChromeDriver();
        googlePage = new GooglePage(driver);
        alloUaPage = new AlloUaPage();
    }
    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    @Test(dataProvider = "iphone")
    public void testGoogleSearchClassic(String iphone) {
        googlePage.loadPageAndAcceptCookiesIfPresent();
        googlePage.setSearchInputText(iphone);
        googlePage.executeSearch();

        long count = googlePage.getSearchHeaders().stream()
                .filter(header -> header.getText().contains(iphone))
                .count();

        Assert.assertTrue(count > 3,
                "Expected iphone search results to be more than 3");
    }
    @DataProvider
    public Object[][] iphon() {
        return new Object[][]{
                {"Apple iPhone 16 Pro Max"},
                {"Apple iPhone 16 Pro "},
                {"Apple iPhone 16"},
                {"Apple iPhone 15"}
        };
    }
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
                checkGoodsId(driver, searchResults, positionX);

            } finally {
                driver.quit();
            }
        }

        public static void checkGoodsId(WebDriver driver, List<WebElement> goods, int positionX) {
            if (positionX < 0) {
                throw new IllegalArgumentException("Fault, goods does not exists");
            }
            if (positionX >= goods.size()) {
                throw new IllegalArgumentException("Assert goods");
            }

            // Получаем элемент на позиции X
            WebElement selectedItem = goods.get(positionX);

            // Прокручиваем страницу до элемента

            executeSearch("arguments[0].scrollIntoView(true);", selectedItem);

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

