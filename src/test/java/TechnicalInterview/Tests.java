package TechnicalInterview;

import org.junit.jupiter.api.Test;

class Tests extends Setup{
    RegisterAndLoginPage registerAndLoginPage = new RegisterAndLoginPage();
    ShopPage shopPage = new ShopPage();

    @Test
    void registerUserTest(){
        registerAndLoginPage.registerUser(user);
    }

    @Test
    void registerUserWithoutMailTest(){
        registerAndLoginPage.registerWithoutMail();
    }

    @Test
    void registerUserWithoutPasswordTest(){
        registerAndLoginPage.registerWithoutPassword(user);
    }

    @Test
    void loginTest(){
        registerAndLoginPage.loginUser();
    }

    @Test
    void logoutTest(){
        registerAndLoginPage.logoutUser();
    }
}
