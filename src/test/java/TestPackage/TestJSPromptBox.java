package TestPackage;

import Pages.JSAlertsPage;
import Utilities.AlertActions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestJSPromptBox extends JSAlertsPage {

    @Test
    public void dismissAlert() {
        JSAlertsPage.ClickForJSPrompt();
        AlertActions.dismissAlert();
    }

    @Test(dependsOnMethods = "dismissAlert")
    public void assertOnCancelAlertResultText() {
        Assert.assertEquals(JSAlertsPage.getResultText(), "You entered: null");
    }

    @Test(dependsOnMethods = "assertOnCancelAlertResultText")
    public void getAlertText() {
        String alertText;
        JSAlertsPage.ClickForJSPrompt();
        alertText = AlertActions.getAlertText();
        System.out.println("Alert text is: " + alertText);
        Assert.assertEquals(alertText, "I am a JS prompt");
    }

    @Test(dependsOnMethods = "getAlertText")
    public void acceptPromptAlertWithoutTypingTextMessage() {
        AlertActions.acceptAlert();
    }

    @Test(dependsOnMethods = "acceptPromptAlertWithoutTypingTextMessage")
    public void assertOnConfirmPromptAlertWithoutTypingTextMessageResultText() {
        Assert.assertEquals(JSAlertsPage.getResultText(), "You entered:");
    }

    @Test(dependsOnMethods = "assertOnConfirmPromptAlertWithoutTypingTextMessageResultText")
    public void acceptPromptAlertWithTextMessage() {
        JSAlertsPage.ClickForJSPrompt();
        AlertActions.typeIntoPromptAlert("Prompt Alert text message");
        AlertActions.acceptAlert();
    }

    @Test(dependsOnMethods = "acceptPromptAlertWithTextMessage")
    public void assertOnConfirmPromptAlertWithTextMessageResultText() {
        Assert.assertEquals(JSAlertsPage.getResultText(), "You entered: Prompt Alert text message");
    }
}