package TechnicalInterviewTestsPackage;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

class ProductAndCartTests extends TestSetup {

    @Test
    void addProductFromProductView(){
        addProductToCartFromProductView(productsPage.climbingCategory(), productsPage.granKoscielcow(), 1);
        assertThat(productsPage.addToCartMessageIsDisplayed().getText())
                .as("Wrong add to cart message displayed.")
                .contains('„' + productsPage.productTitle() + '“' + " został dodany do koszyka.");
    }

    @Test
    void addProductFromCategoryView(){
        addProductToCartFromCategoryView(productsPage.climbingCategory());
        assertThat(productsPage.seeCartFromUnderProduct().isDisplayed())
                .as("See Cart button is not displayed under the product.")
                .isTrue();
    }

    @Test
    void addProductToCartTenTimes(){
        addProductToCartFromProductView(productsPage.climbingCategory(), productsPage.granKoscielcow(), 10);
        assertThat(productsPage.addToCartMessageIsDisplayed().getText())
                .as("Wrong add to cart message displayed.")
                .contains("10 × " + '„' + productsPage.productTitle() + '“' + " zostało dodanych do koszyka.");
    }

    @Test
    void isProductAddedToCart(){
        addProductToCartFromCategoryView(productsPage.climbingCategory());
        productsPage.goToCart();
        assertThat(cartPage.removeButton().isEnabled())
                .as("Remove button is not displayed.")
                .isTrue();
    }

    @Test
    void removeProductFromCart(){
        addProductToCartFromCategoryView(productsPage.climbingCategory());
        productsPage.goToCart();
        cartPage.removeButton().click();
        wait.until(ExpectedConditions.visibilityOf(cartPage.emptyCartMessageDisplayed()));
        assertThat(cartPage.emptyCartMessageDisplayed().getText())
                .as("No info about empty cart was displayed.")
                .contains("Twój koszyk jest pusty.");
        assertThat(cartPage.cartMessage().getText())
                .as("No info about removing product from cart was displayed.")
                .contains("Usunięto:");
    }

    public void addProductToCartFromProductView(WebElement category, WebElement productName, int amount) {
        productsPage.getShopPage();
        productsPage.openCategory(category);
        productsPage.openTrip(productName);
        productsPage.setQuantity(amount);
        productsPage.addToCartFromProductView();
    }

    public void addProductToCartFromCategoryView(WebElement category) {
        productsPage.getShopPage();
        productsPage.openCategory(category);
        productsPage.addToCartFromCategoryView();
        wait.until(ExpectedConditions.elementToBeClickable(productsPage.seeCartFromUnderProduct()));
    }

    public void openProduct(WebElement category, WebElement productName){
        productsPage.getShopPage();
        productsPage.openCategory(category);
        productsPage.openTrip(productName);
    }
}
