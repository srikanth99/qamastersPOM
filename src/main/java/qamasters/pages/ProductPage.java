package qamasters.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import qamasters.Utils;

public class ProductPage extends BasePage {
    @FindBy(linkText="Faded Short Sleeve T-shirts")
    public WebElement fadedTshirt;

    @FindBy(css="#quantity_wanted")
    public WebElement quantityField;

    @FindBy(css="#group_1")
    public WebElement sizeList;

    @FindBy(name="Blue")
    public WebElement color;

    @FindBy(name="Submit")
    public WebElement addToCartButton;

    @FindBy(css=".layer_cart")
    public WebElement cartPopUp;

    @FindBy(css=".layer_cart_product")
    public WebElement productOnCart;

    public ProductPage(){
        PageFactory.initElements(driver,this);

    }
    public void clickfadedTshirt(){
        fadedTshirt.click();
    }
    public void enterQuantity(String quantity){
        quantityField.clear();
        quantityField.sendKeys(quantity);

    }
    public void selectSize(String size){
        Utils.selectFromList(sizeList,size);
    }
    public void selectColor(){
        color.click();
    }
    public void addToCart(){
        addToCartButton.click();
    }

    public boolean itemSuccessfullyAddedToCart(){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".layer_cart")));
        return productOnCart.isDisplayed();
    }
}
