import cucumber.api.CucumberOptions;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/feature/",
        glue = {"src/test/step/"},
        plugin = {"pretty", "json:target/cucumberResults.json", "html:target/sites/cucumber-pretty"},
        monochrome = true
)

public class TestRunner extends AbstractTestNGCucumberTests {
}

