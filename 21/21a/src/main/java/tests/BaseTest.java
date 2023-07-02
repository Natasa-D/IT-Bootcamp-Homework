package tests;

import pages.BasePage;
import pages.SignUpPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    protected BasePage basePage;
    protected SignUpPage signUpPage;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C://Users//Natasa//Desktop//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        basePage = new BasePage(driver);
        signUpPage = new SignUpPage(driver);
    }

    @BeforeMethod
    public void beforeEachTest() {
        driver.get("https://vue-demo.daniel-avellaneda.com");
        driver.manage().window().maximize();
        WebElement signUp = driver.findElement(By.cssSelector("#app > div.v-application--wrap > div > header > div > div.v-toolbar__items > a:nth-child(4) > span"));
        signUp.click();
    }

    @AfterClass
    public void closeUp() {
        driver.close();
    }
}