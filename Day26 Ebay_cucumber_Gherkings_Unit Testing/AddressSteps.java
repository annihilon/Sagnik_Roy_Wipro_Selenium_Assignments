package StepDefination;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class AddressSteps {
    WebDriver driver;
    PageClass ebayPage;
    
    @Given("user is logged in and account page is open")
    public void user_is_logged_in_and_account_page_is_open() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.ebay.com/");
        ebayPage = new PageClass(driver);
        ebayPage.login("sroy20442@gmail.com", "Pword123@79");
    }
    
    @When("^change address to \"(.*)\" and city to \"(.*)\"$")
    public void change_address_to_and_city_to(String address, String city) {
        ebayPage.changeAddress(address, city);
    }
    
    @Then("address should be updated successfully")
    public void address_should_be_updated_successfully() {
        System.out.println("Address updated");
        driver.close();
    }
}