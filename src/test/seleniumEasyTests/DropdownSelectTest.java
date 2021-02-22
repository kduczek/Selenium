import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropdownSelectTest {
    private static WebDriver browser;
    private static DropdownSelectHomePage hp;
    @BeforeAll
    static void init() {
        browser = new ChromeDriver();
        browser.get(PathBuilder.createPath("basic-select-dropdown-demo.html"));
        hp = new DropdownSelectHomePage(browser);
    }

    @Test
    public void selectListMonday() {
        hp.selectDay("Monday");

        Assertions.assertEquals("Day selected :- Monday", hp.getSelectedDay());
    }

    @Test
    public void selectListSunday() {
        hp.selectDay("Sunday");

        Assertions.assertEquals("Day selected :- Sunday", hp.getSelectedDay());
    }

    @Test
    public void selectMultipleTimes() {
        hp.selectDay("Monday");
        hp.selectDay("Tuesday");
        hp.selectDay("Monday");

        Assertions.assertEquals("Day selected :- Monday", hp.getSelectedDay());
    }

    @Test
    public void multipleFirstSelectedWithoutValue() {
        hp.refresh();
        hp.firstSelectedButtonCLick();

        Assertions.assertEquals("First selected option is : undefined", hp.getSelectedCities());
    }

    @Test
    public void multipleAllSelectedWithoutValue() {
        hp.refresh();
        hp.getAllSelectedButtonClick();

        Assertions.assertEquals("Options selected are :", hp.getSelectedCities());
    }

    @Test
    public void multipleAllSelected1City() {
        hp.refresh();
        hp.selectMultiple("Texas");
        hp.getAllSelectedButtonClick();

        Assertions.assertEquals("Options selected are : Texas", hp.getSelectedCities());
    }

    @Test
    public void multiSelectFirstSelectedTest() {
        hp.refresh();
        hp.selectMultiple("Florida");
        hp.firstSelectedButtonCLick();

        Assertions.assertEquals("First selected option is : Florida", hp.getSelectedCities());
    }

    @Test
    public void multipleSelectByIndex0() {
        hp.refresh();
        hp.selectByIndex(0);
        hp.firstSelectedButtonCLick();

        Assertions.assertEquals("First selected option is : California", hp.getSelectedCities());
    }

    @Test
    public void multiListIsMultiple() {
        Assertions.assertTrue(hp.isListMultipleChoice());
    }

    @AfterAll
    static void closeBrowser() {
        browser.manage().deleteAllCookies();
        browser.close();
    }

}
