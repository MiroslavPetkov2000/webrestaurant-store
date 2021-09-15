package com.web_restaurant.pages;

import com.web_restaurant.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    public CartPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[.='Empty Cart']")
    public WebElement emptyCartButton;

    @FindBy(xpath = "//button[.='Empty Cart']")
    public WebElement emptyCartConfirmationButton;

    @FindBy(className = "header-1")
    public WebElement emptyCartConfirmationMessage;
}
