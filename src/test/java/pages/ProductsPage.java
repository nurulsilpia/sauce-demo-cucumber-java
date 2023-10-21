package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductsPage {
    private WebDriver driver;

    private By btnAddToCart = By.id("add-to-cart-sauce-labs-backpack");
    private By productList = By.id("item_4_title_link");
    private By cartLogo = By.className("shopping_cart_link");
    private By cartItem = By.className("cart_item");
    private By itemName = By.className("inventory_item_name");
    private By selectFilter = By.className("product_sort_container");
    private By btnCheckout = By.id("checkout");
    private By inpFirstName = By.id("first-name");
    private By inpLastName = By.id("last-name");
    private By inpZipCode = By.id("postal-code");
    private By btnContinue = By.id("continue");
    private By btnFinish = By.id("finish");
    private By titlePage = By.className("title");
    private By complateHeader = By.className("complete-header");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickBtnAddtoCart() {
        WebElement btnAdd = driver.findElement(btnAddToCart);
        btnAdd.click();
    }

    public void detailProduct() {
        WebElement product = driver.findElement(productList);
        product.click();
    }

    public void clickCartLogo() {
        WebElement cart = driver.findElement(cartLogo);
        cart.click();
    }

    public void clickButtonFilter() {
        WebElement filter = driver.findElement(selectFilter);
        filter.click();
    }

    public void selectZtoA() {
        WebElement ZtoA = driver.findElement(selectFilter);
        Select option = new Select(ZtoA);
        option.selectByValue("za");
    }

    public void verifyNameZtoA() {
        List<WebElement> elementList = driver.findElements(itemName);
        List<String> originalTextList = new ArrayList<>();

        for (WebElement element : elementList) {
            originalTextList.add(element.getText());
        }

        List<String> sortedTextList = new ArrayList<>(originalTextList);
        Collections.sort(sortedTextList, Collections.reverseOrder());

        Assert.assertEquals("Elemen tidak diurutkan dari Z ke A", originalTextList, sortedTextList);
    }

    public void verifyCountProductOnCart() {
        List<WebElement> cartItems = driver.findElements(cartItem);
        Assert.assertTrue("Expected more than zero 'cart_item' element.", cartItems.size() > 0);
    }

    public void clickBtnCheckout() {
        WebElement buttonCheckout = driver.findElement(btnCheckout);
        buttonCheckout.click();
    }

    public void clickBtnContinue() {
        WebElement buttonContinue = driver.findElement(btnContinue);
        buttonContinue.click();
    }

    public void clickBtnFinish() {
        WebElement buttonFinish = driver.findElement(btnFinish);
        buttonFinish.click();
    }

    public void inputFirstName(String firstName) {
        WebElement inputFirstName = driver.findElement(inpFirstName);
        inputFirstName.sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        WebElement inputLastName = driver.findElement(inpLastName);
        inputLastName.sendKeys(lastName);
    }

    public void inputZipCode(String zip) {
        WebElement inputZip = driver.findElement(inpZipCode);
        inputZip.sendKeys(zip);
    }

    public void verifyPageCheckoutOverview() {
        WebElement heading = driver.findElement(titlePage);
        String headingText = heading.getText();

        Assert.assertTrue(headingText.contains("Checkout: Overview"));
    }

    public void verifyPageCheckoutInformation() {
        WebElement heading = driver.findElement(titlePage);
        String headingText = heading.getText();

        Assert.assertTrue(headingText.contains("Checkout: Your Information"));
    }

    public void verifyPageComplete() {
        WebElement heading = driver.findElement(complateHeader);
        String headingText = heading.getText();

        Assert.assertTrue(headingText.contains("Thank you for your order!"));
    }

    public void verifyNoProductOnCart() {
        List<WebElement> cartItems = driver.findElements(cartItem);
        Assert.assertTrue("Expected more than zero 'cart_item' element.", cartItems.isEmpty());
    }

    public void verifyCantContinueCheckout() {
        WebElement checkoutButton = driver.findElement(btnCheckout);

        boolean isCheckoutButtonEnabled = checkoutButton.isEnabled();

        Assert.assertFalse("The 'checkout' button is accessible, but shouldn't be.", isCheckoutButtonEnabled);
    }
}
