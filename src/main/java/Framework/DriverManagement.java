package Framework;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: BrayanRosas
 * Date: 11/9/15
 * Time: 7:15 PM
 * To change this template use File | Settings | File Templates.
 */

public class DriverManagement
{
   private static DriverManagement instance = null;

    private WebDriver driver;
    private WebDriverWait wait;

    public DriverManagement()
    {
        initializeDriver();
    }

    private void initializeDriver()
    {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(65, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,40, 100);


    }

    public static DriverManagement getInstance()
    {
        if(instance == null)
        {
            instance = new DriverManagement();
        }
        return instance;
    }


    public WebDriver getDriver()
    {
        return driver;
    }

    public WebDriverWait getWait()
    {
        return wait;
    }

    public void quitDriver(){
        driver.quit();
    }




}
