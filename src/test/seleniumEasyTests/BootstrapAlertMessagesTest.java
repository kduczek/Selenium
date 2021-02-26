import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootstrapAlertMessagesTest {
    private static WebDriver browser;
    private static BootstrapAlertMessagesHomePage hp;
    @BeforeAll
    static void init() {
        browser = new ChromeDriver();
        browser.get(PathBuilder.createPath("bootstrap-alert-messages-demo.html"));
        hp = new BootstrapAlertMessagesHomePage(browser);
    }


    @Test
    public void normalSuccessTest() {
        hp.clickNormalSuccess();

        Assertions.assertTrue(hp.isDisplayedNormalSuccess());
        hp.closeNormalSuccess();
        Assertions.assertFalse(hp.isDisplayedNormalSuccess());
    }

    @Test
    public void normalWarningTest() {
        hp.clickNormalWarning();

        Assertions.assertTrue(hp.isDisplayedNormalWarning());

        hp.closeNormalWarning();

        Assertions.assertFalse(hp.isDisplayedNormalWarning());
    }

    @Test
    public void normalDangerTest() {
        hp.clickNormalDanger();

        Assertions.assertTrue(hp.isDisplayedNormalDanger());

        hp.closeNormalDanger();

        Assertions.assertFalse(hp.isDisplayedNormalDanger());
    }

    @Test
    public void normalInfoTest() {
        hp.clickNormalInfo();

        Assertions.assertTrue(hp.isDisplayedNormalInfo());

        hp.closeNormalInfo();

        Assertions.assertFalse(hp.isDisplayedNormalInfo());
    }

    @Test
    public void AutocloseableSuccessTest() {
        hp.clickAutocloseableSuccess();

        Assertions.assertTrue(hp.isDisplayedAutocloseableSuccess());

        hp.waitToElementDisappear(hp.autocloseableSuccessDiv);

        Assertions.assertFalse(hp.isDisplayedAutocloseableSuccess());
    }

    @Test
    public void autocloseableWarningTest() {
        hp.clickAutocloseableWarning();

        Assertions.assertTrue(hp.isDisplayedAutocloseableWarning());

        hp.waitToElementDisappear(hp.autocloseableWarningDiv);

        Assertions.assertFalse(hp.isDisplayedAutocloseableWarning());
    }

    @Test
    public void autocloseableDangerTest() {
        hp.clickAutocloseableDanger();

        Assertions.assertTrue(hp.isDisplayedAutocloseableDanger());

        hp.waitToElementDisappear(hp.autocloseableDangerDiv);

        Assertions.assertFalse(hp.isDisplayedAutocloseableDanger());
    }

    @Test
    public void autocloseableInfoTest() {
        hp.clickAutocloseableInfo();

        Assertions.assertTrue(hp.isDisplayedAutocloseableInfo());

        hp.waitToElementDisappear(hp.autocloseableInfoDiv);

        Assertions.assertFalse(hp.isDisplayedAutocloseableInfo());
    }

    @Test
    public void twoNormalAlerts() {
        hp.clickNormalSuccess();
        hp.clickNormalWarning();

        Assertions.assertTrue(hp.isDisplayedNormalWarning());
        Assertions.assertTrue(hp.isDisplayedNormalSuccess());

        hp.closeNormalWarning();
        hp.closeNormalSuccess();

        Assertions.assertFalse(hp.isDisplayedNormalWarning());
        Assertions.assertFalse(hp.isDisplayedNormalSuccess());

    }

    @Test
    public void allAutocloseableAlerts() {
        hp.clickAutocloseableSuccess();
        hp.clickAutocloseableWarning();
        hp.clickAutocloseableDanger();
        hp.clickAutocloseableInfo();

        Assertions.assertTrue(hp.isDisplayedAutocloseableSuccess());
        Assertions.assertTrue(hp.isDisplayedAutocloseableWarning());
        Assertions.assertTrue(hp.isDisplayedAutocloseableDanger());
        Assertions.assertTrue(hp.isDisplayedAutocloseableInfo());

        hp.waitToElementDisappear(hp.autocloseableSuccessDiv);
        hp.waitToElementDisappear(hp.autocloseableWarningDiv);
        hp.waitToElementDisappear(hp.autocloseableDangerDiv);
        hp.waitToElementDisappear(hp.autocloseableInfoDiv);

        Assertions.assertFalse(hp.isDisplayedAutocloseableSuccess());
        Assertions.assertFalse(hp.isDisplayedAutocloseableWarning());
        Assertions.assertFalse(hp.isDisplayedAutocloseableDanger());
        Assertions.assertFalse(hp.isDisplayedAutocloseableInfo());
    }

    @Test
    public void allNormalAlerts() {
        hp.clickNormalSuccess();
        hp.clickNormalWarning();
        hp.clickNormalDanger();
        hp.clickNormalInfo();

        Assertions.assertTrue(hp.isDisplayedNormalSuccess());
        Assertions.assertTrue(hp.isDisplayedNormalWarning());
        Assertions.assertTrue(hp.isDisplayedNormalDanger());
        Assertions.assertTrue(hp.isDisplayedNormalInfo());

        hp.closeNormalSuccess();
        hp.closeNormalWarning();
        hp.closeNormalDanger();
        hp.closeNormalInfo();

        Assertions.assertFalse(hp.isDisplayedNormalSuccess());
        Assertions.assertFalse(hp.isDisplayedNormalWarning());
        Assertions.assertFalse(hp.isDisplayedNormalDanger());
        Assertions.assertFalse(hp.isDisplayedNormalInfo());
    }

    @AfterAll
    static void cleanUp() {
        browser.manage().deleteAllCookies();
        browser.close();
    }
}
