import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSAlertBoxTest {
    private static WebDriver browser;
    private static JSAlertBoxHomePage hp;
    @BeforeAll
    static void init() {
        browser = new ChromeDriver();
        browser.get(PathBuilder.createPath("javascript-alert-box-demo.html"));
        hp = new JSAlertBoxHomePage(browser);
    }

    @Test
    public void openAlertBox() {
        hp.alertBoxButtonClick();

        Assertions.assertEquals("I am an alert box!", hp.getAlertText());

        hp.acceptAlert();
    }

    @Test
    public void openConfirmBoxAndPressOk() {
        hp.confirmBoxButtonClick();

        Assertions.assertEquals("Press a button!", hp.getAlertText());

        hp.acceptAlert();

        Assertions.assertEquals("You pressed OK!", hp.getConfirmBoxResultText());
    }

    @Test
    public void openConfirmBoxAndPressCancel() {
        hp.confirmBoxButtonClick();

        Assertions.assertEquals("Press a button!", hp.getAlertText());

        hp.dismissAlert();

        Assertions.assertEquals("You pressed Cancel!", hp.getConfirmBoxResultText());
    }

    @Test
    public void promptBoxWithoutSendingKeys() {
        hp.alertPromptBoxClick();
        hp.acceptAlert();

        Assertions.assertEquals("You have entered 'Enter name' !", hp.promptResultText());
    }

    @Test
    public void promptBoxWithString() {
        hp.alertPromptBoxClick();
        hp.sendKeysToAlertBox("Test");
        hp.acceptAlert();

        Assertions.assertEquals("You have entered 'Test' !", hp.promptResultText());
    }

    @Test
    public void promptBoxWithSpace() {
        hp.alertPromptBoxClick();
        hp.sendKeysToAlertBox(" ");
        hp.acceptAlert();

        Assertions.assertEquals("You have entered ' ' !", hp.promptResultText());
    }

    @Test
    public void promptBoxWithSpecialCharacters() {
        hp.alertPromptBoxClick();
        hp.sendKeysToAlertBox("!@#$%^&*");
        hp.acceptAlert();

        Assertions.assertEquals("You have entered '!@#$%^&*' !", hp.promptResultText());
    }

    @Test
    public void promptBoxWithNumber() {
        hp.alertPromptBoxClick();
        hp.sendKeysToAlertBox("1982");
        hp.acceptAlert();

        Assertions.assertEquals("You have entered '1982' !", hp.promptResultText());
    }

    @Test
    public void promptBoxCancel() {
        hp.refresh();
        hp.alertPromptBoxClick();
        hp.dismissAlert();

        Assertions.assertFalse(hp.promptResultIsDisplayed());
    }


    @AfterAll
    static void closeBrowser() {
        browser.manage().deleteAllCookies();
        browser.close();
    }
}
