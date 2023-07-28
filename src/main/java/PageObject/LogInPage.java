package PageObject;

import org.openqa.selenium.By;

public interface LogInPage {


    By
            emailField = By.id("email"),
            passwordField = By.name("pass"),
            submitBtn = By.id("loginbutton"),
            logInWithPasswordLinkText = By.linkText("Log in with password"),
            invalidErrorLinkText = By.linkText("Find your account and log in."),
            forgotAccountLinkText = By.linkText("Forgot account?"),
            profileImage = By.xpath("//image[contains(@xlink:href, '143086968_2856368904622192_1959732218791162458_n.png')]"),
            logoutBtn = By.xpath("//span[contains(@class, 'x193iq5w') and text()='Log Out']");
}
