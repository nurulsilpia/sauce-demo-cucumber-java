package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;

    private By inpUsername = By.name("user-name");
    private By inpPass = By.name("password");
    private By btnLogin = By.id("login-button");
    private By badgeError = By.className("error-message-container");
    private By headingPage = By.xpath("//*[@id=\"header_container\"]/div[2]/span");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitLoadLoginPage() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(inpUsername));
    }

    public void inputUsername(String username) {
        WebElement inputEmail = driver.findElement(inpUsername);
        inputEmail.sendKeys(username);
    }

    public void inputPass(String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(inpPass));

        WebElement inputPass = driver.findElement(inpPass);
        inputPass.sendKeys(password);
    }

    public void clickBtnLogin() {
        WebElement buttonLogin = driver.findElement(btnLogin);
        buttonLogin.click();
    }

    public void verifyErrorLogin() {
        WebElement error = driver.findElement(badgeError);
        String errorText = error.getText();

        Assert.assertTrue(errorText.contains("Username and password do not match any user in this service"));
    }

    public void verifyHeadingPage() {
        WebElement heading = driver.findElement(headingPage);
        String headingText = heading.getText();

        Assert.assertTrue(headingText.contains("Products"));
    }

    public ProductsPage doLogin(String un, String pwd) throws InterruptedException {
        System.out.println("login with: " + un + " and " + pwd);

        inputUsername(un);
        clickBtnLogin();
        inputPass(pwd);
        clickBtnLogin();

        return new ProductsPage(driver);
    }
}
