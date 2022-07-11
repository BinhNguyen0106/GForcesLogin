package pageobjects;

import common.*;
import org.openqa.selenium.WebElement;
import pageuis.LoginPageUI;

public class LoginPage{
    protected static WebElement getUsernameTxt(){
        return Constant.driver.findElement(LoginPageUI.txtUserName);}

    protected static WebElement getPasswordTxt(){
        return Constant.driver.findElement(LoginPageUI.txtPassword);}

    protected static WebElement getLoginBtn(){
        return Constant.driver.findElement(LoginPageUI.btnLogin);}

    protected static WebElement getLoginErrorLbl(){
        return Constant.driver.findElement(LoginPageUI.lblLoginError);}

    public ProductPage login(String userName, String password){
        System.out.println("LoginPage - login");
        System.out.println("LoginPage - login - Enter user name: " + userName);
        Common.enter(getUsernameTxt(), userName);
        System.out.println("LoginPage - login - Enter password: " + password);
        Common.enter(getPasswordTxt(), password);
        System.out.println("LoginPage - login - Click on Login button");
        Common.click(getLoginBtn());

        return new ProductPage();
    }

    public String getLoginErrorMessage(){
        System.out.println("LoginPage - getLoginErrorMessage");
        return getLoginErrorLbl().getText();
    }
}
