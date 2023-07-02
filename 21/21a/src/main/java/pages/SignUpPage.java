package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
public class SignUpPage extends BasePage {

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getNameField() {
        return driver.findElement(By.id("name"));
    }

    public WebElement getEmailField() {
        return driver.findElement(By.id("email"));
    }

    public WebElement getPasswordField() {
        return driver.findElement(By.id("password"));
    }


    public WebElement getConfirmPasswordField() {
        return driver.findElement(By.id("confirmPassword"));
    }

    public WebElement getSignUpButton() {
        return driver.findElement(By.xpath("//span[contains(text(),'Sign me up')]"));
    }

    public List<WebElement> getRequiredFieldMessages() {
        return driver.findElements(By.cssSelector(".v-text-field__details"));
    }

    public String getRequiredFieldMessage(int index) {
        List<WebElement> requiredFieldMessages = getRequiredFieldMessages();
        if (index >= 0 && index < requiredFieldMessages.size()) {
            return requiredFieldMessages.get(index).getText();
        }
        return null;
    }

    public WebElement getInvalidEmailMessage() {
        return driver.findElement(By.xpath("//div[contains(text(),'Valid email is required')]"));
    }
}