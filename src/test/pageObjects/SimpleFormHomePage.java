import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SimpleFormHomePage extends PageObject {
    private static final int TIMEOUT_IN_SECONDS = 5;

    @FindBy(id = "at-cv-lightbox-close")
    WebElement closeModal;

    @FindBy(id = "user-message")
    WebElement textBox;

    @FindBy(xpath = "//button[contains(text(), 'Show Message')]")
    WebElement showMessageButton;

    @FindBy(id = "display")
    WebElement yourMessage;

    @FindBy(id = "sum1")
    WebElement inputA;

    @FindBy(id = "sum2")
    WebElement inputB;

    @FindBy(id = "displayvalue")
    WebElement getTotal;

    @FindBy(xpath = "//button[contains(text(), 'Get Total')]")
    WebElement totalABButton;


    public void closeModal() {
        if(isModalDisplayed()) {
            closeModal.click();
        }
    }

    public boolean isModalDisplayed() {
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(TIMEOUT_IN_SECONDS));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("at-cv-lightbox-close")));
        return closeModal.isDisplayed();
    }

    public void insertTextIntoTextBox(String message) {
        textBox.clear();
        textBox.sendKeys(message);
    }

    public void clickShowMessageButton() {
        showMessageButton.click();
    }

    public String getTextFromYourMessage() {
        return yourMessage.getText();
    }

    public void insertIntoInputA(String key) {
        inputA.clear();
        inputA.sendKeys(key);
    }

    public void insertIntoInputB(String key) {
        inputB.clear();
        inputB.sendKeys(key);
    }

    public void clickGetTotalButton() {
        totalABButton.click();
    }

    public int totalABGetInteger() {
        return Integer.parseInt(getTotal.getText());
    }

    public String totalABGetString() {
        return getTotal.getText();
    }

    public SimpleFormHomePage(WebDriver browser) {
        super(browser);
    }

}
