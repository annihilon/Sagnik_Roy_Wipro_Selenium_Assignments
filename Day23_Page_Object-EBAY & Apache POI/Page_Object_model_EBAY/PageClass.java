package testng_package;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class PageClass {
    private WebDriver driver;
    private Actions actions;
    private WebDriverWait wait;
    
    // Locators
    private By signInLink = By.linkText("Sign in");
    private By userId = By.id("userid");
    private By continueBtn = By.id("signin-continue-btn");
    private By password = By.id("pass");
    private By signInBtn = By.id("sgnBt");
    private By searchBox = By.id("gh-ac");
    private By searchButton = By.id("gh-search-btn");
    private By categoriesDropdown = By.className("gh-search-categories");
    private By firstProductImage = By.xpath("(//div[contains(@class,'s-item__image')]/a/div/img)[1]");
    private By addToCartBtn = By.id("atcBtn_btn_1");
    private By removeItemBtn = By.cssSelector("button[data-test-id='cart-remove-item']");
    private By myEbayLink = By.linkText("My eBay");
    private By accountLink = By.linkText("Account");
    private By addressesLink = By.linkText("Addresses");
    private By editAddressBtn = By.xpath("//*[@id=\"mainContent\"]/div/div/div[2]/div[1]/div/div/div/div/div/div/section[1]/div/div/div[2]/div[1]/div/div[2]/a");
    private By addressLine1 = By.id("addressLine1");
    private By cityField = By.id("city");
    private By saveAddressBtn = By.id("address_edit_submit_button");
    private By allCategoriesOption = By.cssSelector("#gh-cat > option:nth-child(1)");
    private By artCategoryOption = By.cssSelector("#gh-cat > option:nth-child(3)");
    private By languageDropdown = By.cssSelector("button[class='gf-flag__button']");
    private By koreanLanguage = By.linkText("Korea");
    
    public PageClass(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    // Login methods
    public void login(String email, String password) {
        clickElement(signInLink);
        enterText(userId, email);
        clickElement(continueBtn);
        enterText(this.password, password);
        clickElement(signInBtn);
    }
    
    // Search methods
    public void performSearch(String searchTerm) {
        enterText(searchBox, searchTerm);
        clickElement(searchButton);
    }
    
    public void performMultipleSearches(List<String> searchTerms) {
        for (String term : searchTerms) {
            enterText(searchBox, term);
            clickElement(searchButton);
            driver.navigate().back();
        }
    }
    
    // Cart methods
    public void addProductToCart(String product) {
        performSearch(product);
        clickElement(firstProductImage);
        scrollDown(300);
        clickElement(addToCartBtn);
    }
    
    public void removeFromCart() {
        driver.get("https://cart.ebay.com/");
        clickElement(removeItemBtn);
    }
    
    // Account methods
    public void changeUsername(String newUsername) {
        navigateToAccountSettings();
        // Add implementation for username change
    }
    
    public void changeAddress(String newAddress, String city) {
        navigateToAddresses();
        clickElement(editAddressBtn);
        scrollDown(300);
        enterText(addressLine1, newAddress);
        enterText(cityField, city);
        clickElement(saveAddressBtn);
    }
    
    // Category methods
    public void shopByAllCategories() {
        clickElement(categoriesDropdown);
        clickElement(allCategoriesOption);
        clickElement(searchButton);
    }
    
    public void shopByArtCategory() {
        clickElement(categoriesDropdown);
        clickElement(artCategoryOption);
        clickElement(searchButton);
    }
    
    // Language methods
    public void changeLanguageToKorean() {
        navigateToAccountSettings();
        scrollDown(400);
        clickElement(languageDropdown);
        clickElement(koreanLanguage);
    }
    
    // Helper methods
    private void navigateToAccountSettings() {
        clickElement(myEbayLink);
        clickElement(accountLink);
    }
    
    private void navigateToAddresses() {
        navigateToAccountSettings();
        clickElement(addressesLink);
    }
    
    private void clickElement(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    
    private void enterText(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }
    
    private void scrollDown(int pixels) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + pixels + ")");
    }
}