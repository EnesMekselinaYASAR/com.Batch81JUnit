package day06_RadioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_RadioButton {
    /*
   1-https://facebook.com hesabına gidin
   2- Cookies'i kabul edin
   3-"Create an Account" butonuna basın
   4-"radio buttons" elementlerini locate edin.
   **bize tek seçenek sunuyorsa ve birini seçince diğerlerini seçtirmiyorsa bu ihtimali ortadan kaldırıyorsa "radio button"
   **birden fazla seçenek seçebiliyorsak "checkbox"
   5-Seçili değilse cinsiyet butonundan size uygun olanı seçin
    */
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//*[text()='Yeni hesap oluştur']")).click();

        WebElement kadinButonu=driver.findElement(By.xpath("(//input[@name='sex'])[1]"));
        WebElement erkekButonu=driver.findElement(By.xpath("(//input[@name='sex'])[2]"));
        WebElement ozelButonu=driver.findElement(By.xpath("(//input[@name='sex'])[3]"));
        Thread.sleep(3000);
        if (!erkekButonu.isSelected()){
            erkekButonu.click();
        }
        Thread.sleep(3000);

    }



}
