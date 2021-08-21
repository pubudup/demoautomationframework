package step;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import page.YourResultsPage;

public class YourResultsStep {
    WebDriver driver;
    public YourResultsStep(DriverUtil driverUtil) {
        this.driver = driverUtil.initiateDriver();
    }

    @Then("I should see personalised results")
    public void i_should_see_personalised_results() {
        YourResultsPage yourResultsPage = new YourResultsPage(driver);
        Assert.assertEquals(YourResultsPage.getURL(), driver.getCurrentUrl());
        Assert.assertTrue(yourResultsPage.isProductVisible());
    }

}
