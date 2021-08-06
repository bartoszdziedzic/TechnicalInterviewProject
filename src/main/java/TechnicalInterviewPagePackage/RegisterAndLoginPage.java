package TechnicalInterviewPagePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterAndLoginPage extends BasePage {

    public static final String REGISTERED_USER = "brynn.okuneva@gmail.com";
    public static final String REGISTERED_USER_PASSWORD = "dbj7x7sncq";

    @FindBy(css = "#reg_email")
    private WebElement emailRegisterField;
    @FindBy(css = "#reg_password")
    private WebElement passwordRegisterField;
    @FindBy(css = "[name='register']")
    private WebElement submitRegistrationButton;
    @FindBy(css = "[name='login']")
    private WebElement submitLoginButton;
    @FindBy(css = "[class*='logout']")
    private WebElement logoutButton;
    @FindBy(css = "#username")
    private WebElement emailLoginField;
    @FindBy(css = "#password")
    private WebElement passwordLoginField;
    @FindBy(css = ".woocommerce-error")
    private WebElement errorMessagePrompt;
    @FindBy(css = ".woocommerce-MyAccount-content")
    private WebElement myAccountWelcomeMessage;

    public RegisterAndLoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void registerUser(User user){
        getMyAccountPage();
        emailRegisterField.sendKeys(user.emailAddress);
        passwordRegisterField.sendKeys(user.getPassword());
        submitRegistration();
    }

    public void registerWithoutMail(){
        getMyAccountPage();
        submitRegistration();
    }

    public void registerWithoutPassword(User user){
        getMyAccountPage();
        emailRegisterField.sendKeys(user.emailAddress);
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
        submitRegistrationButton.click();
    }

    public void submitLogin(){
        submitLoginButton.click();
    }

    public void submitLogout(){
        logoutButton.click();
    }

    public void loginMethod(){
        getMyAccountPage();
        emailLoginField.sendKeys(REGISTERED_USER);
        passwordLoginField.sendKeys(REGISTERED_USER_PASSWORD);
        submitLogin();
    }

    public boolean isUserLoggedOut(){
       return submitLoginButton.isDisplayed();
    }

    public WebElement errorMessagePromptDisplayed(){
        return errorMessagePrompt;
    }

    public WebElement accountWelcomeMessageIsDisplayed(){
        return myAccountWelcomeMessage;
    }
}
