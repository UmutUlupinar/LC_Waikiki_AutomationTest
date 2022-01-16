import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.lang.* ;

//this class extends rootTest because take common methods and acts
public class Tests extends rootTest{

//creating page objects
    homePage homepage;
    loginPage loginpage;
    listPage listpage;
    productPage productpage;
    cartPage cartpage;
//tests processing with order
    @Test
    @Order(1)
    public void login(){

        homepage=new homePage(driver);
        loginpage=new loginPage(driver);
        homepage.login();
        loginpage.emailBox("testinium.umutulupinar@gmail.com"); //this account and passw just for the this test.
        loginpage.passwordBox("Testinium2021");            //Also we can use conf.prop file for assign.
        Assertions.assertTrue(homepage.isAccountLogin(),"Account did'nt login");
    }

    @Order(2)
    public void searchProduct() throws InterruptedException {
        homepage.makeSearch("pantolon");
        listpage.scrolldown();
        listpage.extensionList();
    }

    @Test
    @Order(3)
    public void selectProduct(){
        WebElement chosenProduct= listpage.selectRandomProduct();
        // listpage.takeListPriceOfProduct(); //take the price of product which is on the list page
        listpage.clickProduct(chosenProduct);
        Assertions.assertTrue(productpage.isOnProductPage(),"didn't select a product");
    }

    @Test
    @Order(4)
    public void priceCompare(){
        //productpage.takeBasketPriceOfProduct();
        //Assertions.assertTrue(PricesEquality());
    }

    @Test
    @Order(5)
    public void addtoCart(){
        productpage.selectSize();
        productpage.addToCart();
        productpage.clickTheBasket();
        cartpage.increaseQuantity();
        Assertions.assertTrue(cartpage.isaddedTwoProduct(),"The product number has'nt been increased to two");
    }

    @Test
    @Order(6)
    public void emptyCart(){
        cartpage.deleteProduct();
        Assertions.assertTrue(cartpage.isBasketEmpty());
    }

    @Test
    @Order(7)
    public void onCart(){
       Assertions.assertTrue(cartpage.isBasketEmpty());
    }





}
