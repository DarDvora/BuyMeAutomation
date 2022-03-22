import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class BuyMeSanityTest extends IntroRegistration {
    private static WebDriver driver;

    public BuyMeSanityTest() {
        this.driver = SingletonWebDriver.chromeWebDriver();
    } //reference to singleton webdriver

    IntroRegistration introRegistration = new IntroRegistration();
    private static WebDriverWait wait;

    @BeforeClass
    public void beforeClass() {
        introRegistration.entrance();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @Test(priority = 1)
    public void getRegisterScreen() throws InterruptedException {
        introRegistration.pressIntroRegistration();
        wait.until(ExpectedConditions.elementToBeClickable(By.className("text-link"))).click();
    }

    @Test(priority = 2)
    public void registration() throws InterruptedException {
        introRegistration.registrationInsertDetails();
        introRegistration.clickRegister();
    }

    @Test(priority = 3)
    public void amountSelection() throws InterruptedException {
        WebElement amount =driver.findElement(By.cssSelector("span[alt=סכום]"));
        wait.until(ExpectedConditions.elementToBeClickable(amount));
        amount.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("ember1066"))).click();

        WebElement area =driver.findElement(By.cssSelector("span[alt=אזור]"));
        wait.until(ExpectedConditions.elementToBeClickable(area));
        area.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("ember1101"))).click();


        WebElement category =driver.findElement(By.cssSelector("span[alt=קטגוריה]"));
        wait.until(ExpectedConditions.elementToBeClickable(category));
        category.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("ember1161"))).click();


    }
    @Test(priority = 4)
    public void search(){
        WebElement search = driver.findElement(By.id("ember1188"));
        search.click();
    }

    @Test(priority = 5)
    public void assertURL() throws InterruptedException {
        //Thread.sleep(10000);
        String URL = "https://buyme.co.il/search?budget=3&category=204&region=9";
        Assert.assertEquals(driver.getCurrentUrl(),URL);

    }
    @Test(priority = 6)
    public void pickBusiness(){
        WebElement TevaNaot = driver.findElement(By.xpath("//*[@id=\"ember2089\"]/div[2]"));
        TevaNaot.click();
    }

    @Test (priority = 7)
    public void insertAmount(){
        WebElement insertAmount = driver.findElement(By.id("ember2295"));
        insertAmount.sendKeys("500");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ember2301\"]"))).click();
    }

    @Test(priority = 8)
    public void sender(){
        WebElement anotherone = driver.findElement(By.xpath("//*[@id=\"ember3139\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(anotherone));
        anotherone.click();



    }


}












