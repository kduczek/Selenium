import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class BootstrapDatePickerHomePage extends PageObject {
    private static final String LEADING_ZERO = "0";

    @FindBy(className = "input-group-addon")
    WebElement openCalendar;

    @FindBy(xpath = "//th[@class='today'][@colspan='7']")
    WebElement todayButton;

    @FindBy(xpath = "//th[@class='clear'][@colspan='7']")
    WebElement clearButton;

    @FindBy(xpath = "//input[@class='form-control'][@placeholder='dd/mm/yyyy']")
    WebElement date;

    @FindBy(xpath = "//input[@class='form-control'][@placeholder='Start date']")
    WebElement startDate;

    @FindBy(xpath = "//input[@class='form-control'][@placeholder='End date']")
    WebElement endDate;

    public void openCalendarWindow() {
        openCalendar.click();
    }

    public void clickTodaysDate() {
        todayButton.click();
    }

    public void clearButtonClick() {
        clearButton.click();
    }

    public String getPickedDate() {
        return date.getAttribute("value");
    }

    public String pickStartDate() {
        String date = checkIfDayIsNotASunday(false);
        String day = date.substring(0, 2);
        day = checkIfDayHasLeadingZero(day);

        startDate.click();

        WebElement dayInCalendar = browser.findElement(By.xpath("//td[contains(text(),'" + day + "')]"));
        dayInCalendar.click();

        return date;
    }

    public String getStartDate() {
        return startDate.getAttribute("value");
    }

    public String pickEndDate() {
        String date = checkIfDayIsNotASunday(true);
        String day = date.substring(0, 2);
        day = checkIfDayHasLeadingZero(day);

        endDate.click();

        WebElement dayInCalendar = browser.findElement(By.xpath("//td[contains(text(),'" + day + "')]"));
        dayInCalendar.click();

        return date;
    }

    public String getEndDate() {
        return endDate.getAttribute("value");
    }

    private String checkIfDayIsNotASunday(Boolean isEndDate) {
        DateTimeFormatter formatter;
        int dayOfMonth = LocalDate.now().getDayOfMonth();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        int numOfDays = 1;
        formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        if (isEndDate) {
            //Sunday is not permitted to be picked
            //If day is a Sunday, we take next day to tests
            if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                return LocalDate.now().plusDays(numOfDays + 4).format(formatter);
            } else {
                return LocalDate.now().plusDays(numOfDays + 3).format(formatter);
            }
        } else {
            if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                return LocalDate.now().plusDays(numOfDays).format(formatter);
            } else {
                return LocalDate.now().format(formatter);
            }
        }

    }

    private String checkIfDayHasLeadingZero(String day) {
        if (day.startsWith(LEADING_ZERO)) {
            StringBuilder newDay = new StringBuilder(day);
            newDay.deleteCharAt(0);
            return newDay.toString();
        }

        return day;
    }

    public boolean checkIfButtonIsEnabled() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        WebElement dayInCalendar = browser.findElement(By.xpath("//td[contains(text(),'" + cal.get(Calendar.DAY_OF_WEEK) + "')]"));

        return !dayInCalendar.isEnabled();
    }


    public BootstrapDatePickerHomePage(WebDriver browser) {
        super(browser);
    }
}
