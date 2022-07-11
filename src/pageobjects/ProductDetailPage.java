package pageobjects;

import common.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageuis.ProductDetailPageUI;
import pageuis.ProductPageUI;

public class ProductDetailPage {
    protected WebElement getProductDetailNameLabel(){
        return Common.findElement(ProductDetailPageUI.productDetailName);
    }

    public String getProductDetailName(){
        return Common.getText(getProductDetailNameLabel());
    }
}
