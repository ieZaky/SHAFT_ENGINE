/*
package testPackage;

import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;
import com.shaft.tools.io.ReportManager;
import com.shaft.validation.Validations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JSConfirmBoxTests {

    private static final By JS_ConfirmAlert = By.xpath("//button[contains(text(),'Click for JS Confirm')]");
    private static final By JS_ResultText = By.id("result");
    private static WebDriver driver;

    @BeforeClass
    public void navigateToJSAlertPage() {
        driver = DriverFactory.getDriver();
        BrowserActions.getInstance().navigateToURL("http://the-internet.herokuapp.com/javascript_alerts");
    }

    @AfterClass(alwaysRun = true)
    public void tearDownDriver() {
        BrowserActions.getInstance().closeCurrentWindow();
    }

    @Test
    public void dismissAlert() {
        ElementActions.getInstance().click(JS_ConfirmAlert);
        ElementActions.getInstance().performAlertAction().dismissAlert();
    }

    @Test(dependsOnMethods = "dismissAlert")
    public void assertOnCancelAlertResultText() {
        Validations.assertThat().element(driver, JS_ResultText).text().isEqualTo("You clicked: Cancel").perform();
    }

    @Test(dependsOnMethods = "assertOnCancelAlertResultText")
    public void getAlertText() {
        ElementActions.getInstance().click(JS_ConfirmAlert);
        ReportManager.logDiscrete("Alert text is: [" + ElementActions.getInstance().performAlertAction().getAlertText() + "]");
        Validations.assertThat().object(ElementActions.getInstance().performAlertAction().getAlertText()).isEqualTo("I am a JS Confirm").perform();
    }

    @Test(dependsOnMethods = "getAlertText")
    public void acceptAlert() {
        ElementActions.getInstance().click(JS_ConfirmAlert);
        ElementActions.getInstance().performAlertAction().acceptAlert();
    }

    @Test(dependsOnMethods = "acceptAlert")
    public void assertOnConfirmAlertResultText() {
        Validations.assertThat().element(driver, JS_ResultText).text().isEqualTo("You clicked: Ok").perform();
    }
}
*/
