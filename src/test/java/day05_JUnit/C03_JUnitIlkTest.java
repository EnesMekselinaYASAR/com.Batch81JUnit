package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_JUnitIlkTest {

    /*
   JUnit sayessinde main method bağımlılığından kurtuluyoruz.
   Test notasyonu bize herhangi bir methodu tek başına diğerlerinden bağımsız olarak çalıştırabilme kabiliyeti tanıyor.
   main methoda ihtiyacıımz kalmıyor.Main methodu çalıştırınca bütün methodlar çalışır.
    */
    @Test
    public void method() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
        driver.close();
    }

    @Test
    public void method02() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.facebok.com");
        driver.close();
    }

    @Test
    public void method03() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.instagram.com");
        driver.close();
    }
}
