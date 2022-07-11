package common;

import org.junit.rules.Timeout;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import common.Constant;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Common {
    private static WebDriverWait explicitWait;
    private static Alert alert;
    private static Select select;
    private static JavascriptExecutor jsExecutor;
    private static Actions action;
    private static final long longTimeout = Constant.LONG_TIMEOUT;

    public void launchBrowser(){
        System.out.println("Pre-condition - launchBrowser");
        System.setProperty("webdriver.chrome.driver",
                String.format("%s/browserDrivers/chromedriver.exe", Constant.PROJECT_PATH));
        Constant.driver = new ChromeDriver();
    }
    public void openUrl(String url){
        System.out.println("Pre-condition - openUrl: " + url);
        Constant.driver.get(url);
        maximum();
        Constant.driver.manage().timeouts().implicitlyWait(longTimeout, TimeUnit.SECONDS);
    }

    public void closeBrowser(){
        Constant.driver.quit();
    }

    public static void maximum(){
        Constant.driver.manage().window().maximize();
    }
    public static void sleepInSecond(long timeout){
        try {
            Thread.sleep(timeout * 1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public static WebElement findElement(By locator){
        return Constant.driver.findElement(locator);
    }

    public static List<WebElement> findElements(By locator){
        return Constant.driver.findElements(locator);
    }

    public static void enter(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
    }

    public static void click(WebElement ele){
        waitToElementClickable(ele);
        ele.click();
    }

    public static void scrollToView(WebElement element){
        jsExecutor = (JavascriptExecutor) Constant.driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
        sleepInSecond(1);

    }

    //
    public static void scrollToTop(){
        jsExecutor = (JavascriptExecutor) Constant.driver;
        jsExecutor.executeScript("window.scrollTo(0, 0);");
        sleepInSecond(1);
    }

    public static String getText(WebElement element){
        return element.getText();
    }
    public String getPageTitle(){
        return Constant.driver.getTitle();
    }

    public String getCurrentPageUrl(){
        return Constant.driver.getCurrentUrl();
    }

    public String getPageSource(){
        return Constant.driver.getPageSource();
    }

    public void backToPage(){
        Constant.driver.navigate().back();
    }

    public void refreshCurrentPage(){
        Constant.driver.navigate().refresh();
    }

    public void forwardToPage(){
        Constant.driver.navigate().forward();
    }

    public void waitToAlertPresence(){
        explicitWait = new WebDriverWait(Constant.driver, longTimeout);
        explicitWait.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert(){
        alert = Constant.driver.switchTo().alert();
        alert.accept();
    }
    public void cancelAlert() {
        alert = Constant.driver.switchTo().alert();
        alert.dismiss();
    }
    public void sendKeyToAlert(String value){
        alert = Constant.driver.switchTo().alert();
        alert.sendKeys(value);
    }
    public String getTextAlert(){
        alert = Constant.driver.switchTo().alert();
        return alert.getText();
    }

    public void switchToWindowByID(String parentID){
        Set<String> allWindows = Constant.driver.getWindowHandles();
        for(String runWindow: allWindows){
            if(!runWindow.equals(parentID)){
                Constant.driver.switchTo().window(runWindow);
                break;
            }
        }
    }

    public void switchToWindowByTitle(String title){
        Set<String> allWindows = Constant.driver.getWindowHandles();
        for(String runWindows: allWindows){
            Constant.driver.switchTo().window(runWindows);
            String currentWindow = Constant.driver.getTitle();
            if(currentWindow.equals(title)){
                break;
            }
        }
    }

    public void closeAllWindowsWithoutParent(String parentID){
        Set<String> allWindows = Constant.driver.getWindowHandles();
        for(String runWindows: allWindows){
            if(!runWindows.equals(parentID)){
                Constant.driver.switchTo().window(runWindows);
                Constant.driver.close();
            }
        }
        Constant.driver.switchTo().window(parentID);
    }



    public void selectItemInDropDown(By locator, String itemValue){
        select = new Select(findElement(locator));
        select.selectByValue(itemValue);
    }

    public String getFirstSelectedItemInDropDown(By locator){
        select = new Select(findElement(locator));
        return select.getFirstSelectedOption().getText();
    }

    public boolean isDropDownMultiple(By locator){
        select = new Select(findElement(locator));
        return select.isMultiple();
    }

    public void selectItemInCustomDropDown(By parentLocator, By childLocator, String expectedItem){
        findElement(parentLocator);
        sleepInSecond(1);

        explicitWait = new WebDriverWait(Constant.driver, longTimeout);
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(childLocator));

        List<WebElement> allItems = findElements(childLocator);

        for (WebElement item: allItems){
            if(item.getText().equals(expectedItem)){
                jsExecutor = (JavascriptExecutor) Constant.driver;
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
                sleepInSecond(1);

                item.click();
                sleepInSecond(1);
                break;
            }
        }
    }



    public String getElementAttribute(By locator, String attributeName){
        return findElement(locator).getAttribute(attributeName);
    }

    public String getElementText(By locator){
        return findElement(locator).getText();
    }

    public int countElementsSize(By locator){
        return findElements(locator).size();
    }

    public void checkToCheckbox(By locator){
        if(!findElement(locator).isSelected()){
            findElement(locator).click();
        }
    }

    public void uncheckToCheckbox(By locator){
        if(findElement(locator).isSelected()){
            findElement(locator).click();
        }
    }


    public boolean isControlDisplayed(By locator){
        return findElement(locator).isDisplayed();
    }

    public boolean isControlEnabled(By locator){
        return findElement(locator).isEnabled();
    }

    public boolean isControlSelected(By locator){
        return findElement(locator).isSelected();
    }

    public void switchToFrame(By locator){
        Constant.driver.switchTo().frame(findElement(locator));
    }

    public void switchToDefaultPage(){
        Constant.driver.switchTo().defaultContent();
    }

    public void doubleClickToElement(By locator){
        action = new Actions(Constant.driver);
        action.doubleClick(findElement(locator)).perform();
    }

    public void rightClickToElement(By locator){
        action = new Actions(Constant.driver);
        action.contextClick(findElement(locator)).perform();
    }

    public void hoverToElement(By locator){
        action = new Actions(Constant.driver);
        action.moveToElement(findElement(locator)).perform();
    }

    public void dragAndDropElement(By sourceLocator, By targetLocator){
        action = new Actions(Constant.driver);
        action.dragAndDrop(findElement(sourceLocator),
                findElement(targetLocator)).perform();
    }

    public void sendKeyBoardToElement(By locator, Keys key){
        action = new Actions(Constant.driver);
        action.sendKeys(findElement(locator), key).perform();
    }

    public Object executeForBrowser(String javascript){
        jsExecutor = (JavascriptExecutor) Constant.driver;
        return jsExecutor.executeScript(javascript);
    }

    public boolean verifyTextInInnerText(String textExpected){
        jsExecutor = (JavascriptExecutor) Constant.driver;
        String textActual = (String) jsExecutor.executeScript(
                "return document.documentElement.innerText.match('" + textExpected+ "')[0]");
        System.out.println("Text actual: " + textActual);
        return textActual.equals(textExpected);
    }

    public void scrollToBottomPage(){
        jsExecutor = (JavascriptExecutor) Constant.driver;
        jsExecutor.executeScript("window.scrollBy(0, document.body.scrollHeight)");
    }

    public void navigateToUrlByJS(String url){
        jsExecutor = (JavascriptExecutor) Constant.driver;
        jsExecutor.executeScript("window.location = '" + url + "'");
    }


    public void waitToElementPresence(By locator){
        explicitWait = new WebDriverWait(Constant.driver, longTimeout);
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitToElementVisible(By locator){
        explicitWait = new WebDriverWait(Constant.driver, longTimeout);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitToElementInvisible(By locator){
        explicitWait = new WebDriverWait(Constant.driver, longTimeout);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static void waitToElementClickable(WebElement locator){
        explicitWait = new WebDriverWait(Constant.driver, longTimeout);
        explicitWait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static String switchToNewWindow(){
        String MainWindow = Constant.driver.getWindowHandle();
        System.out.println(MainWindow);

        // Get all new opened window.
        Set<String> windows = Constant.driver.getWindowHandles();

        for(String window : windows){
            System.out.println(window);
            if (!MainWindow.equalsIgnoreCase(window)) {
                //Switch to Child window
                Constant.driver.switchTo().window(window);

                System.out.println("Moved to child window");
                //Constant.driver.close();
            }
        }
        return MainWindow;
    }

    public static void switchBackToOriginWindow(String originWindow){
        Constant.driver.switchTo().window(originWindow);
    }


}
