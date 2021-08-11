package TechnicalInterviewTestsPackage;

import TechnicalInterviewPagePackage.RegisterAndLoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class LoginAndRegisterTests extends TestSetup {

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
        loginMessageAssertion(RegisterAndLoginPage.REGISTERED_USER);
    }

    @Test
    void logoutTest(){
        registerAndLoginPage.logoutUser();
        assertThat(registerAndLoginPage.accountWelcomeMessageIsDisplayed().getText())
                .as("Welcome messsage does not contain 'Delete Account' phrase.")
                .contains("Delete Account");

        registerAndLoginPage.submitLogout();
        assertThat(registerAndLoginPage.isUserLoggedOut())
                .as("Login button is not displayed.")
                .isTrue();
    }

    private void errorMessageAssertion(String errorMessage){
        assertThat(registerAndLoginPage.errorMessagePromptDisplayed().getText())
                .as("Incorrect error message.")
                .contains(errorMessage);
    }

    private void loginMessageAssertion(String message){
        String username = List.of(message.split("@")).get(0);
        assertThat(registerAndLoginPage.accountWelcomeMessageIsDisplayed().getText())
                .as("Incorrect username displayed in welcome message.")
                .contains(username);
    }
}
