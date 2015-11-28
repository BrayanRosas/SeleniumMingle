package ui;

import Framework.DriverManagement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import ui.pages.LoginPage;
import ui.pages.MainPage;
import ui.pages.NewProjectPage;
import utils.JsonReader;


/**
 * Created with IntelliJ IDEA.
 * User: BrayanRosas
 * Date: 11/10/15
 * Time: 6:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class PageTransporter {
    String urlsFile="C:\\Mingle\\src\\config\\urls.json";
    JsonReader jsonReader=new JsonReader();
    private WebDriver driver= DriverManagement.getInstance().getDriver();
    private String loginURL=jsonReader.readJsonFile("pages","homeUrlPage",urlsFile) ;
    private String newProjectURL=jsonReader.readJsonFile("pages","newProjectUrlPage",urlsFile);
    private  static PageTransporter instance;
    Actions actions = new Actions(driver);

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

    public void closeLoginPage(){

        driver.close();
    }

    public NewProjectPage navigateToProjectPage(){
        return new NewProjectPage();
    }

    public MainPage navigateToMainPage(){

        return new MainPage();
    }

    private void initialize() {
//      log.info("Initialize the page transporter");
    }



}




