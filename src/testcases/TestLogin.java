package testcases;

import common.Common;
import common.Constant;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.GeneralPage;
import pageobjects.LoginPage;

import java.io.IOException;

public class TestLogin extends TestBase{
    LoginPage loginPage = new LoginPage();
    GeneralPage generalPage;

    @Test
    public void testLoginSuccessfully() {
        System.out.println("TestLogin - testLogin");
        generalPage = loginPage.login(Constant.USERNAME_PASS, Constant.PASSWORD);
        Assert.assertTrue(generalPage.isAppLogoIconDisplayed());
    }

    @Test
    public void testLoginFailed() {
        System.out.println("TestLogin - testLogin");
        String expected_error_msg = "Epic sadface: Sorry, this user has been locked out.";
        loginPage.login(Constant.USERNAME_FAIL, Constant.PASSWORD);

        String actual_error_msg = loginPage.getLoginErrorMessage();
        System.out.println("Expected: " + expected_error_msg);
        System.out.println("Actual: " + actual_error_msg);
        Assert.assertEquals(expected_error_msg, actual_error_msg);
    }

}
