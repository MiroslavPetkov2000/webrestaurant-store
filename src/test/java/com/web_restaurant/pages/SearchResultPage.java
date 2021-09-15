package com.web_restaurant.pages;

import com.web_restaurant.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultPage {
    public SearchResultPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='ag-item gtm-product ']")
    public List<WebElement> searchResult;


    @FindBy(xpath = "//li[@class='rc-pagination-next']")
    public WebElement nextPageButton;

    @FindBy(xpath = "//li[contains(@class,'rc-pagination-item')]")
    public List<WebElement> resultButtons;

    @FindBy(xpath = "//a[@data-testid='itemDescription']")
    public List<WebElement> allResultLinks;
}
