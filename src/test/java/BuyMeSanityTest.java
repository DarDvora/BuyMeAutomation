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
    public void sender() throws InterruptedException {
        Thread.sleep(5000);
        WebElement anotherone = driver.findElement(By.className("button-forSomeone"));
        wait.until(ExpectedConditions.elementToBeClickable(anotherone));
        anotherone.click();

    }
    @Test (priority = 9)
    public void blessing() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement reciverName = driver.findElement(By.xpath("//*[@id=\"ember2427\"]"));
        Thread.sleep(5000);
        reciverName.sendKeys("Sara");

    }
    @Test (priority = 10)
    public void event (){
        WebElement eventsDropdown = driver.findElement(By.className("selected-name"));
        wait.until(ExpectedConditions.elementToBeClickable(eventsDropdown));
        eventsDropdown.click();

        WebElement thanks = driver.findElement(By.xpath("//*[@id=\"ember2524\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(thanks));
        thanks.click();

    }
    @Test (priority = 11)
    public void textArea(){
        WebElement clearText = driver.findElement(By.tagName("textarea"));
        clearText.clear();
        clearText.sendKeys("thank you");
    }

    @Test (priority = 12)
    public void uploadImage() throws InterruptedException {
        WebElement upload = driver.findElement(By.id("ember2447"));
        Thread.sleep(5000);
        upload.sendKeys("C:\\Users\\Dvora.W10N-LNX-DVORAD\\Desktop\\IMG_0031.JPG");
        Thread.sleep(15000);
    }
    @Test (priority = 13)
    public void continues (){
        WebElement continues = driver.findElement(By.cssSelector("button[type=submit]"));
        continues.click();
    }
    @Test (priority = 14)
    public void now () throws InterruptedException {
        WebElement now = driver.findElement(By.id("ember2562"));

        WebElement email = driver.findElement(By.cssSelector("svg[gtm=method-email]"));
        wait.until(ExpectedConditions.elementToBeClickable(email));
        email.click();

        WebElement sendEmail = driver.findElement(By.id("email"));
        Thread.sleep(3000);
        sendEmail.sendKeys("ddd@d.com");

        WebElement payment = driver.findElement(By.id("ember2596"));
        wait.until(ExpectedConditions.elementToBeClickable(payment));
        payment.click();
    }


}












