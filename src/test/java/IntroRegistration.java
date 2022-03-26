import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class IntroRegistration {
    private WebDriver driver;

    public IntroRegistration (){ this.driver = SingletonWebDriver.chromeWebDriver();}
    WebDriverWait wait = new WebDriverWait(SingletonWebDriver.chromeWebDriver(), Duration.ofSeconds(10));

    public void getRegisterScreen(){
        pressIntroRegistration();
        registrationInsertDetails();
        clickRegister();
    }
    public void entrance (){driver.get("https://buyme.co.il/");
        driver.manage().window().maximize();}

    //registrationOrEntrance button
    public void pressIntroRegistration (){
        WebElement registrationOrEntranceButton = driver.findElement(By.className("notSigned"));
        registrationOrEntranceButton.click();
        WebElement registerTextLink = driver.findElement(By.className("text-link"));
        wait.until(ExpectedConditions.elementToBeClickable(registerTextLink)).click();
    }

    //registration fields
    public void registrationInsertDetails (){
        List <WebElement> inputFields = driver.findElements(By.tagName("input"));
        WebElement name = inputFields.get(0);
        WebElement email =inputFields.get(1);
        WebElement password = inputFields.get(2);
        WebElement rePassword = inputFields.get(3);
        name.sendKeys(Constants.NAME);
        email.sendKeys(Constants.EMAIL);
        password.sendKeys(Constants.PASSWORD);
        rePassword.sendKeys(Constants.PASSWORD);
    }

    //registration button
    public void clickRegister (){
        WebElement registrationButton = driver.findElement(By.cssSelector("button[type=submit]"));
      registrationButton.click();
    }
}
