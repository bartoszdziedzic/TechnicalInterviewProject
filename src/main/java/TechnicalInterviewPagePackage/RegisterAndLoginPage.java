package TechnicalInterviewPagePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterAndLoginPage extends BasePage {

    public String registeredUser = "brynn.okuneva@gmail.com";
    public String registeredUserPassword = "dbj7x7sncq";

    public By emailRegisterField = By.cssSelector("#reg_email");
    public By passwordRegisterField = By.cssSelector("#reg_password");
    public By submitRegistrationButton = By.cssSelector("[name='register']");
    public By submitLoginButton = By.cssSelector("[name='login']");
    public By logoutButton = By.cssSelector("[class*='logout']");
    public By emailLoginField = By.cssSelector("#username");
    public By passwordLoginField = By.cssSelector("#password");
    public By errorMessagePrompt = By.cssSelector(".woocommerce-error");
    public By myAccountWelcomeMessage = By.cssSelector(".woocommerce-MyAccount-content");

    public RegisterAndLoginPage(WebDriver driver) {
        super(driver);
    }

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
