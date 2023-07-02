package tests;

import org.testng.Assert;
import org.testng.annotations.*;


public class SignUpTest extends BaseTest {


    @Test
    public void signUpUrlVerification() {
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"));
    }

    @Test
    public void emailFieldVerification() {
        Assert.assertEquals(signUpPage.getEmailField().getAttribute("type"), "email");
    }

    @Test
    public void passwordFieldVerification() {
        Assert.assertEquals(signUpPage.getConfirmPasswordField().getAttribute("type"), "password");
    }

    @Test
    public void signUpBlankNameTest() {
        signUpPage.getEmailField().sendKeys("test@gmail.com");
        signUpPage.getPasswordField().sendKeys("Test123!");
        signUpPage.getConfirmPasswordField().sendKeys("Test123!");
        signUpPage.getSignUpButton().click();
        String expectedMsg = "This field is required";
        Assert.assertEquals(signUpPage.getRequiredFieldMessage(0), expectedMsg);
    }

    @Test
    public void signUpBlankEmailTest() {
        signUpPage.getNameField().sendKeys("Test");
        signUpPage.getPasswordField().sendKeys("Test123!");
        signUpPage.getConfirmPasswordField().sendKeys("Test123!");
        signUpPage.getSignUpButton().click();
        String expectedMsg = "This field is required";
        Assert.assertEquals(signUpPage.getRequiredFieldMessage(1), expectedMsg);
    }

    @Test
    public void signUpBlankPasswordTest() {
        signUpPage.getNameField().sendKeys("Test");
        signUpPage.getEmailField().sendKeys("test@gmail.com");
        signUpPage.getConfirmPasswordField().sendKeys("Test123!");
        signUpPage.getSignUpButton().click();
        String expectedMsg = "This field is required";
        Assert.assertEquals(signUpPage.getRequiredFieldMessage(2), expectedMsg);
    }

    @Test
    public void signUpBlankConfirmPasswordTest() {
        signUpPage.getNameField().sendKeys("Test");
        signUpPage.getEmailField().sendKeys("test@gmail.com");
        signUpPage.getPasswordField().sendKeys("Test123!");
        signUpPage.getSignUpButton().click();
        String expectedMsg = "This field is required";
        Assert.assertEquals(signUpPage.getRequiredFieldMessage(3), expectedMsg);
    }

    @Test
    public void signUpInvalidEmailTest() {
        signUpPage.getNameField().sendKeys("Test");
        signUpPage.getEmailField().sendKeys("testgmail.com");
        String expectedMsg = "Valid email is required";
        Assert.assertEquals(signUpPage.getInvalidEmailMessage().getText(), expectedMsg);
    }

}