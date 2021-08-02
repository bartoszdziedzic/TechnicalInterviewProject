package TechnicalInterviewPagePackage;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Slf4j
public class LandingPage extends BasePage {
    public static final String URL = "https://fakestore.testelka.pl/shop/";

    @FindBy(css = "a[class*='dismiss-link']")
    private WebElement dismiss;

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    public void dismissCookies(){
        dismiss.click();
    }

    public void openUpNigga(){
        driver.get(URL);
      log.info("Meow Meow NIGGA!!!");
    }
}
