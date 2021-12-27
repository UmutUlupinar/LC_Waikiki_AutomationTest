package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class homePage extends rootPage {

    public homePage(WebDriver driver) {
        super(driver);
    }
 //control the home page is open or close
    public boolean isOnHomePage() {
        return driver.getCurrentUrl().equals("https://www.lcwaikiki.com/tr-TR/TR");
    }

//login button click
    public void login() {
        WebElement loginButton=driver.findElement(new By.ByCssSelector(".dropdown-toggle[href=" +
                "\"https://www.lcwaikiki.com/tr-TR/TR/giris\"]"));
        loginButton.click();
    }

//there is 'hesabım' text under the login icon. We can know are we login or not by use this
    public boolean isAccountLogin() {
        WebElement Hesabim=driver.findElement(By.className("dropdown-label"));
        String controlTextofLogin=Hesabim.getText();
        return controlTextofLogin.equals("Hesabım");
    }
//make search
    public void makeSearch(String searchTextOfProduct) {
        WebElement searchSpace=driver.findElement(By.id("search_input"));
        searchSpace.click();
        searchSpace.clear(); //we should clear because searchbox have default input at the begin
        searchSpace.sendKeys(searchTextOfProduct);
        searchSpace.sendKeys(Keys.ENTER);
    }


}
