import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InputFormValidationTest {

    private static WebDriver browser;
    private static InputFormValidationsHomePage hp;
    @BeforeAll
    static void init() {
        browser = new ChromeDriver();
        browser.get(PathBuilder.createPath("input-form-demo.html"));
        hp = new InputFormValidationsHomePage(browser);
    }

    @Test
    public void insertDataTest() {
        hp.enterName("Krystian", "Duczek");
        hp.enterPhoneAndEmail("132564912", "duczek.krystian@gmail.com");
        hp.enterAddress("Wall Street 2142", "Washington", "Florida", "12-345");
        hp.enterAdditionalInfo("google.com", "yes", "Test");
        hp.submit();
    }

    @AfterAll
    static void cleanUp() {
        browser.manage().deleteAllCookies();
        browser.close();
    }
}
