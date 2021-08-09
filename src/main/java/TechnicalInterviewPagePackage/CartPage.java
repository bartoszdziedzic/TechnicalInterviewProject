package TechnicalInterviewPagePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage {

    @FindBy(css = ".woocommerce-cart-form")
    private WebElement cartElements;
    @FindBy(css = ".woocommerce-message")
    private WebElement cartMessage;
    @FindBy(css = ".cart-empty.woocommerce-info")
    private WebElement emptyCartMessage;
    @FindBy(css = ".product-remove > a")
    private WebElement removeButton;

    public CartPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void getShopPage(){
        driver.get("https://fakestore.testelka.pl/koszyk/");
    }

    public WebElement cartElementsDisplayed(){
        return cartElements;
    }

    public WebElement cartMessage(){
        return cartMessage;
    }

    public WebElement removeButton(){
        return removeButton;
    }

    public WebElement emptyCartMessageDisplayed(){
        return emptyCartMessage;
    }
}
