package pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class DistributorPage {
    WebDriver driver;
    WebDriverWait wait;

    public DistributorPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //By AcceptCookies = By.id("onetrust-accept-btn-handler");
    By WhereToTBuy = By.xpath("(//span[@class='nav-link-text'])[4]");
    By lubricantsdistributors = By.xpath("//a[@href='/en/lubricants/where-to-buy/heavy-duty-lubricant-distributor-locator']");
    By searchinput = By.id("searchInput");
    By searchbutton = By.xpath("//button[@class='btn btn-primary locator-search']");
    By LocatorPageTitle = By.xpath("//h1[@class='screen-title-title h_level field-title']");
    By autosuggestion = By.xpath("//div[@class='as_lines_root']");
    By autosuggestionresulttitle = By.xpath("//h1[@class='newGdlUisearchbartitle']");


    public boolean ToNavigateToLocatorPage() {
        wait.until(ExpectedConditions.elementToBeClickable(WhereToTBuy)).click();

        wait.until(ExpectedConditions.elementToBeClickable(lubricantsdistributors)).click();

        return driver.findElement(LocatorPageTitle).isDisplayed();
    }

    public boolean Tosearch(String country){
        System.out.println(country);

        WebElement input = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("searchInput")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = arguments[1];", input, country);

       // wait.until(ExpectedConditions.elementToBeClickable(searchinput)).sendKeys(country);
        List<WebElement> auto = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(autosuggestion));
        for(WebElement element : auto){
            if(element.getText().equals(country)){
                element.click();
            }
        }
        if(wait.until(ExpectedConditions.elementToBeClickable(autosuggestionresulttitle)).getText()=="Distributors United States") {
            return true;
        }
        else{
            return false;
        }
    }





}
