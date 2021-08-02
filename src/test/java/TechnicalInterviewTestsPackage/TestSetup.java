package TechnicalInterviewTestsPackage;

import TechnicalInterviewPagePackage.LandingPage;
import TechnicalInterviewPagePackage.RegisterAndLoginPage;
import TechnicalInterviewPagePackage.ShopPage;
import TechnicalInterviewPagePackage.User;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public abstract class TestSetup {

    protected ShopPage shopPage;
    protected LandingPage landingPage;
    protected RegisterAndLoginPage registerAndLoginPage;

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected static final Faker fake = new Faker(new Locale("en", "US"));
    protected User user;

    @BeforeEach
    public void setup(){
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);

        landingPage = new LandingPage(driver);
        shopPage = new ShopPage(driver);
        registerAndLoginPage = new RegisterAndLoginPage(driver);

        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        landingPage.openUpNigga();
        landingPage.dismissCookies();

        user = new User(fake.internet().emailAddress(),fake.internet().password(10,12));
    }

    @AfterEach
    public void afterEach(){driver.quit();}
}
