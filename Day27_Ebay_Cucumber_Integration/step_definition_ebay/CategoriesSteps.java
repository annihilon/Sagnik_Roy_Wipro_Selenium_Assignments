package step_definition_ebay;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class CategoriesSteps {
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
    
    @When("click on all categories")
    public void click_on_all_categories() {
        ebayPage.shopByAllCategories();
    }
    
    @Then("all categories page should be displayed")
    public void all_categories_page_should_be_displayed() {
        System.out.println("All categories displayed");
        driver.close();
    }
    
    @When("click on art category")
    public void click_on_art_category() {
        ebayPage.shopByArtCategory();
    }
    
    @Then("art category page should be displayed")
    public void art_category_page_should_be_displayed() {
        System.out.println("Art category displayed");
        driver.close();
    }
}