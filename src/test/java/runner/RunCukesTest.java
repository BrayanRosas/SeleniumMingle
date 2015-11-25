

package runner;

import Framework.DriverManagement;
import common.CommonMethods;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"},
        glue={"steps"},
        features = {"src/test/resources/features"},
        monochrome = true)

public class RunCukesTest extends AbstractTestNGCucumberTests {

    private static Logger log = Logger.getLogger("RunCukesTest");

    @AfterTest
    public void afterExecution() {
        try {
            if(CommonMethods.theUserIsLogIn()){
                CommonMethods.logout();
                DriverManagement.getInstance().quitDriver();
            }
             DriverManagement.getInstance().quitDriver();
        } catch (Exception e) {
            log.error("Unable to logout after execution", e);
        }
    }

    @BeforeTest
    public void beforeExecution(){
        try {
            CommonMethods.navigateLoginPage();
        } catch (Exception e) {
            log.error("Unable to navigate to this page", e);
        }


    }

}
