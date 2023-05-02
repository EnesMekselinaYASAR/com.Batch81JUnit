package day06_RadioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Assertion {

    /*
    JUnit'in bize getirdiği 2 tane yenilik vardı
    ı.Before-After
    ıı.Assertion-if-else tarih oldu artık assertionlarla bu işlemleri yapacağız
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
    public void test01(){
        /*
        Eğer test methodumuzda hiçbir test yoksa test çalıştıktan sonra
        hiçbir problemle karşılaşılmadığını raporlamak için"test passed" yazısı çıkar.
        Eğer testlerii if ile yaparsak test failed olsa bile kodlar problemsiz çalıştığı için ekranın sol alt tarafında test passed yapar.
         */
        driver.get("https://amazon.com");
    }
}
