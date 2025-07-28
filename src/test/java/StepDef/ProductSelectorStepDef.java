package StepDef;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pageobjects.ProductSelectorPage;
import Utils.TestContextDI;


public class ProductSelectorStepDef {


    public TestContextDI testContext;
    public ProductSelectorPage productselectorpage;

    public ProductSelectorStepDef(TestContextDI testContext) {
        this.testContext = testContext;
        this.productselectorpage = testContext.pageObjectManager.getProductSelectorPage();

    }





    @Given("I open the Homepage website")
    public void i_open_the_homepage_website() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(productselectorpage.isHomePageDisplayed(), "HomePage is not displayed");
    }

    @When("I navigate to Find the Right Motor Oil")
    public void i_navigate_to_find_the_right_motor_oil() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(productselectorpage.ToNavigateToProductSelector(), "Product Selector Page is displayed");
    }

    @When("I select year {string}")
    public void i_select_year(String string) {
        // Write code here that turns the phrase above into concrete actions
        productselectorpage.selectYear(string);
    }

    @When("I select make {string}")
    public void i_select_make(String string) {
        productselectorpage.selectMake(string);
    }

    @When("I select model {string}")
    public void i_select_model(String string) {
        productselectorpage.selectModel(string);
    }

    @When("I select engine {string}")
    public void i_select_engine(String string) {
        productselectorpage.selectEngine(string);
    }

    @When("I click on view recommendations")
    public void i_click_on_view_recommendations() {
productselectorpage.ViewRecommendations();

    }

    @Then("I should see the recommendation results")
    public void i_should_see_the_recommendation_results() {
        productselectorpage.RecommendationsResult();
    }


}
