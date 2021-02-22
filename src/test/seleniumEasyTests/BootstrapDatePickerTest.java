import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BootstrapDatePickerTest {
    private static WebDriver browser;
    private static BootstrapDatePickerHomePage hp;
    @BeforeAll
    static void init() {
        browser = new ChromeDriver();
        browser.get(PathBuilder.createPath("bootstrap-date-picker-demo.html"));
        hp = new BootstrapDatePickerHomePage(browser);
    }

    @Test
    public void todaysButtonTest() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        hp.openCalendarWindow();
        hp.clickTodaysDate();
        Assertions.assertEquals(LocalDate.now().format(formatter), hp.getPickedDate());
    }

    @Test
    public void clearButtonTest() {
        hp.openCalendarWindow();
        hp.clickTodaysDate();
        hp.openCalendarWindow();
        hp.clearButtonClick();

        Assertions.assertEquals("", hp.getPickedDate());
    }

    @Test
    public void disabledSundayButtonsTest() {
        hp.openCalendarWindow();

        Assertions.assertFalse(hp.checkIfButtonIsEnabled());
    }

    @Test
    public void dateRangeExampleTest() {
        hp.pickStartDate();
        hp.pickEndDate();

        Assertions.assertEquals(hp.pickStartDate(), hp.getStartDate());
        Assertions.assertEquals(hp.pickEndDate(), hp.getEndDate());
        Assertions.assertTrue(hp.pickStartDate().compareTo(hp.pickEndDate()) <= 0);
    }

    @AfterAll
    static void cleanUp() {
        browser.manage().deleteAllCookies();
        browser.close();
    }

}
