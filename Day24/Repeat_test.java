package asserts_demo;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Repeat_test {
	WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().window().maximize();
    }
    
    @Test(invocationCount = 2)
    public void repeatWatchSearch() {
    	List<String> searchItems = new ArrayList<>();
        searchItems.add("Watch");
        searchItems.add("Laptop");
        searchItems.add("Shoes");

        WebElement searchBox = driver.findElement(By.id("gh-ac"));
        
        for (String item : searchItems) {
            searchBox.clear();
            searchBox.sendKeys(item);
            searchBox.sendKeys(Keys.ENTER);
            searchBox = driver.findElement(By.id("gh-ac"));
        }
    }

    @AfterClass
    public void tearDown() {
    	driver.quit();
    }
}
