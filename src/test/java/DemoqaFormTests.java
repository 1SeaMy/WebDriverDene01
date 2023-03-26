import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DemoqaFormTests {
    public static void main(String[] args) {
//        WebDriverManager.chromedriver().setup();

        ChromeOptions options =new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable notifications");
        options.addArguments("--incognito");

        DesiredCapabilities cp=new DesiredCapabilities();
        cp.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(cp);

        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");

        WebElement eleFullName =driver.findElement(By.cssSelector("#userName"));
        eleFullName.click();
        eleFullName.sendKeys("can");

        WebElement eleEmail =driver.findElement(By.xpath("//input[@id='userEmail']"));
        eleEmail.click();
        eleEmail.sendKeys("can@can.com");

        WebElement eleCurAdr =driver.findElement(By.cssSelector("#currentAddress"));
        eleCurAdr.click();
        eleCurAdr.sendKeys("Ankara");

        WebElement elePerAdr =driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        elePerAdr.click();
        elePerAdr.sendKeys("Etimesgut");

        WebElement eleSubmit = driver.findElement(By.xpath("//button[@id='submit']"));
        eleSubmit.click();

//        driver.quit();
    }
}