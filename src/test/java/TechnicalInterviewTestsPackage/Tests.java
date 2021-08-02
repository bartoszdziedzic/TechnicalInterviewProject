package TechnicalInterviewTestsPackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Tests extends TestSetup {

    public void errorMessageAssertion(String errorMessage){
        Assertions.assertTrue((driver.findElement(registerAndLoginPage.errorMessagePrompt)
                .getText()).contains(errorMessage));
    }
    //TODO ADD ASSERTJ, eliminate exposed driver from tests, WebElements
    public void loginMessageAssertion(String message){
        int index = user.emailAddress.indexOf("@");
        Assertions.assertTrue((driver.findElement(registerAndLoginPage.myAccountWelcomeMessage)
                .getText()).contains(message.substring(0,index)));
    }

    @Test
    void registerUserTest(){
        registerAndLoginPage.registerUser(user);

//        int index = user.emailAddress.indexOf("@");
//        Assertions.assertTrue((driver.findElement(registerAndLoginPage.myAccountWelcomeMessage)
//                .getText()).contains(user.emailAddress.substring(0,index)));
        loginMessageAssertion(user.emailAddress);
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
