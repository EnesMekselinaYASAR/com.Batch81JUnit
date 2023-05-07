package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_handleWindows {
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

        //3-ilk ürünün resmine tıklayarak farklı bir tab olarak açın
        WebElement ilkFotoElementi=driver.findElement(By.xpath("(//img[@class='s-image'])[1]"));
        driver.switchTo().newWindow(WindowType.TAB);

        /*
        Bu komutu kullandığımızda driver otomatik olarak oluşturulan new Tab a tıklar
        yeni Tab'da görevi gerçekleştirmek için adımları baştan almamız gerekir.
        */

        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+Keys.ENTER);
        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();

        //4-yeni tab da açılan ürünün title'ını yazdır.
        WebElement urunTitleElementi=driver.findElement(By.xpath("//span[@id='productTitle']"));
        System.out.println(urunTitleElementi.getText());
        // Nutella & GO! Hazelnut and Cocoa Spread with Breadsticks, Snack Pack, 1.8 oz each, Bulk 24 Pack

        System.out.println(driver.getCurrentUrl());
        // https://www.amazon.com/Nutella-Chocolate-Hazelnut-Spread-Breadsticks/dp/B00V54EA74/ref=sr_1_1?keywords=Nutella&qid=1683445109&sr=8-1&th=1

        //ilk  sayfaya geçip url i yazdıralım
        driver.switchTo().window(ilkSayfaHandleDegeri);
        System.out.println(driver.getCurrentUrl());// https://www.amazon.com/s?k=Nutella&ref=nb_sb_noss




    }
}

