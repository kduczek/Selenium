import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AjaxFormSubmitHomePage extends PageObject {
    private static final int TIMEOUT_IN_SECONDS = 5;
    public static final String FORM_SUBMITED_SUCCESSFULLY = "Form submited Successfully!";

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
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(TIMEOUT_IN_SECONDS));
        wait.until(ExpectedConditions.textToBePresentInElement(submitInfo, FORM_SUBMITED_SUCCESSFULLY));

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
