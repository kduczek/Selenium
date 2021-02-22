import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SimpleFormHomePage extends PageObject {
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
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
