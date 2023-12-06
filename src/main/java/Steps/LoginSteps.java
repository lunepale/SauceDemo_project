package Steps;

import Pages.LoginPage;

public class LoginSteps {
    private final LoginPage loginPage;

    public LoginSteps(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    public void performLogin(String username, String password) {
        loginPage.login(username, password);
    }
}