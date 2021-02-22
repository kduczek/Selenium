import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RadioButtonTest {
    private static WebDriver browser;
    private static RadioButtonHomePage hp;
    @BeforeAll
    static void init() {
        browser = new ChromeDriver();
        browser.get(PathBuilder.createPath("basic-radiobutton-demo.html"));
        hp = new RadioButtonHomePage(browser);
    }

    @Test
    @Order(1)
    public void noRadioCheck() {
        hp.clickButtonCheck();

        Assertions.assertEquals("Radio button is Not checked", hp.resultText());
    }

    @Test
    public void maleRadioCheck() {
        hp.radioMaleClick();
        hp.clickButtonCheck();

        Assertions.assertEquals("Radio button 'Male' is checked", hp.resultText());
    }

    @Test
    public void femaleRadioCheck() {
        hp.radioFemaleClick();
        hp.clickButtonCheck();

        Assertions.assertEquals("Radio button 'Female' is checked", hp.resultText());
    }

    @Test
    @Order(2)
    public void groupNoRadioCheck() {
        hp.getValuesButtonClick();

        Assertions.assertEquals("Sex :\nAge group:", hp.getGroupRadioResultText());
    }

    @Test
    @Order(3)
    public void groupOnlySexChecked() {
        hp.radioGroupMaleClick();
        hp.getValuesButtonClick();

        Assertions.assertEquals("Sex : Male\nAge group:", hp.getGroupRadioResultText());
    }

    @Test
    @Order(4)
    public void groupOnlyAgeChecked() {
        browser.navigate().refresh();
        hp.radio15to50Click();
        hp.getValuesButtonClick();

        Assertions.assertEquals("Sex :\nAge group: 15 - 50", hp.getGroupRadioResultText());
    }

    @Test
    public void groupMale0to5Test() {
        hp.radioGroupMaleClick();
        hp.radio0to5Click();
        hp.getValuesButtonClick();

        Assertions.assertEquals("Sex : Male\nAge group: 0 - 5", hp.getGroupRadioResultText());
    }

    @Test
    public void groupMale5to15Test() {
        hp.radioGroupMaleClick();
        hp.radio5to15Click();
        hp.getValuesButtonClick();

        Assertions.assertEquals("Sex : Male\nAge group: 5 - 15", hp.getGroupRadioResultText());
    }

    @Test
    public void groupFemale15to50Test() {
        hp.radioGroupFemaleClick();
        hp.radio15to50Click();
        hp.getValuesButtonClick();

        Assertions.assertEquals("Sex : Female\nAge group: 15 - 50", hp.getGroupRadioResultText());
    }


    @Test
    public void checkTwoRadioButtonsWithValues() {
        hp.radioFemaleClick();
        hp.radio15to50Click();
        hp.getValuesButtonClick();

        Assertions.assertEquals("Sex : Female\nAge group: 15 - 50", hp.getGroupRadioResultText());

    }

    @AfterAll
    static void closeBrowser() {
        browser.manage().deleteAllCookies();
        browser.close();
    }
}
