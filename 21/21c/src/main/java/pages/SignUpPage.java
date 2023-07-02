package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SignUpPage extends BasePage {
    private By nameField = By.id("name");
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By confirmPasswordField = By.id("confirmPassword");
    private By signUpButton = By.xpath("//span[contains(text(),'Sign me up')]");

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public void enterName(String name) {
        getDriver().findElement(nameField).sendKeys(name);
    }

    public void enterEmail(String email) {
        getDriver().findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        getDriver().findElement(passwordField).sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        getDriver().findElement(confirmPasswordField).sendKeys(confirmPassword);
    }

    public void clickSignUpButton() {
        getDriver().findElement(signUpButton).click();
    }


    public By getEmailField() {
        return emailField;
    }

    public By getPasswordField() {
        return passwordField;
    }

    public List<WebElement> getRequiredFieldMessages() {
        return getDriver().findElements(By.cssSelector(".v-text-field__details"));
    }

    public String getRequiredFieldMessage(int index) {
        List<WebElement> requiredFieldMessages = getRequiredFieldMessages();
        if (index >= 0 && index < requiredFieldMessages.size()) {
            return requiredFieldMessages.get(index).getText();
        }
        return null;
    }

    public WebElement getInvalidEmailMessage() {
        return getDriver().findElement(By.xpath("//div[contains(text(),'Valid email is required')]"));
    }
}