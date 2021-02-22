import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleFormSteps extends Steps {
    private static WebDriver browser;
    private static SimpleFormHomePage hp;

    @BeforeStories
    public void openBrowser() {
        browser = new ChromeDriver();
    }

    @Given("a $subpage of \"https://www.seleniumeasy.com/test/\"")
    public void goToSubpage(String subpage) {
        browser.get(PathBuilder.createPath(subpage));
        hp = new SimpleFormHomePage(browser);
    }

    @When("modal is displayed")
    public void isModalWindowDisplayed() {
        Assertions.assertTrue(hp.isModalDisplayed());
    }

    @Then("modal is going to be closed")
    public void closeModalWindow() {
        hp.closeModal();
    }

    @When("I pass String $text and click Show Message button")
    public void passTestAndClickButton(String text) {
        hp.insertTextIntoTextBox(text);
        hp.clickShowMessageButton();
    }

    @Then("$text is displayed")
    public void checkIfTextMatches(String text) {
        Assertions.assertEquals(text, hp.getTextFromYourMessage());
    }

    @When("I pass $firstNumber and $secondNumber and click Get Total button")
    public void addTwoNumbers(String firstNumber, String secondNumber) {
        hp.insertIntoInputA(firstNumber);
        hp.insertIntoInputB(secondNumber);
        hp.clickGetTotalButton();
    }

    @Then("$sum is displayed in result text area")
    public void checkIfSumMatches(String sum) {
        Assertions.assertEquals(sum, hp.totalABGetString());
    }

    @When("I click Get Total button with two empty input fields")
    public void clickGetTotalButtonWithEmptyInputs() {
        hp.clickGetTotalButton();
    }

    @AfterStories
    public void closeBrowser() {
        browser.close();
    }
}