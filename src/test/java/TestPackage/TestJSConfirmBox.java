package TestPackage;

import Pages.JSAlertsPage;
import Utilities.AlertActions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestJSConfirmBox extends JSAlertsPage {

    @Test
    public void dismissAlert() {
        JSAlertsPage.ClickForJSConfirm();
        AlertActions.dismissAlert();
    }

    @Test(dependsOnMethods = "dismissAlert")
    public void assertOnCancelAlertResultText() {
        Assert.assertEquals(JSAlertsPage.getResultText(), "You clicked: Cancel");
    }

    @Test(dependsOnMethods = "assertOnCancelAlertResultText")
    public void getAlertText() {
        String alertText;
        JSAlertsPage.ClickForJSConfirm();
        alertText = AlertActions.getAlertText();
        System.out.println("Alert text is: " + alertText);
        Assert.assertEquals(alertText, "I am a JS Confirm");
    }

    @Test(dependsOnMethods = "getAlertText")
    public void acceptAlert() {
        AlertActions.acceptAlert();
    }

    @Test(dependsOnMethods = "acceptAlert")
    public void assertOnConfirmAlertResultText() {
        Assert.assertEquals(JSAlertsPage.getResultText(), "You clicked: Ok");
    }
}