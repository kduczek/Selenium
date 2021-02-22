import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleFormTest {
    private static WebDriver browser;
    private static SimpleFormHomePage hp;
    @BeforeAll
    static void init() {
        browser = new ChromeDriver();
        browser.get(PathBuilder.createPath("basic-first-form-demo.html"));
        hp = new SimpleFormHomePage(browser);
        hp.closeModal();
    }

    @Test
    public void singleInputTest() {
        hp.insertTextIntoTextBox("My name is Krystian");
        hp.clickShowMessageButton();

        Assertions.assertTrue(hp.yourMessage.isDisplayed());
        Assertions.assertEquals("My name is Krystian", hp.getTextFromYourMessage());
    }

    @Test
    public void singleInputTestSpecialCharacters() {
        hp.insertTextIntoTextBox("!@#$%^&*");
        hp.clickShowMessageButton();

        Assertions.assertTrue(hp.yourMessage.isDisplayed());
        Assertions.assertEquals("!@#$%^&*", hp.getTextFromYourMessage());
    }

    @Test
    public void twoInputFields() {
        hp.insertIntoInputA("3");
        hp.insertIntoInputB("5");
        hp.clickGetTotalButton();

        Assertions.assertEquals(8, hp.totalABGetInteger());
    }

    @Test
    public void twoInputFieldsWithNegative() {
        hp.insertIntoInputA("3");
        hp.insertIntoInputB("-25");
        hp.clickGetTotalButton();

        Assertions.assertEquals(-22, hp.totalABGetInteger());
    }

    @Test
    public void twoInputFieldsIntAndString() {
        hp.insertIntoInputA("17");
        hp.insertIntoInputB("Test");
        hp.clickGetTotalButton();

        Assertions.assertEquals("NaN", hp.totalABGetString());
    }

    @Test
    public void twoInputFieldsTwoStrings() {
        hp.insertIntoInputA("Selenium");
        hp.insertIntoInputB("Test");
        hp.clickGetTotalButton();

        Assertions.assertEquals("NaN", hp.totalABGetString());
    }

    @Test
    public void twoInputFieldsIntAndSpecialChar() {
        hp.insertIntoInputA("17");
        hp.insertIntoInputB("&");
        hp.clickGetTotalButton();

        Assertions.assertEquals("NaN", hp.totalABGetString());
    }

    @Test
    public void twoInputFieldsDoubleZero() {
        hp.insertIntoInputA("0");
        hp.insertIntoInputB("0");
        hp.clickGetTotalButton();

        Assertions.assertEquals(0, hp.totalABGetInteger());
    }

    @AfterAll
    static void cleanUp() {
        browser.manage().deleteAllCookies();
        browser.close();
    }
}
