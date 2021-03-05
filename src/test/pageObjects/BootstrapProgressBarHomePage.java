import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BootstrapProgressBarHomePage extends PageObject {
    private static final int TIMEOUT_IN_SECONDS = 5;
    private final WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(TIMEOUT_IN_SECONDS));

    @FindBy(className = "btn-primary")
    WebElement simpleDialogButton;

    @FindBy(className = "btn-success")
    WebElement dialogCustomMessageButton;

    @FindBy(className = "btn-warning")
    WebElement dialogCustomSettingsButton;

    @FindBy(className = "modal-header")
    WebElement progressBar;

    public void clickSimpleDialogButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.className("btn-primary")));
        simpleDialogButton.click();
    }

    public void clickDialogCustomMessageButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.className("btn-success")));
        dialogCustomMessageButton.click();
    }

    public void clickDialogCustomSettingsButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.className("btn-warning")));
        dialogCustomSettingsButton.click();
    }

    public boolean waitForSimpleProgressBarAndCheckIfDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-header")));
        return progressBar.isDisplayed() && progressBar.getText().equals("Loading");
    }

    public boolean waitForSimpleProgressBarDisappearAndCheckIfDisplayed() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("modal-header")));
        return progressBar.isDisplayed();
    }

    public boolean waitForCustomProgressBarAndCheckIfDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-header")));
        return progressBar.isDisplayed() && progressBar.getText().equals("Custom message");
    }

    public boolean waitForCustomProgressBarDisappearAndCheckIfDisplayed() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("modal-header")));
        return progressBar.isDisplayed();
    }

    public boolean waitForCustomSettingsProgressBarAndCheckIfDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-header")));
        return progressBar.isDisplayed() && progressBar.getText().equals("Hello Mr. Alert !");
    }

    public boolean waitForCustomSettingsProgressBarDisappearAndCheckIfDisplayed() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("modal-header")));
        return progressBar.isDisplayed();
    }

    public BootstrapProgressBarHomePage(WebDriver browser) {
        super(browser);
    }
}
