package pageobjects;

import common.Common;
import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageuis.GeneralPageUI;
import pageuis.ProductPageUI;

import java.util.List;

public class ProductPage extends GeneralPage{
    protected List<WebElement> getAllAddToCartButtons(){
        return Common.findElements(ProductPageUI.btnLstAddToCart);
    }

    protected List<WebElement> getAllProductTitles(){
        return Common.findElements(ProductPageUI.lblItemTitle);
    }

    protected List<WebElement> getAllProductDescriptions(){
        return Common.findElements(ProductPageUI.lblItemDescription);
    }

    protected WebElement getProductNameItem(String name){
        return Common.findElement(By.xpath(String.format(ProductPageUI.itmPoductName, name)));
    }
    public ProductPage addAllProductsToCart(){
        System.out.println("ProductPage - addAllProductsToCart");
        List<WebElement> btnList = getAllAddToCartButtons();
        for (WebElement item: btnList){
            Common.scrollToView(item);
            Common.click(item);
        }
        return new ProductPage();
    }

    public String getAllProductsOnAPage(){
        System.out.println("ProductPage - getAllProductsOnAPage");
        Common.scrollToTop();
        return String.valueOf(getAllProductTitles().size());
    }

    public ProductDetailPage gotoProductDetail(String productName){
        System.out.println("ProductPage - gotoProductDetail - Product name: " + productName);
        WebElement productItem = getProductNameItem(productName);
        Common.scrollToView(productItem);
        productItem.click();
        return new ProductDetailPage();
    }
}
