package asserts_demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Dependent_test {
	WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().window().maximize();
    }
    
    @Test
    public void login() {
    	driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("userid")).sendKeys("sroy20442@gmail.com");
        driver.findElement(By.id("signin-continue-btn")).click();
        
        driver.findElement(By.id("pass")).sendKeys("Pword123@79");
        driver.findElement(By.id("sgnBt")).click();
        System.out.println("Login test executed");
    }

    @Test(dependsOnMethods = "login")
    public void searchProduct() {
        WebElement search = driver.findElement(By.id("gh-ac"));
        search.sendKeys("laptop");
        search.sendKeys(Keys.ENTER);
    }

    @Test(dependsOnMethods = {"login", "searchProduct"})
    public void logout() throws InterruptedException {
        WebElement accountMenu = driver.findElement(By.xpath("//*[@id='gh-ug']/b"));
        Actions actions = new Actions(driver);
        actions.moveToElement(accountMenu).perform();
        WebElement logout = driver.findElement(By.xpath("//*[@id='gh-uo']/a"));
        logout.click();
    }

    @AfterClass
    public void tearDown() {
    	driver.quit();
    }
}
