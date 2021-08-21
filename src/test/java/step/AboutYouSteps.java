package step;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import page.AboutYouPage;
import page.YourFinancesPage;

public class AboutYouSteps {

    WebDriver driver;
    public AboutYouSteps(DriverUtil driverUtil) {
        this.driver = driverUtil.initiateDriver();
    }

    @When("I fill mandatory details on About You page")
    public void i_fill_mandatory_details_on_about_you_page() {
        AboutYouPage aboutYouPage = new AboutYouPage(driver);
        aboutYouPage.selectTitle("Mr");
        aboutYouPage.fillFirstName("John");
        aboutYouPage.fillLastName("Smith");
        aboutYouPage.fillDateOfBirth("03","05","1987");
        aboutYouPage.fillEmail("johnsmith9988@testmail.com");
        aboutYouPage.fillPhoneNumber("07492773712");
        aboutYouPage.fillPostcode("E2 6QU");
        aboutYouPage.clickSearchPostcodeButton();
        aboutYouPage.selectAddressResult();
        aboutYouPage.clickLivedYearsButton();
    }

    @And("I navigate to Your Finances page")
    public void iNavigateToYourFinancesPage() throws InterruptedException {
        AboutYouPage aboutYouPage = new AboutYouPage(driver);
        aboutYouPage.clickContinueButton();
        //Assert.assertEquals(YourFinancesPage.getURL(), driver.getCurrentUrl());

    }
}
