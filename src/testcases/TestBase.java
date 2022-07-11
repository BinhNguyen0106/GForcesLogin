package testcases;

import common.Common;
import common.Constant;
import org.testng.annotations.*;
import pageobjects.GeneralPage;
import pageobjects.LoginPage;

public class TestBase {
    Common common = new Common();

    @BeforeMethod
    public void BeforeTest(){
        System.out.println("TotoListTest - BeforeTest: Step 01");
        common.launchBrowser();
        System.out.println("TotoListTest - BeforeTest: Step 02");
        common.openUrl(Constant.TEST_URL);
    }

    @AfterMethod
    public void AfterTest(){
        common.closeBrowser();
    }
}
