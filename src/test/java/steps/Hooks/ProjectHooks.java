package steps.Hooks;

import cucumber.api.java.After;

/**
 * Created with IntelliJ IDEA.
 * User: BrayanRosas
 * Date: 11/28/15
 * Time: 3:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProjectHooks {

    /**
     * Delete projects created
     */
    @After(value = "@Card", order = 999)
    public void afterCardScenarios() {


    }







}
