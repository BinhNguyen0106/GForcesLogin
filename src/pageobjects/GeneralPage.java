package pageobjects;

import common.Common;
import common.Constant;
import org.openqa.selenium.WebElement;
import pageuis.GeneralPageUI;
import pageuis.LoginPageUI;

public class GeneralPage {
    protected WebElement getAppLogoIco(){
        return Constant.driver.findElement(GeneralPageUI.icoAppLogo);}

    protected WebElement getCloseMenuBtn(){
        return Constant.driver.findElement(GeneralPageUI.btnCloseMenu);}

    protected WebElement getMoreMenuBtn(){
        return Constant.driver.findElement(GeneralPageUI.btnMoreMenu);}

    protected WebElement getLogoutLnk(){
        return Constant.driver.findElement(GeneralPageUI.lnkLogout);}

    protected WebElement getNumberOnCartLbl(){
        return Constant.driver.findElement(GeneralPageUI.lblNumberOnCart);}

    protected WebElement getCartBtn(){
        return Constant.driver.findElement(GeneralPageUI.btnCart);}
    public boolean isAppLogoIconDisplayed(){
        return getAppLogoIco().isDisplayed();
    }

    public String getNumberOfProductInCart(){
        System.out.println("GeneralPage - getNumberOfProductInCart");
        Common.scrollToView(getNumberOnCartLbl());
        return getNumberOnCartLbl().getText();
    }

    public LoginPage logout(){
        System.out.println("GeneralPage - logout");
        getMoreMenuBtn().click();
        getLogoutLnk().click();

        return new LoginPage();
    }
}
