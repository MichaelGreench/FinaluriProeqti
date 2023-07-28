package StepObject;

import DataObject.Common;
import DataObject.LogInData;
import PageObject.LogInPage;
import io.qameta.allure.Step;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogInStep implements Common, LogInPage, LogInData {

    protected ChromeDriver driver = new ChromeDriver();

    protected void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(BASEURL);
    }

    protected void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Step
    public void refreshPage() {

        driver.get(BASEURL);
    }

    @Step("Check if log in with password text is displayed")
    public boolean loginWithPasswordLinkTextCheck(){
        return driver.findElement(logInWithPasswordLinkText).isDisplayed();
    }


    @Step ("Enter E-mail")
    public void enterEmailOrPhone(String email) {

        driver.findElement(emailField).sendKeys(email);
    }

    @Step ("Enter password")
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step ("Click login button")
    public void clickLogInBtn() {

        driver.findElement(submitBtn).click();
    }

    @Step ("Check if error text is displayed")
    public boolean errorIsDisplayed() {

        return driver.findElement(invalidErrorLinkText).isDisplayed();
    }

    @Step ("Check if forgot account text is displayed")
    public boolean forgotAccountLinkTextCheck() {

        return driver.findElement(forgotAccountLinkText).isDisplayed();
    }

   @Step ("Logout")
    public void logOut() {
        if (driver.getCurrentUrl().equals(userWelcomeUrl)) {
            driver.findElement(profileImage).click();
            driver.findElement(logoutBtn).click();
        }
   }



}
