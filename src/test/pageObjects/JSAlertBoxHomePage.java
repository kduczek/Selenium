import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JSAlertBoxHomePage extends PageObject {
    @FindBy(xpath = "//button[contains(text(),'Click me!')][@class='btn btn-default btn-lg']")
    WebElement confirmBoxButton;

    @FindBy(xpath = "//button[contains(text(),'Click me!')][@class='btn btn-default']")
    WebElement alertBoxButton;

    @FindBy(xpath = "//button[contains(text(),'Click for Prompt Box')]")
    WebElement alertPromptBox;

    @FindBy(id = "confirm-demo")
    WebElement confirmBoxResult;

    @FindBy(id = "prompt-demo")
    WebElement promptResult;

    public void alertBoxButtonClick() {
        alertBoxButton.click();
    }

    public void acceptAlert() {
        browser.switchTo().alert().accept();
    }

    public void dismissAlert() {
        browser.switchTo().alert().dismiss();
    }

    public String getAlertText() {
        return browser.switchTo().alert().getText();
    }

    public void confirmBoxButtonClick() {
        confirmBoxButton.click();
    }

    public String getConfirmBoxResultText() {
        return confirmBoxResult.getText();
    }

    public void alertPromptBoxClick() {
        alertPromptBox.click();
    }

    public String promptResultText() {
        return promptResult.getText();
    }

    public void sendKeysToAlertBox(String key) {
        browser.switchTo().alert().sendKeys(key);
    }

    public void refresh() {
        browser.navigate().refresh();
    }

    public boolean promptResultIsDisplayed() {
        return promptResult.isDisplayed();
    }

    public JSAlertBoxHomePage(WebDriver browser) {
        super(browser);
    }
}
