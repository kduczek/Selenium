import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BootstrapProgressBarHomePage extends PageObject {
    @FindBy(className = "btn-primary")
    WebElement simpleDialogButton;

    @FindBy(className = "btn-success")
    WebElement dialogCustomMessageButton;

    @FindBy(className = "btn-warning")
    WebElement dialogCustomSettingsButton;

    @FindBy(className = "modal-header")
    WebElement progressBar;

    public void clickSimpleDialogButton() {
        simpleDialogButton.click();
    }

    public void clickDialogCustomMessageButton() {
        dialogCustomMessageButton.click();
    }

    public void clickDialogCustomSettingsButton() {
        dialogCustomSettingsButton.click();
    }

    public boolean isDisplayedSimpleProgressBar() {
        return progressBar.isDisplayed() && progressBar.getText().equals("Loading");
    }

    public boolean isDisplayedCustomMessageProgressBar() {
        return progressBar.isDisplayed() && progressBar.getText().equals("Custom message");
    }

    public boolean isDisplayedCustomSettingsProgressBar() {
        return progressBar.isDisplayed() && progressBar.getText().equals("Hello Mr. Alert !");
    }

    public void waitInSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public BootstrapProgressBarHomePage(WebDriver browser) {
        super(browser);
    }
}
