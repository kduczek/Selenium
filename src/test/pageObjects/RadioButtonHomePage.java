import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RadioButtonHomePage extends PageObject {
    @FindBy(xpath = "//input[@value='Male']")
    WebElement radioMale;

    @FindBy(xpath = "//input[@value='Female']")
    WebElement radioFemale;

    @FindBy(id = "buttoncheck")
    WebElement buttonCheck;

    @FindBy(className = "radiobutton")
    WebElement radioButtonResultText;

    @FindBy(xpath = "//input[@name='gender'][@value='Female']")
    WebElement radioGroupFemale;

    @FindBy(xpath = "//input[@name='gender'][@value='Male']")
    WebElement radioGroupMale;

    @FindBy(xpath = "//input[@value='0 - 5']")
    WebElement radio0to5;

    @FindBy(xpath = "//input[@value='5 - 15']")
    WebElement radio5to15;

    @FindBy(xpath = "//input[@value='15 - 50']")
    WebElement radio15to50;

    @FindBy(xpath = "//button[contains(text(),'Get values')]")
    WebElement getValuesButton;

    @FindBy(className = "groupradiobutton")
    WebElement groupResultText;

    public void radioMaleClick() {
        radioMale.click();
    }

    public void radioFemaleClick() {
        radioFemale.click();
    }

    public String resultText() {
        return radioButtonResultText.getText();
    }

    public void clickButtonCheck() {
        buttonCheck.click();
    }

    public void radioGroupMaleClick() {
        radioGroupMale.click();
    }

    public void radioGroupFemaleClick() {
        radioGroupFemale.click();
    }

    public void radio0to5Click() {
        radio0to5.click();
    }

    public void radio5to15Click() {
        radio5to15.click();
    }

    public void radio15to50Click() {
        radio15to50.click();
    }

    public void getValuesButtonClick() {
        getValuesButton.click();
    }

    public String getGroupRadioResultText() {
        return groupResultText.getText();
    }

    public RadioButtonHomePage(WebDriver browser) {
        super(browser);
    }
}
