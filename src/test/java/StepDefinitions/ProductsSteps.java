package StepDefinitions;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.ProductsPage;

import java.util.List;
import java.util.Map;

public class ProductsSteps {
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private ProductsPage productsPage = new ProductsPage(DriverFactory.getDriver());

    @Given("User already login with valid credential")
    public void userAlreadyLoginWithValidCredential(DataTable credTable) throws InterruptedException {
        List<Map<String, String>> credList = credTable.asMaps();
        String username = credList.get(0).get("username");
        String password = credList.get(0).get("password");

        DriverFactory.getDriver().navigate().to("https://www.saucedemo.com/");
        productsPage = loginPage.doLogin(username, password);
        Thread.sleep(5000);
    }

    @When("I click button Add to cart")
    public void iClickButtonAddToCart() {
        productsPage.clickBtnAddtoCart();
    }

    @And("I click cart logo on the top right")
    public void iClickCartLogoOnTheTopRight() {
        productsPage.clickCartLogo();
    }

    @Then("The system will display the products that I added")
    public void theSystemWillDisplayTheProductsThatIAdded() {
        productsPage.verifyCountProductOnCart();
    }

    @When("I detailing product")
    public void iDetailingProduct() {
        productsPage.detailProduct();
    }

    @When("I click button filter")
    public void iClickButtonFilter() {
        productsPage.clickButtonFilter();
    }

    @And("I select option name Z to A")
    public void iSelectOptionNameZToA() {
        productsPage.selectZtoA();
    }

    @Then("The product is sort by name Z to A")
    public void theProductIsSortByNameZToA() {
        productsPage.verifyNameZtoA();
    }

    @And("I click button Checkout")
    public void iClickButtonCheckout() {
        productsPage.clickBtnCheckout();
    }

    @Then("The system will display checkout information")
    public void theSystemWillDisplayCheckoutInformation() {
        productsPage.verifyPageCheckoutInformation();
    }

    @And("I click button Continue")
    public void iClickButtonContinue() {
        productsPage.clickBtnContinue();
    }

    @Then("The system will display checkout overview")
    public void theSystemWillDisplayCheckoutOverview() {
        productsPage.verifyPageCheckoutOverview();
    }

    @When("I click button Finish")
    public void iClickButtonFinish() {
        productsPage.clickBtnFinish();
    }

    @Then("Payment is complete")
    public void paymentIsComplete() {
        productsPage.verifyPageComplete();
    }

    @And("I make sure that there is no product on the cart")
    public void iMakeSureThatThereIsNoProductOnTheCart() {
        productsPage.verifyNoProductOnCart();
    }

    @Then("I can't continue payment proses")
    public void iCanTContinuePaymentProses() {
        productsPage.verifyCantContinueCheckout();
    }

    @When("^I input First Name (.*)$")
    public void iInputFirstName(String firstName) {
        productsPage.inputFirstName(firstName);
    }

    @And("^I input Last Name (.*)$")
    public void iInputLastName(String lastName) {
        productsPage.inputLastName(lastName);
    }

    @And("^I input Zip Code (.*)$")
    public void iInputZipCode(String zip) {
        productsPage.inputZipCode(zip);
    }
}
