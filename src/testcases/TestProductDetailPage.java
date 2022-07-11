package testcases;

import common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.LoginPage;
import pageobjects.ProductDetailPage;

public class TestProductDetailPage extends TestBase{

    ProductDetailPage productDetailPage;
    LoginPage loginPage = new LoginPage();

    @Test
    public void testAddAllProductsToCart() {
        System.out.println("TestProductPage - testProductAddedToCart");
        String productName = "Sauce Labs Backpack";
        productDetailPage = loginPage.login(Constant.USERNAME_PASS, Constant.PASSWORD)
                .gotoProductDetail(productName);

        Assert.assertEquals(productName, productDetailPage.getProductDetailName());
    }
}
