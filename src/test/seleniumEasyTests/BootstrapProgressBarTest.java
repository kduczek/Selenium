import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootstrapProgressBarTest {
    private static WebDriver browser;
    private static BootstrapProgressBarHomePage hp;
    @BeforeAll
    static void init() {
        browser = new ChromeDriver();
        browser.get(PathBuilder.createPath("bootstrap-progress-bar-dialog-demo.html"));
        hp = new BootstrapProgressBarHomePage(browser);
    }

    @Test
    public void simpleProgressBarTest() {
        hp.clickSimpleDialogButton();

        Assertions.assertTrue(hp.waitForSimpleProgressBarAndCheckIfDisplayed());
        Assertions.assertFalse(hp.waitForSimpleProgressBarDisappearAndCheckIfDisplayed());
    }

    @Test
    public void customMessageProgressBarTest() {
        hp.clickDialogCustomMessageButton();

        Assertions.assertTrue(hp.waitForCustomProgressBarAndCheckIfDisplayed());
        Assertions.assertFalse(hp.waitForCustomProgressBarDisappearAndCheckIfDisplayed());
    }

    @Test
    public void customSettingsProgressBarTest() {
        hp.clickDialogCustomSettingsButton();

        Assertions.assertTrue(hp.waitForCustomSettingsProgressBarAndCheckIfDisplayed());
        Assertions.assertFalse(hp.waitForCustomSettingsProgressBarDisappearAndCheckIfDisplayed());
    }


    @AfterAll
    static void closeBrowser() {
        browser.manage().deleteAllCookies();
        browser.close();
    }

}
