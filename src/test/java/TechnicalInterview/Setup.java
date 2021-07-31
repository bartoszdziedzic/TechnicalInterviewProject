package TechnicalInterview;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Setup {

    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static final Faker fake = new Faker(new Locale("en", "US"));
    protected User user;

    @BeforeEach
    public void setup(){
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);

        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://fakestore.testelka.pl/shop/");
        driver.findElement(By.cssSelector("a[class*='dismiss-link']")).click();

        user = new User(fake.internet().emailAddress(),fake.internet().password(10,12));
    }

    @AfterEach
    public void afterEach(){driver.quit();}
}
