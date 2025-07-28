package pageobjects;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Logger;

public class ProductSelectorPage {
    WebDriver driver;
    WebDriverWait wait;
   // private static final Logger logger = Logger.getLogger(ProductSelectorPage.class.getName());

    public ProductSelectorPage(WebDriver driver) {
        this.driver = driver;
        this.wait= new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    By AcceptCookies = By.id("onetrust-accept-btn-handler");
    By HomePageLogo = By.xpath("(//a[@title=\"Header Logo\"])[1]");
    By whatToBuy = By.xpath("//span[normalize-space()='What to buy']");
    By findMotorOil= By.xpath("(//span[normalize-space()='Find the right motor oil & filter'])[2]");
    By ProductSelectorPageTitle = By.xpath("//h1[text()='Find the right oil and oil filter for your car ']");
    By year = By.id("select0");
    By make = By.id("select1");
    By model = By.id("select2");
    By engine = By.id("select3");
    By recommendationsBtn = By.cssSelector("div.button.wmi-button > button.btn.btn-primary");

    By pageHeading1 = By.cssSelector("h1.header-title");
    By PageHeading2 = By.cssSelector("h2.header-title-model");
    By EngineOilCapacity = By.cssSelector("span.capacity-color");
    By otherlubricants = By.id("otherOils");
    By Motoroil = By.cssSelector("a#engine");
    By producttitle = By.xpath("//h3[@class='result-list-title']");
    By productimage = By.xpath("(//img[@class='brand-image'])[1]");
    By viewproductBtn = By.cssSelector("button.btn.btn-primary.d-print-none.product-page-btn");
    By compareBtn = By.className("compare-button");
    By starRating = By.xpath("//span[@class='bv_stars_svg_no_wrap']");




    public boolean isHomePageDisplayed() {
        driver.findElement(AcceptCookies).click();

        return driver.findElement(HomePageLogo).isDisplayed();
    }

    public Boolean ToNavigateToProductSelector() {
        wait.until(ExpectedConditions.elementToBeClickable(whatToBuy)).click();

        wait.until(ExpectedConditions.elementToBeClickable(findMotorOil)).click();

        return driver.findElement(ProductSelectorPageTitle).isDisplayed();
    }


    public void selectYear(String value) {
        WebElement yeardropdown = wait.until(ExpectedConditions.elementToBeClickable(year));
        Select select = new Select(yeardropdown);
        select.selectByValue(value);

    }

    public void selectMake(String text) {
        WebElement makedropdown = wait.until(ExpectedConditions.elementToBeClickable(make));
        Select select = new Select(makedropdown);
        select.selectByVisibleText(text);
    }

    public void selectModel(String text) {
        WebElement modeldropdown = wait.until(ExpectedConditions.elementToBeClickable(model));
        Select select = new Select(modeldropdown);
        select.selectByVisibleText(text);
    }

    public void selectEngine(String text) {
        WebElement enginedropdown = wait.until(ExpectedConditions.elementToBeClickable(engine));
        Select select = new Select(enginedropdown);
        select.selectByVisibleText(text);
    }

    public void ViewRecommendations(){
        wait.until(ExpectedConditions.elementToBeClickable(recommendationsBtn)).click();

    }

    public void RecommendationsResult(){
 String PageTitle = driver.getTitle();
 System.out.println(PageTitle);
 String heading1 = driver.findElement(pageHeading1).getText();
 System.out.println(heading1);
 String heading2 = driver.findElement(PageHeading2).getText();
 System.out.println(heading2);
 String EngineOilcap = driver.findElement(EngineOilCapacity).getText();
 System.out.println(EngineOilcap);
 Boolean motoroilBTn = driver.findElement(Motoroil).isDisplayed();
 System.out.println("Motor oil btn is displayed"+ motoroilBTn);
 String ProductTitle = driver.findElement(producttitle).getText();
 System.out.println("A product title is displayed : "+ ProductTitle);
        if(driver.findElement(productimage).isDisplayed()) {
            System.out.println("Product Image is Displayed suucessfully");
        }
        if(driver.findElement(viewproductBtn).isDisplayed()){
            System.out.println("View Product Button is displayed successfully");
        }
        if(driver.findElement(compareBtn).isDisplayed()){
            System.out.println("Compare Button is displayed successfully");
        }
        if(driver.findElement(compareBtn).isDisplayed()){
            System.out.println("Star rating is displayed successfully");
        }


    }

}
