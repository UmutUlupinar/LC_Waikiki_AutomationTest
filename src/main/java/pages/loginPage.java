package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage extends rootPage {

    public loginPage(WebDriver driver) {
        super(driver);
    }
//mailAccount string is defined at the Tests.java class.Also we can this with configuration.properties file.
    public void emailBox(String mailAccount) {
        WebElement userMail=driver.findElement(By.name("LoginEmail"));
        userMail.click();
        userMail.sendKeys(mailAccount);
    }

    public void passwordBox(String passwordOfAccount) {
        WebElement userPassword=driver.findElement(By.id("Password"));
        userPassword.click();
        userPassword.sendKeys(passwordOfAccount);
        userPassword.sendKeys(Keys.ENTER);

    }


}
