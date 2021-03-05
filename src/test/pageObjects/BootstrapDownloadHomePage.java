import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BootstrapDownloadHomePage extends PageObject{
    private static final int TIMEOUT_IN_SECONDS = 30;
    WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(TIMEOUT_IN_SECONDS));

    @FindBy(id = "cricle-btn")
    WebElement downloadButton;

    @FindBy(className = "percenttext")
    WebElement downloadPercent;

    public void clickDownloadButton() {
        downloadButton.click();
    }

    public void waitUntil100Percent() {
        wait.until(ExpectedConditions.textToBePresentInElement(downloadPercent, "100%"));
    }

    public boolean isDownloadSuccessful() {
        return downloadPercent.getText().equals("100%");
    }

    public BootstrapDownloadHomePage(WebDriver browser) {
        super(browser);
    }
}
