package com.orangehrmlive.pages;

import org.openqa.selenium.By;

import static com.orangehrmlive.keywords.WebUI.*;

public class CommonPage {

    private By menuProducts = By.xpath("//*[@id='app']/div[1]/div[1]/header/div[1]/div[1]/span/h6");

    public void verifyDashboardPageDisplays() {
        waitForPageLoaded();
        verifyContains(getCurrentUrl(), "/dashboard", "The URL not match.");
        verifyElementPresent(menuProducts, 5, "Login failed. The Dashboard page not displays.");
    }

}
