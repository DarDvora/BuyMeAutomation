import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InformationScreen {
    private WebDriver driver;

    public InformationScreen(){this.driver = SingletonWebDriver.chromeWebDriver();}
    WebDriverWait wait = new WebDriverWait(SingletonWebDriver.chromeWebDriver(), Duration.ofSeconds(10));

    public void senderAndReceiverInformation  () throws InterruptedException {
        sender();
        blessing();
        event();
        textArea();
        //uploadImage();
        continues();
    }


    public void sender() throws InterruptedException {
        Thread.sleep(5000);
        WebElement anotherone = driver.findElement(By.className("button-forSomeone"));
        wait.until(ExpectedConditions.elementToBeClickable(anotherone));
        anotherone.click();
    }

    public void blessing() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement reciverName = driver.findElement(By.xpath("//*[@id=\"ember2426\"]"));
        Thread.sleep(5000);
        reciverName.sendKeys("Sara");

    }
    public void event (){
        WebElement eventsDropdown = driver.findElement(By.className("selected-name"));
        wait.until(ExpectedConditions.elementToBeClickable(eventsDropdown));
        eventsDropdown.click();

        WebElement thanks = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div/div[1]/form/div[2]/div[2]/label/div/div[2]/ul/li[4]"));
        wait.until(ExpectedConditions.elementToBeClickable(thanks));
        thanks.click();

    }
    public void textArea(){
        WebElement clearText = driver.findElement(By.tagName("textarea"));
        clearText.clear();
        clearText.sendKeys("thank you");
    }

    /*public void uploadImage() throws InterruptedException {
        WebElement upload = driver.findElement(By.id("ember2446"));
        Thread.sleep(5000);
        upload.sendKeys("C:\\Users\\Dvora.W10N-LNX-DVORAD\\Desktop\\IMG_0031.JPG");
        Thread.sleep(30000);
    }*/

    public void continues (){
        WebElement continues = driver.findElement(By.cssSelector("button[type=submit]"));
        continues.click();
    }
}
