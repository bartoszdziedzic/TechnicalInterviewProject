package TechnicalInterviewPagePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductsPage extends BasePage {

    @FindBy(css = "[name=add-to-cart]")
    private WebElement productAddToCartButton;
    @FindBy(css = ".woocommerce-message")
    private WebElement addToCartMessage;
    @FindBy(css = "#site-header-cart")
    private WebElement goToCart;
    @FindBy(css = ".product_title.entry-title")
    private WebElement productTitle;
    @FindBy(css = ".add_to_cart_button.ajax_add_to_cart")
    private List<WebElement> categoryAddToCartButton;
    @FindBy(css = "[title='Zobacz koszyk']")
    private WebElement seeCartButtonUnderProduct;
    @FindBy(css = "input.qty")
    private WebElement productQuantity;

    public ProductsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void getShopPage(){
        driver.get("https://fakestore.testelka.pl/shop/");
    }

    public void openTrip(Trip trip){
        driver.findElement(By.xpath(
                String.format("//h2[text()='%s']", trip.getTripName()))).click();
    }

    public void addToCartFromProductView(){
        productAddToCartButton.click();
    }

    public void addToCartFromCategoryView(){
        categoryAddToCartButton.get(0).click();
    }

    public void goToCart(){
        goToCart.click();
    }

    public void setQuantity(int amount){
        productQuantity.clear();
        productQuantity.sendKeys(String.valueOf(amount));
    }

    public WebElement seeCartFromUnderProduct(){
        return seeCartButtonUnderProduct;
    }

    public WebElement addToCartMessageIsDisplayed(){
        return addToCartMessage;
    }

    public String productTitle(){
        return productTitle.getText();
    }

    public void openCategory(Category category) {
        driver.findElement(By.xpath(
                String.format("//a[text()='%s']", category.getCategoryName()))).click();
    }
}
