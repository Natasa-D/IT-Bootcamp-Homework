package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {

    @Test
    public void signUpUrlVerification() {
        Assert.assertTrue(getDriver().getCurrentUrl().contains("/signup"));
    }

    @Test
    public void emailFieldVerification() {
        Assert.assertTrue(getSignUpPage().getEmailField().toString().contains("email"));
    }

    @Test
    public void passwordFieldVerification() {
        Assert.assertTrue(getSignUpPage().getPasswordField().toString().contains("password"));
    }

    @Test
    public void signUpBlankNameTest() {
        getSignUpPage().enterEmail("test@gmail.com");
        getSignUpPage().enterPassword("Test123!");
        getSignUpPage().enterConfirmPassword("Test123!");
        getSignUpPage().clickSignUpButton();

        String expectedMsg = "This field is required";
        Assert.assertEquals(getSignUpPage().getRequiredFieldMessage(0), expectedMsg);
    }

    @Test
    public void signUpBlankEmailTest() {
        getSignUpPage().enterName("Test");
        getSignUpPage().enterPassword("Test123!");
        getSignUpPage().enterConfirmPassword("Test123!");
        getSignUpPage().clickSignUpButton();

        String expectedMsg = "This field is required";
        Assert.assertEquals(getSignUpPage().getRequiredFieldMessage(1), expectedMsg);
    }

    @Test
    public void signUpBlankPasswordTest() {
        getSignUpPage().enterName("Test");
        getSignUpPage().enterEmail("test@gmail.com");
        getSignUpPage().enterConfirmPassword("Test123!");
        getSignUpPage().clickSignUpButton();

        String expectedMsg = "This field is required";
        Assert.assertEquals(getSignUpPage().getRequiredFieldMessage(2), expectedMsg);
    }

    @Test
    public void signUpBlankConfirmPasswordTest() {
        getSignUpPage().enterName("Test");
        getSignUpPage().enterEmail("test@gmail.com");
        getSignUpPage().enterPassword("Test123!");
        getSignUpPage().clickSignUpButton();

        String expectedMsg = "This field is required";
        Assert.assertEquals(getSignUpPage().getRequiredFieldMessage(3), expectedMsg);
    }

    @Test
    public void signUpInvalidEmailTest() {
        getSignUpPage().enterName("Test");
        getSignUpPage().enterEmail("testgmail.com");

        String expectedMsg = "Valid email is required";
        Assert.assertEquals(getSignUpPage().getInvalidEmailMessage().getText(), expectedMsg);
    }
}