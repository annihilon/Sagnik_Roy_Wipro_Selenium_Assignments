package step_definition_ebay;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class SearchSteps {
    WebDriver driver;
    PageClass ebayPage;

    @Given("user is logged in and search page is available")
    public void user_is_logged_in_and_search_page_is_available() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.ebay.com/");
        ebayPage = new PageClass(driver);
        ebayPage.login("sroy20442@gmail.com", "Pword123@79");
    }

    @When("^enter (.*) in search box$")
    public void enter_searchTerm_in_search_box(String searchTerm) {
        List<String> products = new ArrayList<>();
        products.add(searchTerm);
        ebayPage.performMultipleSearches(products);
    }

    @Then("search results should be displayed")
    public void search_results_should_be_displayed() {
        System.out.println("Search completed");
        driver.close();
    }
}