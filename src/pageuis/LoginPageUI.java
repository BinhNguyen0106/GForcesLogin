package pageuis;

import org.openqa.selenium.By;

public class LoginPageUI {
    public static final By txtUserName = By.id("user-name");
    public static final By txtPassword = By.id("password");
    public static final By btnLogin = By.id("login-button");
    public static final By lblLoginError = By.xpath("//h3[@data-test = 'error']");
}
