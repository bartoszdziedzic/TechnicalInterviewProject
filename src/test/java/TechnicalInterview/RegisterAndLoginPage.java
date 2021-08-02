package TechnicalInterview;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class RegisterAndLoginPage extends Setup{

    String registeredUser = "brynn.okuneva@gmail.com";
    String registeredUserPassword = "dbj7x7sncq";

    By emailRegisterField = By.cssSelector("#reg_email");
    By passwordRegisterField = By.cssSelector("#reg_password");
    By submitRegistrationButton = By.cssSelector("[name='register']");
    By submitLoginButton = By.cssSelector("[name='login']");
    By logoutButton = By.cssSelector("[class*='logout']");
    By emailLoginField = By.cssSelector("#username");
    By passwordLoginField = By.cssSelector("#password");
    By errorMessagePrompt = By.cssSelector(".woocommerce-error");
    By myAccountWelcomeMessage = By.cssSelector(".woocommerce-MyAccount-content");

    public void registerUser(User user){
        getMyAccountPage();
        driver.findElement(emailRegisterField).sendKeys(user.emailAddress);
        driver.findElement(passwordRegisterField).sendKeys(user.password);
        submitRegistration();
    }

    public void registerWithoutMail(){
        getMyAccountPage();
        submitRegistration();
    }

    public void registerWithoutPassword(User user){
        getMyAccountPage();
        driver.findElement(emailRegisterField).sendKeys(user.emailAddress);
        submitRegistration();
    }

    public void loginUser(){
        loginMethod();
    }

    public void logoutUser(){
        loginMethod();
//        Assertions.assertTrue((driver.findElement(myAccountWelcomeMessage)
//                .getText()).contains("Delete Account"));
//
//        driver.findElement(logoutButton).click();
//        Assertions.assertTrue(driver.findElement(submitLoginButton).isDisplayed());
    }

    public void getMyAccountPage(){
        driver.get("https://fakestore.testelka.pl/moje-konto/");
    }

    public void submitRegistration(){
        driver.findElement(submitRegistrationButton).click();
    }

    public void submitLogin(){
        driver.findElement(submitLoginButton).click();
    }

    public void loginMethod(){
        getMyAccountPage();
        driver.findElement(emailLoginField).sendKeys(registeredUser);
        driver.findElement(passwordLoginField).sendKeys(registeredUserPassword);
        submitLogin();
    }
}
