package testng_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Ebay_testng_project {
    WebDriver driver;
    PageClass ebayPage;
    
    @BeforeTest
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.ebay.com/");
        ebayPage = new PageClass(driver);
    }
    
    @Test(priority = 1)
    public void Login() {
        ebayPage.login("sroy20442@gmail.com", "Pword123@79");
        System.out.println("Login test executed");
    }
    
    @Test(priority = 2)
    public void MultipleSearches() {
        List<String> products = new ArrayList<>();
        products.add("Watch");
        products.add("Pen");
        products.add("Laptop");
        ebayPage.performMultipleSearches(products);
        System.out.println("Multiple searches executed");
    }
    
    @Test(priority = 3)
    public void testAddToCart() {
        ebayPage.addProductToCart("Laptop");
        ebayPage.removeFromCart();
        System.out.println("Add to cart test executed");
    }
    
    @Test(priority = 4)
    public void testChangeCurrentAddress() {
        ebayPage.changeAddress("123 ABC", "PQR");
        System.out.println("Address changed");
    }
    
    @Test(priority = 5)
    public void testShopByAllCategories() {
        ebayPage.shopByAllCategories();
        System.out.println("All categories page displayed");
    }
    
    @Test(priority = 6)
    public void testShopByCategories() {
        ebayPage.shopByArtCategory();
        System.out.println("Navigated to Art category");
    }
    
    @Test(priority = 8)
    public void testChangeLanguage() {
        ebayPage.changeLanguageToKorean();
        System.out.println("Language changed to Korean");
    }
    
    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}