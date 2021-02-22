import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DropdownSelectHomePage extends PageObject {
    @FindBy(id = "select-demo")
    Select dayPicker;

    @FindBy(className = "selected-value")
    WebElement daySelected;

    @FindBy(id = "multi-select")
    Select multiSelectList;

    @FindBy(id = "printMe")
    WebElement firstSelectedButton;

    @FindBy(id = "printAll")
    WebElement getAllSelectedButton;

    @FindBy(className = "getall-selected")
    WebElement selectedOptions;

    public void selectDay(String day) {
        dayPicker = new Select(browser.findElement(By.id("select-demo")));
        dayPicker.selectByVisibleText(day);
    }

    public void selectMultiple(String city) {
        multiSelectList = new Select(browser.findElement(By.id("multi-select")));
        multiSelectList.selectByVisibleText(city);
    }

    public String getSelectedDay() {
        return daySelected.getText();
    }

    public void firstSelectedButtonCLick() {
        firstSelectedButton.click();
    }

    public void getAllSelectedButtonClick() {
        getAllSelectedButton.click();
    }

    public String getSelectedCities() {
        return selectedOptions.getText();
    }

    public boolean isListMultipleChoice() {
        multiSelectList = new Select(browser.findElement(By.id("multi-select")));
        return multiSelectList.isMultiple();
    }

    public void selectByIndex(int index) {
        multiSelectList = new Select(browser.findElement(By.id("multi-select")));
        multiSelectList.selectByIndex(index);
    }

    public void refresh() {
        browser.navigate().refresh();
    }


    public DropdownSelectHomePage(WebDriver browser) {
        super(browser);
    }
}
