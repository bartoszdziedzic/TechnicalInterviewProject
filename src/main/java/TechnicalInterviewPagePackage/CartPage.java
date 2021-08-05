package TechnicalInterviewPagePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(css = ".woocommerce-cart-form")
    private WebElement cartElements;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void getShopPage(){
        driver.get("https://fakestore.testelka.pl/koszyk/");
    }
}
