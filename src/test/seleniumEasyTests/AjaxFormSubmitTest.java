import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AjaxFormSubmitTest {
    public static final String FORM_SUBMITED_SUCCESSFULLY = "Form submited Successfully!";
    private static WebDriver browser;
    private static AjaxFormSubmitHomePage hp;
    @BeforeAll
    static void init() {
        browser = new ChromeDriver();
        browser.get(PathBuilder.createPath("ajax-form-submit-demo.html"));
        hp = new AjaxFormSubmitHomePage(browser);
    }

    @Test
    public void insertDataTest() {
        hp.refresh();
        hp.enterName("Krystian");
        hp.enterComment("Lorem ipsum...");
        hp.submitForm();
        String returnedText = hp.waitForTheConfirmationAndReturnText();

        Assertions.assertEquals(FORM_SUBMITED_SUCCESSFULLY, returnedText);
    }

    @Test
    public void submitEmptyForm() {
        hp.refresh();
        hp.submitForm();

        Assertions.assertEquals("*", hp.getValidationErrorAsterisk());
    }

    @Test
    public void submitFormWithoutComment() {
        hp.refresh();
        hp.enterName("Krystian");
        hp.submitForm();
        String returnedText = hp.waitForTheConfirmationAndReturnText();

        Assertions.assertEquals(FORM_SUBMITED_SUCCESSFULLY, returnedText);
    }

    @AfterAll
    static void cleanUp() {
        browser.manage().deleteAllCookies();
        browser.close();
    }
}
