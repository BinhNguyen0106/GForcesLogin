package testcases;

import common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.GeneralPage;
import pageobjects.LoginPage;
import pageobjects.ProductPage;

public class TestProductPage extends TestBase{
    LoginPage loginPage = new LoginPage();
    ProductPage productPage;

    @Test
    public void testAddAllProductsToCart() {
        System.out.println("TestProductPage - testProductAddedToCart");
        productPage = loginPage.login(Constant.USERNAME_PASS, Constant.PASSWORD)
                .addAllProductsToCart();
        Assert.assertEquals(productPage.getAllProductsOnAPage(), productPage.getNumberOfProductInCart());
    }
}
