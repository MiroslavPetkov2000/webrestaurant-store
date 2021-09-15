package com.web_restaurant.step_definitions;

import com.web_restaurant.pages.CartPage;
import com.web_restaurant.pages.HomePage;
import com.web_restaurant.pages.LastSearchItemPage;
import com.web_restaurant.pages.SearchResultPage;
import com.web_restaurant.utilities.BrowserUtils;
import com.web_restaurant.utilities.ConfigurationReader;
import com.web_restaurant.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;


public class ItemSearch_StepDefinitions {

    HomePage homePage = new HomePage();
    SearchResultPage searchResultPage = new SearchResultPage();
    LastSearchItemPage lastSearchItemPage = new LastSearchItemPage();
    CartPage cartPage = new CartPage();

    @Given("User is on Web Restaurant home page")
    public void user_is_on_web_restaurant_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }

    @When("User searches for an item {string}")
    public void user_searches_for_an_item(String searchItem) {
        homePage.searchBox.sendKeys(searchItem);
        homePage.searchButton.click();
    }

    @Then("All results should contain key word {string}")
    public void all_results_should_contain_key_word(String keyWord) {

        List<String> searchResultsText = BrowserUtils.getElementsText(searchResultPage.searchResult);
        String check = searchResultPage.resultButtons.get(searchResultPage.resultButtons.size() - 1).getText();
        int numberOfResultPages = Integer.parseInt(check);
        for (int n = 0; n < numberOfResultPages; n++) {
            for (String eachItem : searchResultsText) {
                Assert.assertTrue(eachItem.contains(keyWord));
            }
            if (n < numberOfResultPages - 1) {
                searchResultPage.nextPageButton.click();
            }
        }

    }

    @When("User adds last found item to cart")
    public void user_adds_last_found_item_to_cart() {
        searchResultPage.resultButtons.get(searchResultPage.resultButtons.size() - 1).click();
        searchResultPage.allResultLinks.get(searchResultPage.allResultLinks.size() - 1).click();
        lastSearchItemPage.addToCartButton.click();

    }

    @When("User empties cart")
    public void user_empties_cart() throws InterruptedException {

        lastSearchItemPage.viewCartButton.click();
        cartPage.emptyCartButton.click();
        BrowserUtils.waitForClickability(cartPage.emptyCartConfirmationButton, 3);
        cartPage.emptyCartConfirmationButton.click();

    }

    @Then("Cart should be empty")
    public void cart_should_be_empty() {

        BrowserUtils.waitForClickability(cartPage.emptyCartConfirmationMessage, 5);
        Assert.assertEquals("Your cart is empty.", cartPage.emptyCartConfirmationMessage.getText());

    }


}
