package Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created with IntelliJ IDEA.
 * User: BrayanRosas
 * Date: 11/9/15
 * Time: 7:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main(String[] args) {


        DriverManagement driver=new DriverManagement();

        driver.getDriver().findElement(By.id("user_login"))
                .sendKeys("brayan_rosas");
        driver.getDriver().findElement(By.id("user_password"))
                .sendKeys("Bgrf44360303bpm.");
        driver.getDriver().findElement(By.name("commit")).click();



    }
}
