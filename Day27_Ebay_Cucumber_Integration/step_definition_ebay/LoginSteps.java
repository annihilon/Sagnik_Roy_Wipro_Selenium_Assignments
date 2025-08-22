package step_definition_ebay;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class LoginSteps {
    WebDriver driver;
    PageClass ebayPage;
    
    @Given("login page should be open in default browser1")
    public void login_page_should_be_open_in_default_browser1() {
    	
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.ebay.com/");
        ebayPage = new PageClass(driver);
    }
    
    @When("^click on signin link and enter (.*) and (.*)$")
    public void click_on_signin_link_and_enter_username_and_password(String username, String password) {
        ebayPage.login(username, password);
    }
    
    @Then("login successfully and open home page")
    public void login_successfully_and_open_home_page() {
        System.out.println("Login successful");
        driver.close();
    }
}