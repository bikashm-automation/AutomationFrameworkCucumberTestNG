package com.orangehrmlive.hooks;

import com.orangehrmlive.driver.DriverManager;
import com.orangehrmlive.driver.TargetFactory;
import com.orangehrmlive.pages.CommonPage;
import com.orangehrmlive.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;

public class TestContext {

    private WebDriver driver;
    private LoginPage loginPage;
    private CommonPage commonPage;
    public TestContext() {
        driver = ThreadGuard.protect(new TargetFactory().createInstance());
        driver.manage().window().maximize();
        DriverManager.setDriver(driver);
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public CommonPage getCommonPage() {
        if (commonPage == null) {
            commonPage = new CommonPage();
        }
        return commonPage;
    }

    public WebDriver getDriver() {
        return DriverManager.getDriver();
    }

}
