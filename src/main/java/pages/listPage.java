package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class listPage extends rootPage {
    public listPage(WebDriver driver) {
        super(driver);
    }
//return as Webelement so method is usable for other methods like click or get
    public WebElement selectRandomProduct() {
        WebElement boxarea= driver.findElement(By.xpath("/html/body/div[5]/div[3]/div[2]/div[7]/div/div[1]"));
//boxarea is the total chart of products element in the page. Boxarea include all of the products
        List<WebElement> AllOfProducts=boxarea.findElements(By.tagName("a"));
//There is List for the product list as WebElement.
        //System.out.println(AllOfProducts.size());//We can control products number but unnecessary
        Random r = new Random();
        int randomValue = r.nextInt(AllOfProducts.size());
        WebElement chosenProduct=AllOfProducts.get(randomValue);
        return chosenProduct;
    }

    public void clickProduct(WebElement chosenProduct) {
        selectRandomProduct().click();
    }
//scroll to the end of the page.Calculate document height
    public void scrolldown() throws InterruptedException {
        Thread.sleep(10000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
//this method begin after the scrollDown. ScrollDown method use JavascriptExecutor that will caused unnecessary waiting
//We use code below for avoid this situation.(Click methods different)
    public void extensionList() {
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='divModels']/div[7]/div/div[4]/a/p")));
        WebElement dahafazlaButton=driver.findElement(By.xpath("//*[@id='divModels']/div[7]/div/div[4]/a/p"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", dahafazlaButton);

    }

//I couldnt take Price text. Code below is useful if will being improved.
    /*  public String takeListPriceOfProduct(WebElement chosenProduct) {
        List<WebElement> AllOfProductsPrice=boxarea.findElements(By.className("basket-text"));
        System.out.println(AllOfProductsPrice.size());
        WebElement chosenProductPrice=AllOfProductsPrice.get(randomValue);
        wait.until(ExpectedConditions.textToBePresentInElement(chosenProductPrice,"Sepette"));
        String price=chosenProductPrice.getText();
        System.out.println(price);
        return chosenProduct.getText();
    }*/


}
