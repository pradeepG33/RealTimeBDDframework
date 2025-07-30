package pageobjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    private WebDriver driver;
    private ProductSelectorPage productselectorpage;
    private DistributorPage distributorpage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }


    public ProductSelectorPage getProductSelectorPage() {
        if (productselectorpage == null) {
            productselectorpage = new ProductSelectorPage(driver);
        }
        return productselectorpage;
    }

    public DistributorPage getDistributorPage() {
        if (distributorpage == null) {
            distributorpage = new DistributorPage(driver);
        }
        return distributorpage;
    }
}
