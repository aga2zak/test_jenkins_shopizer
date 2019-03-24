package pl.infoshare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pl.infoshare.elements.Button;


public class HandbagCatalouqePage extends BasePage {

    private final By chickVintageDeVilleLink = By.cssSelector("#productsContainer [item-name='Chic vintage DeVille'] div.store-btn-addtocart");
    private Button addToCart;
    private By shippingCartLink= By.cssSelector("#miniCartSummary a span");
    private Button shoppingCart;
    private By chackoutLink;
    private Button checkout;
    private By randomBag;

    public HandbagCatalouqePage(WebDriver driver){
        super(driver);
        this.url = "http://demo.shopizer.com:8080/shop/category/handbags.html/ref=c:1";
        this.driver.get(this.url);
        this.addToCart = new Button(this.driver, this.chickVintageDeVilleLink);
    }

    public void addToCart(){
        this.addToCart.click();
    }

    public void checkout(){
        this.shoppingCart = new Button(this.driver, this.shippingCartLink);
        this.shoppingCart.safeClick();
        this.chackoutLink= By.cssSelector("li.checkout-bg a");
        this.checkout= new Button(this.driver, this.chackoutLink);
        checkout.clickWithJs();
    }

    public void getRandomBag(String name){
        randomBag = By.cssSelector("#productsContainer [item-name='"+name+"'] div.store-btn-addtocart");
        this.addToCart = new Button(this.driver, this.randomBag);
    }
}
