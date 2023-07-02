package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;


public class Task1 {
     WebDriver driver;
     WebDriverWait wait;

    @BeforeClass
    public void setup () {
        System.setProperty("webdriver.chrome.driver", "C://Users//Natasa//Desktop//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeMethod
        public void beforeEachTest(){
        driver.get("https://vue-demo.daniel-avellaneda.com");
        driver.manage().window().maximize();
        WebElement signUp= driver.findElement(By.cssSelector("#app > div.v-application--wrap > div > header > div > div.v-toolbar__items > a:nth-child(4) > span"));
        signUp.click();

    }

    @Test (priority= 1)
    public void signUpUrlVerification(){
          Assert.assertTrue(driver.getCurrentUrl().contains("/signup"));
        }


    @Test (priority= 2)
    public void emailFieldVerification(){
        WebElement emailInput = driver.findElement(By.id("email"));
        Assert.assertEquals(emailInput.getAttribute("type"), "email");
    }

    @Test (priority= 3)
    public void passwordFieldVerification() {
        WebElement passInput = driver.findElement(By.id("password"));
        Assert.assertEquals(passInput.getAttribute("type"), "password");
    }

    @Test (priority= 4)
    public void signUpBlankNameTest(){
        WebElement email= driver.findElement(By.id("email"));
        email.sendKeys("test@gmail.com");
        WebElement password= driver.findElement(By.id("password"));
        password.sendKeys("Test123!");
        WebElement confirmPassword= driver.findElement(By.id("confirmPassword"));
        confirmPassword.sendKeys("Test123!");
        WebElement signUpBtn= driver.findElement(By.xpath("//span[contains(text(),'Sign me up')]"));
        signUpBtn.click();
        WebElement requiredFieldMsg= driver.findElement(By.cssSelector("#app > div > main > div > div.container.container--fluid > div > div > div.flex.xs12.sm6.offset-sm3 > span > form > div > div:nth-child(1) > span > div > div > div.v-text-field__details > div > div > div"));
        String expectedMsg="This field is required";
        Assert.assertEquals(requiredFieldMsg.getText(),expectedMsg);
    }


    @Test (priority= 5)
    public void signUpBlankEmailTest(){
        WebElement name= driver.findElement(By.id("name"));
        name.sendKeys("Test");
        WebElement password= driver.findElement(By.id("password"));
        password.sendKeys("Test123!");
        WebElement confirmPassword= driver.findElement(By.id("confirmPassword"));
        confirmPassword.sendKeys("Test123!");
        WebElement signUpBtn= driver.findElement(By.xpath("//span[contains(text(),'Sign me up')]"));
        signUpBtn.click();
        WebElement requiredFieldMsg= driver.findElement(By.cssSelector("#app > div > main > div > div.container.container--fluid > div > div > div.flex.xs12.sm6.offset-sm3 > span > form > div > div:nth-child(2) > span > div > div > div.v-text-field__details > div > div > div"));
        String expectedMsg="This field is required";
        Assert.assertEquals(requiredFieldMsg.getText().toString(), expectedMsg);
    }

    @Test (priority= 6)
    public void signUpBlankPasswordTest(){
        WebElement name= driver.findElement(By.id("name"));
        name.sendKeys("Test");
        WebElement email= driver.findElement(By.id("email"));
        email.sendKeys("test@gmail.com");
        WebElement confirmPassword= driver.findElement(By.id("confirmPassword"));
        confirmPassword.sendKeys("Test123!");
        WebElement signUpBtn= driver.findElement(By.xpath("//span[contains(text(),'Sign me up')]"));
        signUpBtn.click();
        WebElement requiredFieldMsg= driver.findElement(By.cssSelector("#app > div > main > div > div.container.container--fluid > div > div > div.flex.xs12.sm6.offset-sm3 > span > form > div > div:nth-child(3) > span > div > div > div.v-text-field__details > div > div > div"));
        String expectedMsg="This field is required";
        Assert.assertEquals(requiredFieldMsg.getText(), expectedMsg);

    }
    @Test (priority= 7)
    public void signUpBlankConfirmPasswordTest() {
        WebElement name = driver.findElement(By.id("name"));
        name.sendKeys("Test");
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("test@gmail.com");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Test123!");
        WebElement signUpBtn = driver.findElement(By.xpath("//span[contains(text(),'Sign me up')]"));
        signUpBtn.click();
        WebElement requiredFieldMsg = driver.findElement(By.cssSelector("#app > div > main > div > div.container.container--fluid > div > div > div.flex.xs12.sm6.offset-sm3 > span > form > div > div:nth-child(4) > span > div > div > div.v-text-field__details > div"));
        String expectedMsg = "This field is required";
        Assert.assertEquals(requiredFieldMsg.getText(), expectedMsg);
    }

    @Test (priority= 8)
    public void signUpInvalidEmailTest() {
        WebElement name = driver.findElement(By.id("name"));
        name.sendKeys("Test");
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("testgmail.com");
        WebElement requiredFieldMsg = driver.findElement(By.xpath("//div[contains(text(),'Valid email is required')]"));
        String expectedMsg = "Valid email is required";
        Assert.assertEquals(requiredFieldMsg.getText(), expectedMsg);
    }



    @AfterClass
    public void closeUp(){
        driver.close();
    }





}
