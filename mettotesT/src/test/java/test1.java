import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class test1 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.lcwaikiki.com/tr-TR/TR");
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getCurrentUrl().equals("https://www.lcwaikiki.com/tr-TR/TR"));


//click to login button
        WebElement loginButton = driver.findElement(new By.ByCssSelector(".dropdown-toggle[href=" +
                "\"https://www.lcwaikiki.com/tr-TR/TR/giris\"]"));
        loginButton.click();

//input to email-password section
        WebElement userMail = driver.findElement(By.name("LoginEmail"));
        userMail.click();
        userMail.sendKeys("testinium.umutulupinar@gmail.com");

        WebElement userPassword = driver.findElement(By.id("Password"));
        userPassword.click();
        userPassword.sendKeys("Testinium2021");
        userPassword.sendKeys(Keys.ENTER);


        WebElement Hesabim = driver.findElement(By.className("dropdown-label"));
        String controlofLogin = Hesabim.getText();
        System.out.println(controlofLogin.equals("Hesabım"));


//input to search space
        WebElement searchSpace = driver.findElement(By.id("search_input"));
        searchSpace.click();
        searchSpace.clear();
        searchSpace.sendKeys("pantolon");
        searchSpace.sendKeys(Keys.ENTER);

//scroll down to the end of the page
        Thread.sleep(10000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        // Thread.sleep(10000);

//click the Daha fazla Urun Gor
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='divModels']/div[7]/div/div[4]/a/p")));
        WebElement dahafazlaButton = driver.findElement(By.xpath("//*[@id='divModels']/div[7]/div/div[4]/a/p"));

        js.executeScript("arguments[0].click()", dahafazlaButton);
        // dahafazlaButton.click();

// select random product
        WebElement boxarea = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div[2]/div[7]/div/div[1]"));
        List<WebElement> AllOfProducts = boxarea.findElements(By.tagName("a"));
        System.out.println(AllOfProducts.size());
        Random r = new Random();
        int randomValue = r.nextInt(AllOfProducts.size());
        WebElement chosenProduct = AllOfProducts.get(randomValue);

//take the price of product at the List page
        // List<WebElement> AllOfProductsPrice=boxarea.findElements(By.className("basket-text"));
        // System.out.println(AllOfProductsPrice.size());
        //  WebElement chosenProductPrice=AllOfProductsPrice.get(randomValue);
        //wait.until(ExpectedConditions.textToBePresentInElement(chosenProductPrice,"Sepette"));
        // String price=chosenProductPrice.getText();
        // System.out.println(price);

//click product

        chosenProduct.click();

//click random size(clickable) ,click random height(if present)
        WebElement boxareaForSize = driver.findElement(By.id("option-size"));
        List<WebElement> AllOfSizes = boxareaForSize.findElements(By.tagName("a"));
        System.out.println(AllOfSizes.size());
        Random rForSize = new Random();
        int randomValueForSize = rForSize.nextInt(AllOfSizes.size());
        WebElement chosenSize = AllOfSizes.get(randomValueForSize);
        System.out.println(!chosenSize.isDisplayed() && chosenSize.isEnabled());
        while (!chosenSize.isDisplayed() && chosenSize.isEnabled()) {
            rForSize = new Random();
            randomValueForSize = rForSize.nextInt(AllOfSizes.size());
            chosenSize = AllOfSizes.get(randomValueForSize);
            System.out.println("olmadı.tekrar");

        }
        chosenSize.click();
        Thread.sleep(10000);
        if (!chosenSize.isSelected()) {
            System.out.println("sseçilmemiş");
            Thread.sleep(10000);
            chosenSize.click();
        }


        WebElement justInProductPage = driver.findElement(By.id("productDetail-washing"));
        System.out.println(justInProductPage.isEnabled());


//add to cart

        WebElement addToCartButton = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div[1]/div[2]" +
                "/div[2]/div[2]/div[1]/div/div[4]/div[3]/div/div/div/div[2]/a"));
        addToCartButton.click();

//click the basket
        WebElement basketButton = driver.findElement(By.className("header-cart"));
        basketButton.click();


    }
}