package TechnicalInterview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Tests extends Setup{
    RegisterAndLoginPage registerAndLoginPage = new RegisterAndLoginPage();
    ShopPage shopPage = new ShopPage();

    public void errorMessageAssertion(String errorMessage){
        Assertions.assertTrue((driver.findElement(registerAndLoginPage.errorMessagePrompt)
                .getText()).contains(errorMessage));
    }

    @Test
    void registerUserTest(){
        registerAndLoginPage.registerUser(user);

        int index = user.emailAddress.indexOf("@");
        Assertions.assertTrue((driver.findElement(registerAndLoginPage.myAccountWelcomeMessage)
                .getText()).contains(user.emailAddress.substring(0,index)));
    }

    @Test
    void registerUserWithoutMailTest(){
        registerAndLoginPage.registerWithoutMail();
        errorMessageAssertion("Błąd: Podaj poprawny adres e-mail.");
    }

    @Test
    void registerUserWithoutPasswordTest(){
        registerAndLoginPage.registerWithoutPassword(user);
        errorMessageAssertion("Błąd: Proszę wpisać hasło.");
    }

    @Test
    void loginTest(){
        registerAndLoginPage.loginUser();
        int index = registerAndLoginPage.registeredUser.indexOf("@");
        Assertions.assertTrue((driver.findElement(registerAndLoginPage.myAccountWelcomeMessage)
                .getText()).contains(registerAndLoginPage.registeredUser.substring(0,index)));
    }

    @Test
    void logoutTest(){
        registerAndLoginPage.logoutUser();

        Assertions.assertTrue((driver.findElement(registerAndLoginPage.myAccountWelcomeMessage)
                .getText()).contains("Delete Account"));

        driver.findElement(registerAndLoginPage.logoutButton).click();
        Assertions.assertTrue(driver.findElement(registerAndLoginPage.submitLoginButton).isDisplayed());
    }
}
