package com.orangehrmlive.stepdefinitions;

import com.orangehrmlive.hooks.TestContext;
import com.orangehrmlive.keywords.WebUI;
import com.orangehrmlive.pages.CommonPage;
import com.orangehrmlive.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    LoginPage loginPage;
    CommonPage commonPage;

    public LoginSteps(TestContext testContext) {
        loginPage = testContext.getLoginPage();
        commonPage = testContext.getCommonPage();
    }

    @Given("User navigate to Login Page for Admin {string}")
    public void userNavigateToLoginPageForAdmin(String url) {
        WebUI.openWebsite(url);
    }

    @When("user enter username {string} password {string}")
    public void userEnterEmailPasswordAndClickLoginButton(String email, String password) {
        commonPage = loginPage.login(email, password);
    }

    @And("click Login button")
    public void clickLoginButton() {
    }

    @Then("user is redirected to the Dashboard page")
    public void userIsRedirectedToTheDashboardPage() {
        commonPage.verifyDashboardPageDisplays();
    }

}
