package StepDefination;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class CartSteps {
    WebDriver driver;
    PageClass ebayPage;
    
    @Given("user is logged in and homepage is open")
    public void user_is_logged_in_and_homepage_is_open() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.ebay.com/");
        ebayPage = new PageClass(driver);
        ebayPage.login("sroy20442@gmail.com", "Pword123@79");
    }
    
    @When("^add product \"(.*)\" to cart$")
    public void add_product_to_cart(String product) {
        ebayPage.addProductToCart(product);
    }
    
    @Then("remove item from cart")
    public void remove_item_from_cart() {
        ebayPage.removeFromCart();
        driver.close();
    }
}