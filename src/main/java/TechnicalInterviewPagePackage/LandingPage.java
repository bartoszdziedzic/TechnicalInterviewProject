package TechnicalInterviewPagePackage;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

@Slf4j
public class LandingPage extends BasePage {
    public static final String URL = "https://fakestore.testelka.pl/shop/";

    @FindBy(css = "a[class*='dismiss-link']")
    private WebElement dismiss;

    public LandingPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void dismissCookies(){
        dismiss.click();
    }

    public void openUpMainPage(){
        driver.get(URL);
      log.info("Meow Meow !!!");
    }
}
