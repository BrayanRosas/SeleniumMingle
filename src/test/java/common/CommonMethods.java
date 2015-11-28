package common;

import Framework.DriverManagement;
import org.openqa.selenium.WebDriver;
import ui.PageTransporter;
import ui.pages.MainPage;


/**
 * Created with IntelliJ IDEA.
 * User: BrayanRosas
 * Date: 11/19/15
 * Time: 8:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class CommonMethods {

    /**
     * Log outs from the web app
     */


    public static void navigateLoginPage() {
       PageTransporter.getInstance().navigateToLoginPage();

    }

    public static void logout(){
      PageTransporter.getInstance().closeLoginPage();

    }

    public static boolean theUserIsLogIn()
    {
        WebDriver driver = DriverManagement.getInstance().getDriver();
        if(driver.getCurrentUrl().contains("login"))
            return false;
        else
            return true;
    }




}
