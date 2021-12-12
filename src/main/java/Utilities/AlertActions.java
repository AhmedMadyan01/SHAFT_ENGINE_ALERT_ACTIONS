package Utilities;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class AlertActions extends TestBase {

    public static void waitForAlertToBePresent() {
        try {
            webDriverWait.until(ExpectedConditions.alertIsPresent());
            webDriver.switchTo().alert();
            System.out.println("Alert is present");
        } catch (NoAlertPresentException exception) {
            System.out.println("Alert is not present");
        }
    }

    public static boolean isAlertPresent() {
        try {
            waitForAlertToBePresent();
            webDriver.switchTo().alert();
            System.out.println("Alert is present");
            return true;
        } catch (NoAlertPresentException exception) {
            System.out.println("Alert is not present");
            return false;
        }
    }

    public static void acceptAlert() {
        waitForAlertToBePresent();
        if (isAlertPresent()) {
            Assert.assertTrue(isAlertPresent());
        } else {
            Assert.assertFalse(isAlertPresent());
        }
        webDriver.switchTo().alert().accept();
    }

    public static void dismissAlert() {
        if (isAlertPresent()) {
            Assert.assertTrue(isAlertPresent());
        } else {
            Assert.assertFalse(isAlertPresent());
        }
        waitForAlertToBePresent();
        webDriver.switchTo().alert().dismiss();
    }

    public static String getAlertText() {
        waitForAlertToBePresent();
        if (isAlertPresent()) {
            Assert.assertTrue(isAlertPresent());
        } else {
            Assert.assertFalse(isAlertPresent());
        }
        System.out.println(webDriver.switchTo().alert().getText());
        return webDriver.switchTo().alert().getText();
    }

    public static void typeIntoPromptAlert(String text) {
        waitForAlertToBePresent();
        if (isAlertPresent()) {
            Assert.assertTrue(isAlertPresent());
        } else {
            Assert.assertFalse(isAlertPresent());
        }
        webDriver.switchTo().alert().sendKeys(text);
    }
}
