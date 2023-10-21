package StepDefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

import java.time.Duration;

public class LoginSteps {
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

    @Given("I on login page")
    public void iOnLoginPage() {
        DriverFactory.getDriver().navigate().to("https://www.saucedemo.com/");
        loginPage.waitLoadLoginPage();
    }

    @When("^I enter username (.*)$")
    public void iEnterUsername(String username) {
        loginPage.inputUsername(username);
    }

    @And("^I enter password (.*)$")
    public void iEnterPassword(String password) {
        loginPage.inputPass(password);
    }

    @And("I click button login")
    public void iClickButtonLogin() {
        loginPage.clickBtnLogin();
    }

    @Then("The system will show error message")
    public void theSystemWillShowErrorMessage() {
        loginPage.verifyErrorLogin();
    }

    @Then("The system will redirect to the Products page")
    public void theSystemWillRedirectToThePage() {
        loginPage.verifyHeadingPage();
    }
}
