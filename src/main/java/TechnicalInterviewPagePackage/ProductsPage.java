package TechnicalInterviewPagePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage {

    @FindBy(css = "li.cat-item.cat-item-18 > a")
    private WebElement windsurfingCategory;
    @FindBy(css = "li.cat-item.cat-item-16 > a")
    private WebElement climbingCategory;
    @FindBy(css = "li.cat-item.cat-item-19 > a")
    private WebElement yogaCategory;
    @FindBy(css = "li.cat-item.cat-item-17 > a")
    private WebElement sailingCategory;
    @FindBy(xpath = "//*[@id=\"main\"]/ul/li[1]/a[1]/h2")
    private WebElement granKoscielcowTrip;
    @FindBy(xpath = "//*[@id=\"main\"]/ul/li[2]/a[1]/h2")
    private WebElement islandPeakTrip;
    @FindBy(xpath = "//*[@id=\"main\"]/ul/li[3]/a[1]/h2")
    private WebElement viaFerratyTrip;
    @FindBy(css = "[name=add-to-cart]")
    private WebElement addToCartButton;
    @FindBy(css = ".woocommerce-message")
    private WebElement addToCartMessage;
    @FindBy(css = "#site-header-cart")
    private WebElement goToCart;
    @FindBy(css = ".product_title.entry-title")
    private WebElement productTitle;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void getShopPage(){
        driver.get("https://fakestore.testelka.pl/shop/");
    }

    public void openWindsurfingCategory(){
        windsurfingCategory.click();
    }

    public void openClimbingCategory(){
        climbingCategory.click();
    }

    public void openYogaCategory(){
        yogaCategory.click();
    }

    public void openSailingCategory(){
        sailingCategory.click();
    }

    public void openViaFerratyTrip(){
        viaFerratyTrip.click();
    }

    public void openIslandPeakTrip(){
        islandPeakTrip.click();
    }

    public void openGranKoscielcowTrip(){
        granKoscielcowTrip.click();
    }

    public WebElement granKoscielcow(){
        return granKoscielcowTrip;
    }

    public WebElement islandPeak(){
        return islandPeakTrip;
    }

    public WebElement viaFerraty(){
        return viaFerratyTrip;
    }

    public WebElement climbingCategory(){
        return climbingCategory;
    }

    public void openTrip(WebElement trip){
        trip.click();
    }

    public void addToCart(){
        addToCartButton.click();
    }

    public void goToCart(){
        goToCart.click();
    }

    public WebElement addToCartMessageIsDisplayed(){
        return addToCartMessage;
    }

    public String productTitle(){
        return productTitle.getText();
    }

    public void openCategory(WebElement category) {
        category.click();
    }
}