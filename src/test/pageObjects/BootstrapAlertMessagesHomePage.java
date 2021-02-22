import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BootstrapAlertMessagesHomePage extends PageObject {
    //GREEN
    @FindBy(id = "autoclosable-btn-success")
    WebElement autocloseableSuccess;

    @FindBy(className = "alert-autocloseable-success")
    WebElement autocloseableSuccessDiv;

    @FindBy(id = "normal-btn-success")
    WebElement normalButtonSuccess;

    @FindBy(className = "alert-normal-success")
    WebElement normalSuccessDiv;

    WebElement normalSuccessClose;

    public void clickAutocloseableSuccess() {
        autocloseableSuccess.click();
    }

    public boolean isDisplayedAutocloseableSuccess() {
        return autocloseableSuccessDiv.isDisplayed();
    }

    public void clickNormalSuccess() {
        normalButtonSuccess.click();
    }

    public boolean isDisplayedNormalSuccess() {
        return normalSuccessDiv.isDisplayed();
    }


    public void closeNormalSuccess() {
        normalSuccessClose = normalSuccessDiv.findElement(By.xpath(".//button[contains(text(), '×')]"));
        normalSuccessClose.click();

    }

    //YELLOW
    @FindBy(id = "autoclosable-btn-warning")
    WebElement autocloseableWarningButton;

    @FindBy(id = "normal-btn-warning")
    WebElement normalWarningButton;

    @FindBy(className = "alert-normal-warning")
    WebElement normalWarningDiv;

    WebElement normalWarningClose;

    @FindBy(className = "alert-autocloseable-warning")
    WebElement autocloseableWarningDiv;

    public void clickNormalWarning() {
        normalWarningButton.click();
    }

    public void closeNormalWarning() {
        normalWarningClose = normalWarningDiv.findElement(By.xpath(".//button[contains(text(), '×')]"));
        normalWarningClose.click();
    }

    public boolean isDisplayedNormalWarning() {
        return normalWarningDiv.isDisplayed();
    }

    public void clickAutocloseableWarning() {
        autocloseableWarningButton.click();
    }

    public boolean isDisplayedAutocloseableWarning() {
        return autocloseableWarningDiv.isDisplayed();
    }

    //RED
    @FindBy(id = "autoclosable-btn-danger")
    WebElement autocloseableDangerButton;

    @FindBy(id = "normal-btn-danger")
    WebElement normalDangerButton;

    @FindBy(className = "alert-normal-danger")
    WebElement normalDangerDiv;

    @FindBy(className = "alert-autocloseable-danger")
    WebElement autocloseableDangerDiv;

    WebElement normalDangerClose;

    public void clickNormalDanger() {
        normalDangerButton.click();
    }

    public void closeNormalDanger() {
        normalDangerClose = normalDangerDiv.findElement(By.xpath(".//button[contains(text(), '×')]"));
        normalDangerClose.click();
    }

    public boolean isDisplayedNormalDanger() {
        return normalDangerDiv.isDisplayed();
    }

    public void clickAutocloseableDanger() {
        autocloseableDangerButton.click();
    }

    public boolean isDisplayedAutocloseableDanger() {
        return autocloseableDangerDiv.isDisplayed();
    }

    //BLUE
    @FindBy(id = "autoclosable-btn-info")
    WebElement autocloseableInfoButton;

    @FindBy(id = "normal-btn-info")
    WebElement normalInfoButton;

    @FindBy(className = "alert-normal-info")
    WebElement normalInfoDiv;

    @FindBy(className = "alert-autocloseable-info")
    WebElement autocloseableInfoDiv;

    WebElement normalInfoClose;

    public void clickNormalInfo() {
        normalInfoButton.click();
    }

    public void closeNormalInfo() {
        normalInfoClose = normalInfoDiv.findElement(By.xpath(".//button[contains(text(), '×')]"));
        normalInfoClose.click();
    }

    public boolean isDisplayedNormalInfo() {
        return normalInfoDiv.isDisplayed();
    }

    public void clickAutocloseableInfo() {
        autocloseableInfoButton.click();
    }

    public boolean isDisplayedAutocloseableInfo() {
        return autocloseableInfoDiv.isDisplayed();
    }

    public void waitSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public BootstrapAlertMessagesHomePage(WebDriver browser) {
        super(browser);
    }
}
