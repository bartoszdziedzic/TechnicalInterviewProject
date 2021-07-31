package TechnicalInterview;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class RegisterPage extends Setup{
    By emailField = By.cssSelector("#reg_email");
    By passwordField = By.cssSelector("#reg_password");
    By submitRegistration = By.cssSelector("[name='register']");

    public void registerUser(User user){
        driver.get("https://fakestore.testelka.pl/moje-konto/");
        driver.findElement(emailField).sendKeys(user.emailAddress);
        driver.findElement(passwordField).sendKeys(user.password);
        driver.findElement(submitRegistration).click();

        int index = user.emailAddress.indexOf("@");
        Assertions.assertTrue((driver.findElement(By.cssSelector(".woocommerce-MyAccount-content"))
                .getText()).contains(user.emailAddress.substring(0,index)));
    }
}
