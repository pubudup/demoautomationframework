package step;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import page.YourFinancesPage;

public class YourFinancesStep {

    WebDriver driver;

    public YourFinancesStep(DriverUtil driverUtil) {
        this.driver = driverUtil.initiateDriver();
    }

    @When("I fill mandatory details on Finances page")
    public void i_fill_mandatory_details_on_finances_page() {
        YourFinancesPage yourFinancesPage = new YourFinancesPage(driver);
        yourFinancesPage.fillGrossAnnualIncomeTextBox("50000");
        yourFinancesPage.selectResidentialStatus("Private Tenant");
        yourFinancesPage.selectEmploymentStatus("Employed");
        yourFinancesPage.clickDependents();
        yourFinancesPage.fillEmploymentTitle("Software Engineer");
        yourFinancesPage.fillEmploymentIndustry("Computers - Software");
        yourFinancesPage.fillMonthlyRentMortgateTextBox("800");
    }

    @And("I accept privacy statement")
    public void iAcceptPrivacyStatement() throws InterruptedException {
        YourFinancesPage yourFinancesPage = new YourFinancesPage(driver);
        yourFinancesPage.clickPrivacyStatementButton();
    }
}
