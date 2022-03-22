import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public class IntroRegistration {
    private WebDriver driver;

    public IntroRegistration (){ this.driver = SingletonWebDriver.chromeWebDriver();}

    public void entrance (){driver.get("https://buyme.co.il/");}

    public void pressIntroRegistration (){driver.findElement(By.className("notSigned")).click();}

    public void registrationInsertDetails (){
        WebElement name = driver.findElement(By.xpath("//*[@id=\"ember1795\"]"));
        WebElement email = driver.findElement(By.cssSelector("input[placeholder=מייל]"));
        WebElement password = driver.findElement(By.id("valPass"));
        WebElement rePassword = driver.findElement(By.xpath("//*[@id=\"ember1816\"]"));
        name.sendKeys(Constants.NAME);
        email.sendKeys(Constants.EMAIL);
        password.sendKeys(Constants.PASSWORD);
        rePassword.sendKeys(Constants.PASSWORD);
    }
    public void clickRegister (){
     driver.findElement(By.id("ember1822")).click();

    }







}
