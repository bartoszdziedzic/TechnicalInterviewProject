package TechnicalInterview;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

class Tests extends Setup{
    RegisterPage registerPage = new RegisterPage();

    @Test
    void registerUser(){
        registerPage.registerUser(user);
    }
}
