package TechnicalInterviewTestsPackage;

import TechnicalInterviewPagePackage.RegisterAndLoginPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ProductAndCartTests extends TestSetup {

    @Test
    void addProductToCartFromProductView(){
        addProductToCart(productsPage.climbingCategory(), productsPage.granKoscielcow());
        assertThat(productsPage.addToCartMessageIsDisplayed().getText())
                .as("Wrong add to cart message displayed.")
                .contains('„' + productsPage.productTitle() + '“' + " został dodany do koszyka.");
    }

    @Test
    void addAllProductsToCartFromProductView(){

    }

    @Test
    void addProductToCartFromCategoryPage(){
        productsPage.getShopPage();
        productsPage.openClimbingCategory();
    }

    @Test
    void addProductToCartTenTimes(){
        productsPage.getShopPage();
    }

    @Test
    void removeProductFromCart(){
        productsPage.getShopPage();
    }




    public void addProductToCart(WebElement category, WebElement productName) {
        productsPage.getShopPage();
        productsPage.openCategory(category);
        productsPage.openTrip(productName);
        productsPage.addToCart();
    }
}
