package StepDef;

import Utils.TestContextDI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobjects.DistributorPage;
import pageobjects.ProductSelectorPage;

public class DistributorStepDef {
    public TestContextDI testContext;
    public DistributorPage distributorpage;
    public ProductSelectorPage productselectorpage;

    public DistributorStepDef(TestContextDI testContext){
        this.testContext = testContext;
        this.distributorpage = testContext.pageObjectManager.getDistributorPage();
        this.productselectorpage = testContext.pageObjectManager.getProductSelectorPage();
    }
    @Given("I open the HomePage website")
    public void i_open_the_home_page_website() {
        Assert.assertTrue(productselectorpage.isHomePageDisplayed(), "Home page is not displayed");
    }

    @When("I navigate to where to buy locator page")
    public void i_navigate_to_where_to_buy_locator_page() {
Assert.assertTrue(distributorpage.ToNavigateToLocatorPage(), "Distributor page is not displayed");
    }

    @And("I enter {string} in the search box")
    public void i_enter_in_the_search_box(String country) {
     Assert.assertTrue(distributorpage.Tosearch(country), "Search Input is not displayed");
    }

    @Then("the map should update to show distributors in US")
    public void the_map_should_update_to_show_distributors_in_us() {
    }

    @And("the distributor list should show relevant names and addresses")
    public void the_distributor_list_should_show_relevant_names_and_addresses() {

    }
}
