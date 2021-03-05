import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootstrapDownloadTest {
    private static WebDriver browser;
    private static BootstrapDownloadHomePage hp;
    @BeforeAll
    static void init() {
        browser = new ChromeDriver();
        browser.get(PathBuilder.createPath("bootstrap-download-progress-demo.html"));
        hp = new BootstrapDownloadHomePage(browser);
    }

    @Test
    public void downloadIn30SecTest() {
        hp.clickDownloadButton();
        hp.waitUntil100Percent();

        Assertions.assertTrue(hp.isDownloadSuccessful());
    }

    @AfterAll
    static void closeBrowser() {
        browser.manage().deleteAllCookies();
        browser.close();
    }
}
