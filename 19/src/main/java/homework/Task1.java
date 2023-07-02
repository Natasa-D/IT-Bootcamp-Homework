package homework;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Task1 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C://Users//Natasa//Desktop//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/text-box");

        Faker faker =new Faker();

        WebElement fullName = driver.findElement(By.id("userName"));
        String enteredFullName = faker.name().fullName();
        fullName.sendKeys(enteredFullName);

        WebElement email = driver.findElement(By.id("userEmail"));
        String enteredEmail = faker.internet().emailAddress();
        email.sendKeys(enteredEmail);

        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        String enteredCurrentAddress = faker.address().fullAddress();
        currentAddress.sendKeys(enteredCurrentAddress);

        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        String enteredPermanentAddress = faker.address().fullAddress();
        permanentAddress.sendKeys(enteredPermanentAddress);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)", "");

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();

        Thread.sleep(200);

        WebElement outputFullName = driver.findElement(By.id("name"));
        WebElement outputEmail = driver.findElement(By.id("email"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(outputFullName));
        wait.until(ExpectedConditions.visibilityOf(outputEmail));

        String displayedFullName = outputFullName.getText();
        String displayedEmail = outputEmail.getText();

        String name1="Name:"+enteredFullName;
        String email1="Email:"+enteredEmail;

        if (name1.equals(displayedFullName)&& email1.equals(displayedEmail)) {
            System.out.println("Full name and email match entered data.");
        } else {
            System.out.println("Full name and/or email do not match entered data.");
        }

       driver.close();


    }
}
