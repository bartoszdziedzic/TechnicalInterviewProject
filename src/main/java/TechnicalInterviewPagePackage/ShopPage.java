package TechnicalInterviewPagePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShopPage extends BasePage {

    @FindBy(css = "li.cat-item.cat-item-18 > a")
    private WebElement windsurfingCategory;
    @FindBy(css = "li.cat-item.cat-item-16 > a")
    private WebElement climbingCategory;
    @FindBy(css = "li.cat-item.cat-item-19 > a")
    private WebElement yogaCategory;
    @FindBy(css = "li.cat-item.cat-item-17 > a")
    private WebElement sailingCategory;

    public ShopPage(WebDriver driver) {
        super(driver);
    }

    public void getShopPage(){
        driver.get("https://fakestore.testelka.pl/shop/");
    }
}
