import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxTest {
    private static WebDriver browser;
    private static CheckBoxHomePage hp;
    @BeforeAll
    static void init() {
        browser = new ChromeDriver();
        browser.get(PathBuilder.createPath("basic-checkbox-demo.html"));
        hp = new CheckBoxHomePage(browser);
    }

    @Test
    public void singleCheckBox(){
        hp.resetSingleCheckBox();
        hp.singleCheckBoxClick();

        Assertions.assertTrue(hp.singleCheckBox.isSelected());
    }

    @Test
    public void singleCheckBoxWithResult() {
        hp.resetSingleCheckBox();
        hp.singleCheckBoxClick();

        Assertions.assertTrue(hp.singleCheckBox.isSelected());
        Assertions.assertEquals("Success - Check box is checked", hp.getTextFromSingleCheckTextArea());
    }


    @Test
    public void checkAllTest() {
        hp.resetCheckboxes();
        hp.clickAllCheckboxes();

        Assertions.assertTrue(hp.checkIsEveryCheckboxClicked());
    }

    @Test
    public void clickButton() {
        hp.resetCheckboxes();

        Assertions.assertEquals("Check All", hp.buttonCheck.getAttribute("value"));

        hp.clickCheckButton();

        Assertions.assertEquals("Uncheck All", hp.buttonCheck.getAttribute("value"));
    }

    @Test
    public void clickButtonThenUncheckAll() {
        hp.resetCheckboxes();
        hp.clickCheckButton();
        hp.clickAllCheckboxes();

        Assertions.assertTrue(hp.checkIsEveryCheckboxClicked());
        Assertions.assertEquals("Check All", hp.buttonCheck.getAttribute("value"));
    }

    @Test
    public void clickAllCheckboxes() {
        hp.resetCheckboxes();
        hp.clickAllCheckboxes();

        Assertions.assertTrue(hp.checkIsEveryCheckboxClicked());
    }

    @AfterAll
    static void closeBrowser() {
        browser.manage().deleteAllCookies();
        browser.close();
    }
}
