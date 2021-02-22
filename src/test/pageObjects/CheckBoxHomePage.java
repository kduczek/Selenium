import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckBoxHomePage extends PageObject {
    @FindBy(id = "isAgeSelected")
    WebElement singleCheckBox;

    @FindBy(id = "txtAge")
    WebElement singleCheckTextArea;

    @FindBy(xpath = "//input[@type='checkbox']")
    List<WebElement> listOfCheckboxes;

    @FindBy(id = "check1")
    WebElement buttonCheck;


    public void singleCheckBoxClick() {
        singleCheckBox.click();
    }

    public void resetSingleCheckBox() {
        if (singleCheckBox.isSelected()) {
            singleCheckBox.click();
        }
    }

    public String getTextFromSingleCheckTextArea() {
        return singleCheckTextArea.getText();
    }

    public void resetCheckboxes() {
        if (buttonCheck.getAttribute("value").equals("Uncheck All")) {
            buttonCheck.click();
        }
    }

    public void clickCheckButton() {
        buttonCheck.click();
    }

    public void clickAllCheckboxes() {
        for (WebElement el : listOfCheckboxes) {
            el.click();
        }
    }

    public boolean checkIsEveryCheckboxClicked() {
        for (WebElement el : listOfCheckboxes) {
            if (!el.isEnabled()) {
                return false;
            }
        }
        return true;
    }

    public CheckBoxHomePage(WebDriver browser) {
        super(browser);
    }
}
