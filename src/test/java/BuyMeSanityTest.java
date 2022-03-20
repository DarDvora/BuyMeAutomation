import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;

public class BuyMeSanityTest {
    private static WebDriver driver;
    public BuyMeSanityTest (){this.driver = SingletonWebDriver.chromeWebDriver();} //reference to singleton webdriver
    IntroRegistration introRegistration = new IntroRegistration();
    private static WebDriverWait wait;

    @BeforeClass
    public void beforeClass (){
        introRegistration.entrance();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));

    }
    @Test
    public void getRegisterScreen () throws InterruptedException {
        introRegistration.pressIntroRegistration();
        wait.until(ExpectedConditions.elementToBeClickable(By.className("text-link"))).click();
    }
    @Test
    public void registration (){
        introRegistration.registrationInsertDetails();
        introRegistration.clickRegister();
    }



}
