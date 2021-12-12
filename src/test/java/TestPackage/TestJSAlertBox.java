package TestPackage;

import Pages.JSAlertsPage;
import Utilities.AlertActions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestJSAlertBox extends JSAlertsPage {

    @Test
    public void getAlertText() {
        String alertText;
        JSAlertsPage.ClickForJSAlert();
        alertText = AlertActions.getAlertText();
        System.out.println("Alert text is: " + alertText);
        Assert.assertEquals(alertText, "I am a JS Alert");
    }

    @Test(dependsOnMethods = "getAlertText")
    public void acceptAlert() {
        AlertActions.acceptAlert();
    }

    @Test(dependsOnMethods = "acceptAlert")
    public void assertOnConfirmAlertResultText() {
        Assert.assertEquals(JSAlertsPage.getResultText(), "You successfully clicked an alert");
    }
}