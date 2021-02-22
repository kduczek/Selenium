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
        hp.waitInSeconds(1);

        Assertions.assertTrue(hp.isDisplayedSimpleProgressBar());

        hp.waitInSeconds(2);

        Assertions.assertFalse(hp.isDisplayedSimpleProgressBar());
    }

    @Test
    public void customMessageProgressBarTest() {
        hp.clickDialogCustomMessageButton();
        hp.waitInSeconds(1);

        Assertions.assertTrue(hp.isDisplayedCustomMessageProgressBar());

        hp.waitInSeconds(3);

        Assertions.assertFalse(hp.isDisplayedCustomMessageProgressBar());
    }

    @Test
    public void customSettingsProgressBarTest() {
        hp.clickDialogCustomSettingsButton();
        hp.waitInSeconds(1);

        Assertions.assertTrue(hp.isDisplayedCustomSettingsProgressBar());

        hp.waitInSeconds(5);

        Assertions.assertFalse(hp.isDisplayedCustomSettingsProgressBar());
    }


    @AfterAll
    static void closeBrowser() {
        browser.manage().deleteAllCookies();
        browser.close();
    }

}
