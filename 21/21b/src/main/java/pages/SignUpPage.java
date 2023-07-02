package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
public class SignUpPage extends BasePage {

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "confirmPassword")
    private WebElement confirmPasswordField;

    @FindBy(xpath = "//span[contains(text(),'Sign me up')]")
    private WebElement signUpButton;

    @FindBy(css = ".v-text-field__details")
    private List<WebElement> requiredFieldMessages;

    @FindBy(xpath = "//div[contains(text(),'Valid email is required')]")
    private WebElement invalidEmailMessage;

    public WebElement getNameField() {
        return nameField;
    }

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getConfirmPasswordField() {
        return confirmPasswordField;
    }

    public WebElement getSignUpButton() {
        return signUpButton;
    }

    public List<WebElement> getRequiredFieldMessages() {
        return requiredFieldMessages;
    }

    public String getRequiredFieldMessage(int index) {
        if (index >= 0 && index < requiredFieldMessages.size()) {
            return requiredFieldMessages.get(index).getText();
        }
        return null;
    }

    public WebElement getInvalidEmailMessage() {
        return invalidEmailMessage;
    }
}