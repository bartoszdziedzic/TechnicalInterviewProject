package TechnicalInterview;

import org.openqa.selenium.By;

public class ShopPage extends Setup{

    By windsurfingCategory = By.cssSelector("li.cat-item.cat-item-18 > a");
    By climbingCategory = By.cssSelector("li.cat-item.cat-item-16 > a");
    By yogaCategory = By.cssSelector("li.cat-item.cat-item-19 > a");
    By sailingCategory = By.cssSelector("li.cat-item.cat-item-17 > a");

    public void getShopPage(){
        driver.get("https://fakestore.testelka.pl/shop/");
    }
}
