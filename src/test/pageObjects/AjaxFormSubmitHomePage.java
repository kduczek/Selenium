import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AjaxFormSubmitHomePage extends PageObject {
    @FindBy(name = "title")
    WebElement name;

    @FindBy(xpath = "//textarea[@id='description']")
    WebElement comment;

    @FindBy(name = "btn-submit")
    WebElement submitButton;

    @FindBy(id = "submit-control")
    WebElement submitInfo;

    @FindBy(xpath = "//span[contains(text(),'*')]")
    WebElement nameValidationError;


    public void enterName(String name) {
        this.name.clear();
        this.name.sendKeys(name);
    }

    public void enterComment(String comment) {
        this.comment.clear();
        this.comment.sendKeys(comment);
    }

    public void submitForm() {
        submitButton.click();
    }

    public String waitForTheConfirmationAndReturnText() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return submitInfo.getText();
    }

    public String getValidationErrorAsterisk() {
        return nameValidationError.getText();
    }

    public void refresh() {
        browser.navigate().refresh();
    }


    public AjaxFormSubmitHomePage(WebDriver browser) {
        super(browser);
    }
}
