package TechnicalInterviewTestsPackage;

import TechnicalInterviewPagePackage.RegisterAndLoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class Tests extends TestSetup {

    @Test
    void registerUserTest(){
        registerAndLoginPage.registerUser(user);
        loginMessageAssertion(user.getEmailAddress());
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
        int index = RegisterAndLoginPage.REGISTERED_USER.indexOf("@");
        Assertions.assertTrue(registerAndLoginPage.accountWelcomeMessageIsDisplayed()
                .getText().contains(RegisterAndLoginPage.REGISTERED_USER.substring(0,index)));
    }

    @Test
    void logoutTest(){
        registerAndLoginPage.logoutUser();

        Assertions.assertTrue(registerAndLoginPage.accountWelcomeMessageIsDisplayed()
                .getText().contains("Delete Account"));

        registerAndLoginPage.submitLogout();
        Assertions.assertTrue(registerAndLoginPage.isUserLoggedOut());
    }

    public void errorMessageAssertion(String errorMessage){
        Assertions.assertTrue(registerAndLoginPage.errorMessagePromptDisplayed()
                .getText().contains(errorMessage));
    }

    public void loginMessageAssertion(String message){
        int index = user.getEmailAddress().indexOf("@");
        assertThat(registerAndLoginPage.accountWelcomeMessageIsDisplayed()
                .getText()).contains(message.substring(0,index));
    }
}
