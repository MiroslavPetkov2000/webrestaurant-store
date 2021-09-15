package com.web_restaurant.pages;

import com.web_restaurant.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LastSearchItemPage {
    public LastSearchItemPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "#buyButton")
    public WebElement addToCartButton;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement viewCartButton;
}
