package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class handleWindows {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() {
        // driver.quit();
    }

    @Test
    public void test01() {
        //1-amazona gidin.
        driver.get("https://amazon.com");
        // System.out.println(driver.getWindowHandle());//bize hashkodu yazdırır
        /*
        19B00AB11F39788A60AD272380A736E0 bu kod açılan sayfanın unique hash kodudur.
        Selenium sayfalar arası geçişte bu handle değerini kullanır.
        Eğer sayfalar arasında driverımızı gezdiriyorsak veya herhangi bir sayfadan
        şu anda bulunduğumuz sayfaya geçmek istiyorsak
        driver.switchTo().window("19B00AB11F39788A60AD272380A736E0");
        bu sayfanın window handle değerini girerek bu sayfaya geçiş yapabiliriz.
        */

        String ilkSayfaHandleDegeri= driver.getWindowHandle();

        // 2-nutella icin arama yapalim

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);
        WebElement ilkFotoElementi=driver.findElement(By.xpath("(//img[@class='s-image'])[1]"));
        ilkFotoElementi.click();










    }
}

