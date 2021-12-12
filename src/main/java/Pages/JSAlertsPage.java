package Pages;

import Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class JSAlertsPage extends TestBase {
    private static final By JS_AlertBox = By.xpath("//button[contains(text(),'Click for JS Alert')]");
    private static final By JS_ConfirmAlert = By.xpath("//button[contains(text(),'Click for JS Confirm')]");
    private static final By JS_PromptAlert = By.xpath("//button[contains(text(),'Click for JS Prompt')]");
    private static final By JS_ResultText = By.id("result");

    public static void ClickForJSAlert() {
        TestBase.webDriverWait.until(ExpectedConditions.presenceOfElementLocated(JS_AlertBox));
        TestBase.webDriver.findElement(JS_AlertBox).click();
    }

    public static void ClickForJSConfirm() {
        TestBase.webDriverWait.until(ExpectedConditions.presenceOfElementLocated(JS_ConfirmAlert));
        TestBase.webDriver.findElement(JS_ConfirmAlert).click();
    }

    public static void ClickForJSPrompt() {
        TestBase.webDriverWait.until(ExpectedConditions.presenceOfElementLocated(JS_PromptAlert));
        TestBase.webDriver.findElement(JS_PromptAlert).click();
    }

    public static String getResultText() {
        String resultText;
        TestBase.webDriverWait.until(ExpectedConditions.presenceOfElementLocated(JS_ResultText));
        resultText = TestBase.webDriver.findElement(JS_ResultText).getText();
        return resultText;
    }
}
