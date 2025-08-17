package testng_package;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelTest_Search {
    WebDriver driver;
    
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com");
    }
    
    @DataProvider(name = "searchData")
    public Object[][] searchDataProvider() throws IOException {
        String excelPath = "src/test/resources/TestData.xlsx";
        String sheetName = "SearchData";
        
        FileInputStream fis = new FileInputStream(excelPath);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet(sheetName);
        
        int rows = sheet.getPhysicalNumberOfRows();
        int cols = sheet.getRow(0).getLastCellNum();
        
        Object[][] data = new Object[rows - 1][cols]; // Exclude header row
        
        for(int i = 1; i < rows; i++) {
            Row row = sheet.getRow(i);
            for(int j = 0; j < cols; j++) {
                Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                data[i-1][j] = cell.toString();
            }
        }
        
        workbook.close();
        fis.close();
        return data;
    }
    
    @Test(dataProvider = "searchData")
    public void testSearchFunctionality(String searchItem) {
        // Perform search
        driver.findElement(By.id("gh-ac")).sendKeys(searchItem);
        driver.findElement(By.id("gh-btn")).click();
        
        // Verify search results
        String actualTitle = driver.getTitle();
        String expectedTitle = searchItem + " | eBay";
        
        Assert.assertTrue(actualTitle.contains(searchItem), 
            "Search failed for item: " + searchItem + 
            "\nActual title: " + actualTitle);
    }
    
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}