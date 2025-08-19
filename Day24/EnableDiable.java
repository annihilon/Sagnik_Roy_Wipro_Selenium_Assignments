package asserts_demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EnableDiable {
	WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().window().maximize();
    }
    
    @Test(enabled = true)
    public void login() throws InterruptedException {
    	driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("userid")).sendKeys("sroy20442@gmail.com");
        driver.findElement(By.id("signin-continue-btn")).click();
        
        driver.findElement(By.id("pass")).sendKeys("Pword123@79");
        driver.findElement(By.id("sgnBt")).click();
        System.out.println("Login test executed");
    }

    @Test(enabled = false)
    public void search() throws InterruptedException {
        driver.get("https://www.ebay.com/");
        WebElement search = driver.findElement(By.id("gh-ac"));

        String[] searches = {"watch", "phone", "laptop"};
        for (String s : searches) {
            search.sendKeys(s);
            search.sendKeys(Keys.ENTER);
            Thread.sleep(3000);
            search = driver.findElement(By.id("gh-ac"));
            search.clear();
        }
    }

    @AfterClass
    public void tearDown() {
    	driver.quit();
    }
}
