package Utils;

import Base.PageTestBase;
import pageobjects.PageObjectManager;
import org.openqa.selenium.WebDriver;

public class TestContextDI {
    public WebDriver driver;
    public PageTestBase pageTestBase;
    public PageObjectManager pageObjectManager;

    public TestContextDI() {
        pageTestBase = new PageTestBase();
        driver = pageTestBase.WebDriverManager();
        pageObjectManager = new PageObjectManager(driver);
    }
}
