Feature: Login Test CMS

  Background: Navigate to Login page for Admin
    Given User navigate to Login Page for Admin "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"

  @Regression @device_Window_11 @author_B
  Scenario: Login success
    When user enter username "Admin" password "admin123"
    Then user is redirected to the Dashboard page