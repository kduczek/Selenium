import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class InputFormValidationsHomePage extends PageObject {
    @FindBy(name = "first_name")
    WebElement firstName;

    @FindBy(name = "last_name")
    WebElement lastName;

    @FindBy(name = "email")
    WebElement email;

    @FindBy(name = "phone")
    WebElement phone;

    @FindBy(name = "address")
    WebElement address;

    @FindBy(name = "city")
    WebElement city;

    @FindBy(name = "state")
    Select state;

    @FindBy(name = "zip")
    WebElement zip;

    @FindBy(name = "website")
    WebElement website;

    @FindBy(name = "hosting")
    WebElement hosting;

    @FindBy(name = "comment")
    WebElement comment;

    @FindBy(xpath = "//*[text()='Send ']")
    WebElement sendForm;


    public void enterName(String firstName, String lastName) {
        this.firstName.clear();
        this.firstName.sendKeys(firstName);

        this.lastName.clear();
        this.lastName.sendKeys(lastName);
    }

    public void enterPhoneAndEmail(String phone, String email) {
        this.phone.clear();
        this.phone.sendKeys(phone);

        this.email.clear();
        this.email.sendKeys(email);
    }

    public void enterAddress(String address, String city, String state, String zip) {
        this.address.clear();
        this.address.sendKeys(address);

        this.city.clear();
        this.city.sendKeys(city);

        this.state = new Select(browser.findElement(By.name("state")));
        this.state.selectByVisibleText(state);

        this.zip.clear();
        this.zip.sendKeys(zip);
    }

    public void enterAdditionalInfo(String website, String hosting, String comment) {
        this.website.clear();
        this.website.sendKeys(website);

        if (hosting.equals("yes")) {
            this.hosting.findElement(By.xpath("//input[@value='yes']")).click();
        } else {
            this.hosting.findElement(By.xpath("//input[@value='no']")).click();
        }

        this.comment.clear();
        this.comment.sendKeys(comment);
    }

    public void submit() {
        sendForm.click();
    }

    public InputFormValidationsHomePage(WebDriver browser) {
        super(browser);
    }
}
