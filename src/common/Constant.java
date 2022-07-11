package common;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Constant {
    public static WebDriver driver;
    public static WebDriver secondDriver;
    public static String PROJECT_PATH = System.getProperty("user.dir");
    public static final String TEST_URL = "https://www.saucedemo.com/";
    public static final String USERNAME_PASS = "standard_user";
    public static final String USERNAME_FAIL = "locked_out_user";
    public static final String PASSWORD = "secret_sauce";
    public static final long LONG_TIMEOUT = 30;

}
