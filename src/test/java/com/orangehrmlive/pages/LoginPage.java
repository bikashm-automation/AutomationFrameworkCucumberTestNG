package com.orangehrmlive.pages;

import com.orangehrmlive.keywords.WebUI;
import org.openqa.selenium.By;

public class LoginPage {

    public By inputUserName = By.xpath("//*[@name='username']");
    public By inputPassword = By.xpath("//*[@name='password']");
    public By buttonLogIn = By.xpath("//button[@type='submit']");
    public By alertErrorMessage = By.xpath("//*[@class='orangehrm-login-error']/div/div/p");
    public By linkForgotPassword = By.xpath("//*[@class='orangehrm-login-forgot']/p");
    private String pageUrl = "/login";
    private String pageTitle = "OrangeHRM";

    public LoginPage() {
        super();

    }

    public CommonPage login(String email, String password) {
        WebUI.setText(inputUserName, email);
        WebUI.setText(inputPassword, password);
        WebUI.clickElement(buttonLogIn);

        return new CommonPage();
    }

}
