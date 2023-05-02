package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_InvalidEmailAssertions {

    /*
    http://www.automationpractice.com/index.php sayfasına gidelim
    Sign in butonuna basalım
    Email kutusuna @işareti olmayan bir mail adresi yazıp enter'a bastağımızda
        "Invalid email address" uyarısı çıktığını test edelim
     */

    static WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("http://www.automationpractice.com/index.php");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test01(){
        //Sign in butonuna basalım
        driver.findElement(By.xpath("//a[@class='login']")).click();

        //Email kutusuna @işareti olmayan bir mail adresi yazıp enter'a bastağımızda'
        //"Invalid email address" uyarısı çıktığını test edelim
        WebElement mailKutusu = driver.findElement(By.xpath("//input[@id='email_create']"));
        mailKutusu.sendKeys("enesgmail.com" + Keys.ENTER);
        WebElement uyariYazisiElementi = driver.findElement(By.xpath("//*[@text='Invalid email address']"));
        Assert.assertTrue(uyariYazisiElementi.isDisplayed());

    }



}
