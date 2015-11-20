package common;

import ui.PageTransporter;


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
}
