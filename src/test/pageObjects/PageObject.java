import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {
    protected WebDriver browser;

    public PageObject(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
        DriverPropertiesSetter.setProperties();
    }
}
