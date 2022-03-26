import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SendInformation {
        private WebDriver driver;

        public SendInformation() {this.driver = SingletonWebDriver.chromeWebDriver();}

        WebDriverWait wait = new WebDriverWait(SingletonWebDriver.chromeWebDriver(), Duration.ofSeconds(10));

        public void informationToPayment () throws InterruptedException {
            now();
            email();
            sendEmail();
            payment();
        }


        public void now (){
            WebElement now = driver.findElement(By.className("button-now"));
            now.click();
        }
        public void email(){
            WebElement email = driver.findElement(By.cssSelector("svg[gtm=method-email]"));
            wait.until(ExpectedConditions.elementToBeClickable(email));
            email.click();
        }
        public void sendEmail() throws InterruptedException {
            WebElement sendEmail = driver.findElement(By.id("email"));
            Thread.sleep(3000);
            sendEmail.sendKeys("ddd@d.com");
        }
        public void payment(){
            WebElement payment = driver.findElement(By.cssSelector("button[type=submit]"));
            wait.until(ExpectedConditions.elementToBeClickable(payment));
            payment.click();
        }
    }

