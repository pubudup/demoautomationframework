package step;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import page.AboutYouPage;
import page.BasePage;
import page.CarDetailsPage;

public class CarFinanceSteps {

    WebDriver driver;
    public CarFinanceSteps(DriverUtil driverUtil) {
        this.driver = driverUtil.initiateDriver();
    }

    @Given("I am on car finance page")
    public void i_am_on_car_finance_page() throws InterruptedException {
        CarDetailsPage carDetailsPage = new CarDetailsPage(driver);
        carDetailsPage.openCarDetailsPage();
    }

    @Then("page title should be {string}")
    public void page_title_should_be(String title) {
        BasePage basePage = new BasePage(driver);
        Assert.assertEquals(title, basePage.getPageTitle());
    }


    @When("I click terms and conditions footer link")
    public void iClickTermsAndConditionsFooterLink() {
        BasePage basePage = new BasePage(driver);
        basePage.clickTermsAndConditionsLink();

    }

    @And("I select Terms and Conditions window")
    public void iSelectTermsAndConditionsWindow() {
        BasePage basePage = new BasePage(driver);
        basePage.switchToChildWindow();
    }

    @When("I type {string} on registration number field")
    public void iOnRegistrationNumberField(String vehicleNumber) {
        CarDetailsPage carDetailsPage = new CarDetailsPage(driver);
        carDetailsPage.fillRegistrationNumber(vehicleNumber);

    }

    @And("I click Find Car button")
    public void iClickFindCarButton(){
        CarDetailsPage carDetailsPage = new CarDetailsPage(driver);
        carDetailsPage.clickFindButton();
    }

    @Then("error message {string} should be displayed")
    public void errorMessageShouldBeDisplayed(String errorMessage) {
        CarDetailsPage carDetailsPage = new CarDetailsPage(driver);
        Assert.assertEquals(errorMessage,carDetailsPage.getInvalidRegistrationErrorMessage());
    }

    @When("I fill mandatory details on Car Finance page")
    public void iFillMandatoryDetailsOnCarFinancePage(){
        CarDetailsPage carDetailsPage = new CarDetailsPage(driver);
        carDetailsPage.clickRegistrationIDNoButton();
        carDetailsPage.fillCarValue("12000");
        carDetailsPage.fillDepositAmount("3000");
        carDetailsPage.selectPaymentYears(3);
    }

    @And("I navigate to About You page")
    public void iNavigateToAboutYouPage() {
        CarDetailsPage carDetailsPage = new CarDetailsPage(driver);
        carDetailsPage.clickContinueButton();
        //Assert.assertEquals(AboutYouPage.getURL(), driver.getCurrentUrl());
    }
}
