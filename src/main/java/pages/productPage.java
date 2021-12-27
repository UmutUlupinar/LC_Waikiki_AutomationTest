package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class productPage extends rootPage {

    public productPage(WebDriver driver) {
        super(driver);
    }
//The 'productDetail-washing' id is specific to the product page
    public boolean isOnProductPage() {
        WebElement justInProductPage=driver.findElement(By.id("productDetail-washing"));

        return justInProductPage.isEnabled();

    }
//Size choose is randomly.
// But some products have non-clickable size.The While loop here for detect clickable size option.
    public void selectSize() {
        WebElement boxareaForSize=driver.findElement(By.id("option-size"));
        List<WebElement> AllOfSizes=boxareaForSize.findElements(By.tagName("a"));
        System.out.println(AllOfSizes.size());
        Random rForSize = new Random();
        int randomValueForSize = rForSize.nextInt(AllOfSizes.size());
        WebElement chosenSize=AllOfSizes.get(randomValueForSize);
        // System.out.println(!chosenSize.isDisplayed() && chosenSize.isEnabled()); //Control Line
        while (!chosenSize.isDisplayed() && chosenSize.isEnabled())
        {
            rForSize = new Random();
            randomValueForSize = rForSize.nextInt(AllOfSizes.size());
            chosenSize=AllOfSizes.get(randomValueForSize);
            //System.out.println("trying again");//Control Line
        }
        chosenSize.click();
    }

    public void addToCart() {
    WebElement addToCartButton=driver.findElement(By.xpath("/html/body/div[5]/div[3]/div[1]/div[2]" +
            "/div[2]/div[2]/div[1]/div/div[4]/div[3]/div/div/div/div[2]/a"));
    addToCartButton.click();
    }

    public void clickTheBasket() {
        WebElement basketButton=driver.findElement(By.className("header-cart"));
        basketButton.click();
    }
}
