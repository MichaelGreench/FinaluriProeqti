import DataObject.LogInData;
import PageObject.LogInPage;
import StepObject.LogInStep;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTests extends LogInStep implements LogInData, LogInPage {
    @BeforeMethod
    public void chromeRunner() {

        setUp();
    }

    @AfterMethod
    public void chromeClose() {

        tearDown();
    }

    @Test (priority = 1)
    @Description ("დალოგინება ვალიდური მონაცემებით")
    @Severity(SeverityLevel.CRITICAL)
    public void logInWithCorrectData() {
        refreshPage();
        enterEmailOrPhone(validEmail);
        enterPassword(validPassword);
        clickLogInBtn();
        Assert.assertEquals(driver.getCurrentUrl(), userWelcomeUrl,"ხარვეზი გამოვლინდა ვალიდური მონაცემებით დალოგინების დროს (ვალიდური მეილი და ვალიდური პაროლი" );
    }


    @Test(priority = 2)
    @Description ("დალოგინება ვალიდური ტელეფონით და ვალიდური პაროლით")
    @Severity(SeverityLevel.CRITICAL)
    public void logInWithCorrectPhoneAndCorrectPassword() {
        refreshPage();
        enterEmailOrPhone(validPhone);
        enterPassword(validPassword);
        clickLogInBtn();
        Assert.assertEquals(driver.getCurrentUrl(),userWelcomeUrl,"ხარვეზი გამოვლინდა ვალიდური მონაცემებით დალოგინების დროს (ვალიდური ტელეფონის ნომრით და ვალიდური პაროლით");
    }

    @Test (priority = 3)
    @Description ("დალოგინება არავალიდური მონაცემებით (არავალიდური მეილი და პაროლი")
    @Severity(SeverityLevel.CRITICAL)
    public void LogInWithInvalidData() {
        refreshPage();
        enterEmailOrPhone(invalidEmail);
        enterPassword(invalidPassword);
        clickLogInBtn();
        Assert.assertTrue(errorIsDisplayed(), "ხარვეზი გამოვლინდა არავალიდური მონაცემებით დალოგინების დროს (არავალიდური იმეილი და არავალიდური პაროლი");
    }

    @Test (priority = 4)
    @Description ("დალოგინება ცარიელი ველებით, ველებში ჩადგომის გარეშე")
    @Severity(SeverityLevel.CRITICAL)
    public void logInWithNoDataWithClick() {
        refreshPage();
        clickLogInBtn();
        Assert.assertTrue(errorIsDisplayed(), "ხარვეზი გამოვლინდა დალოგინებისას ცარიელი ველებით, ველებში ჩადგომის გარეშე");
    }

    @Test (priority = 5)
    @Description ("დალოგინება ცარიელი ველებით, ველებში ჩადგომით")
    @Severity(SeverityLevel.CRITICAL)
    public void logInWithNullDataWithoutClick() {
        refreshPage();
        enterEmailOrPhone("");
        enterPassword("");
        clickLogInBtn();
        Assert.assertTrue(errorIsDisplayed(),"ხარვეზი გამოვლინდა დალოგინებისას ცარიელი ველებით, ველებში ჩადგომით" );
    }

    @Test (priority = 6)
    @Description ("დალოგენება ვალიდური მეილით და ცარფიელი პაროლით")
    @Severity(SeverityLevel.CRITICAL)
    public void logInWithCorrectMailAndWithoutPassword() {
        refreshPage();
        enterEmailOrPhone(validEmail);
        enterPassword("");
        clickLogInBtn();
        Assert.assertTrue(loginWithPasswordLinkTextCheck(), "ხარვეზი გამოვლინდა დალოგინებისას ვალიდური იმეილით: {validEmail} და ცარიელი პაროლის ველით");
    }

    @Test (priority = 7)
    @Description ("დალოგინება ვალიდური ტელეფონის ნომრითა და ცარიელი პაროლის ველით")
    @Severity(SeverityLevel.CRITICAL)
    public void logInWithValidPhoneAndWithoutPassword() {
        refreshPage();
        enterEmailOrPhone(validPhone);
        enterPassword("");
        clickLogInBtn();
        Assert.assertTrue(loginWithPasswordLinkTextCheck(),"ხარვეზი გამოვლინდა დალოგინებისას ვალიდური ტელეფონის ნომრით და ცარიელი პაროლის ველით");
    }

    @Test (priority = 8)
    @Description ("დალოგინება ცარიელი მეილის ველით და ვალიდური პაროლით")
    @Severity(SeverityLevel.CRITICAL)
    public void logInWithBlankMailAndCorrectPassword() {
        refreshPage();
        enterEmailOrPhone("");
        enterPassword(validPassword);
        clickLogInBtn();
        Assert.assertTrue(errorIsDisplayed(), "ხარვეზი გამოვლინდა დალოგინებისას ცარიელი იმეილის ველით და ვალიდური პაროლით");
    }

    @Test (priority = 9)
    @Description ("დალოგინება ვალიდური მეილით და არავალიდური პაროლით")
    @Severity(SeverityLevel.CRITICAL)
    public void logInWithCorrectMailAndIncorrectPassword(){
        refreshPage();
        enterEmailOrPhone(validEmail);
        enterPassword(invalidPassword);
        clickLogInBtn();
        Assert.assertTrue(loginWithPasswordLinkTextCheck(),"ხარვეზი გამოვლინდა დალოგინებისას ვალიდური იმეილით და არავალიდური პაროლით");
    }

    @Test (priority = 10)
    @Description ("დალოგინება ვალიდური ტელეფონით და არავალიდური პაროლით")
    @Severity(SeverityLevel.CRITICAL)
    public void logInWithCorrectPhoneAndIncorrectPassword() {
        refreshPage();
        enterEmailOrPhone(validPhone);
        enterPassword(invalidPassword);
        clickLogInBtn();
        Assert.assertTrue(loginWithPasswordLinkTextCheck(),"ხარვეზი გამოვლინდა დალოგინებისას ვალიდური ტელეფონის ნომრით და არავალიდური პაროლით");
    }



}
