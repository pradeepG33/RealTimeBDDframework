package pageobjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    private WebDriver driver;
    private ProductSelectorPage productselectorpage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }


    public ProductSelectorPage getProductSelectorPage() {
        if (productselectorpage == null) {
            productselectorpage = new ProductSelectorPage(driver);
        }
        return productselectorpage;
    }
}
