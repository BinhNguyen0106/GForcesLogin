package pageuis;

import org.openqa.selenium.By;

public class ProductPageUI {
    private static final String itemLabelXpath = "//div[@class = 'inventory_item_label']";
    public static final By lblItemTitle = By.xpath(itemLabelXpath + "//div[@class = 'inventory_item_name']");
    public static final By lblItemDescription = By.xpath(itemLabelXpath + "//div[@class = 'inventory_item_desc']");
    public static final By btnLstAddToCart = By.xpath("//button[starts-with(@id, 'add-to-cart')]");
    public static String itmPoductName = "//div[text() = '%s']";
}
