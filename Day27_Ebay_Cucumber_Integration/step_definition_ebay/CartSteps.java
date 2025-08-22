package step_definition_ebay;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class CartSteps {
    WebDriver driver;
    PageClass ebayPage;
    
    @Given("user is logged in and homepage is open1")
    public void user_is_logged_in_and_homepage_is_ope() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.ebay.com/");
        ebayPage = new PageClass(driver);
        ebayPage.login("sroy20442@gmail.com", "Pword123@79");
    }
    
    @When("add product items to cart")
    public void add_product_items_to_cart() throws InterruptedException {
    	driver.findElement(By.id("gh-logo")).click();
    	 Thread.sleep(1000);
    	 WebElement ns=driver.findElement(By.id("gh-ac"));
    	 ns.sendKeys("vivo X100 Pro 6.78\" 50MP 256GB 512GB 1TB Dimensity 9300 Android 14 CN version");
//    	 ns.clear();
    	 driver.findElement(By.xpath("//*[@id=\"gh-search-btn\"]/span")).click();
    	 Thread.sleep(1000);
    	 driver.findElement(By.xpath("//*[@id=\"item2702232779\"]/div/div[1]/div/a/div/img")).click();
    	 Thread.sleep(1000);
    	 ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
    	 driver.switchTo().window(tabs.get(1));
    	 JavascriptExecutor js=(JavascriptExecutor)driver;
    	 js.executeScript("window.scrollBy(0,400)");
    	 driver.findElement(By.id("atcBtn_btn_1")).click();
    	 Thread.sleep(7000);
    	 driver.close();
    	 driver.switchTo().window(tabs.get(0));
    	 Thread.sleep(3000);
    	 js.executeScript("window.scrollBy(0,-400)");
    	 driver.findElement(By.id("gh-logo")).click();
    	 driver.close();

    }
    @Then("Add and delete to cart successful")
    public void add_and_delete_to_cart_successful() {
    	driver.close();
    	System.out.println("transaction successful");
    }
}