package ui;

import Framework.DriverManagement;
import org.openqa.selenium.WebDriver;
import ui.pages.LoginPage;
import ui.pages.NewProjectPage;

/**
 * Created with IntelliJ IDEA.
 * User: BrayanRosas
 * Date: 11/10/15
 * Time: 6:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class PageTransporter {
    private WebDriver driver= DriverManagement.getInstance().getDriver();
    private String loginURL="https://jala-foundation.mingle.thoughtworks.com";
    private String newProjectURL="https://jala-foundation.mingle.thoughtworks.com/admin/projects/new";
    private  static PageTransporter instance;

    protected  PageTransporter(){

        initialize();
    }

    public static  PageTransporter getInstance(){

        if(instance == null) {
            instance = new PageTransporter();
        }
        return instance;

    }

    private void goToURL(String url) {
        driver.navigate().to(url);
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public LoginPage navigateToLoginPage() {
        goToURL(loginURL);
        return new LoginPage();
    }
    //aqui cambiar
    public NewProjectPage navigateToProjectPage(){
       //goToURL(newProjectURL);
        return new NewProjectPage();
    }

    private void initialize() {
//        log.info("Initialize the page transporter");
    }

}




