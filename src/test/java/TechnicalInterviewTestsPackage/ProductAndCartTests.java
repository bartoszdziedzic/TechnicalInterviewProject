package TechnicalInterviewTestsPackage;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

class ProductAndCartTests extends TestSetup {

    @Test
    void addProductFromProductView(){
        addProductToCartFromProductView(productsPage.climbingCategory(), productsPage.granKoscielcow());
        assertThat(productsPage.addToCartMessageIsDisplayed().getText())
                .as("Wrong add to cart message displayed.")
                .contains('„' + productsPage.productTitle() + '“' + " został dodany do koszyka.");
    }

    @Test
    void addProductFromCategoryView(){
        addProductToCartFromCategoryView(productsPage.climbingCategory());
        wait.until(ExpectedConditions.elementToBeClickable(productsPage.seeCartFromUnderProduct()));
        assertThat(productsPage.seeCartFromUnderProduct().isDisplayed())
                .as("See Cart button is not displayed under the product.")
                .isTrue();
    }

    @Test
    void addProductToCartTenTimes(){
        productsPage.getShopPage();
    }

    @Test
    void removeProductFromCart(){
        productsPage.getShopPage();
    }

    public void addProductToCartFromProductView(WebElement category, WebElement productName) {
        productsPage.getShopPage();
        productsPage.openCategory(category);
        productsPage.openTrip(productName);
        productsPage.addToCartFromProductView();
    }

    public void addProductToCartFromCategoryView(WebElement category) {
        productsPage.getShopPage();
        productsPage.openCategory(category);
        productsPage.addToCartFromCategoryView();
    }

    public void openProduct(WebElement category, WebElement productName){
        productsPage.getShopPage();
        productsPage.openCategory(category);
        productsPage.openTrip(productName);
    }
}
