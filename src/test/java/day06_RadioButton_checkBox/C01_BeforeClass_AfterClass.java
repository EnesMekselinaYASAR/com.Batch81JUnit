package day06_RadioButton_checkBox;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/*
BeforeClass  ve AfterClass methodları sadece static methodlar için çalışır.Class da sadece 1 kere çalışır.
Before ve After notasyonları her methoddan önce ve her methoddan sonra çalısır.
Ama BeforeClass  ve AfterClass methodları sadece class'ın basında ve class'ın sonunda çalısır.
**Before ve After da gidiyo test1 i yapıyo kapatıyo test2 yi yapıyo kapatıyo...**
**BeforeClass  ve AfterClass methodlarında gidiyo test1,2,3 üyapıp geliyo kapatıyo**
BeforeClass(precondition)->örneğin test methodlarımız çalışmadan driver oluşturup tüm methodlarda kullanabilirm.
AfterClass->örneğin açtığımız sayfayı kapatmak veya elde ettiğimiz test sonuçlarını raporlamak gibi.
 */
public class C01_BeforeClass_AfterClass {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
    }

    @Test
    public void test02(){
        driver.get("https://www.facebook.com");
    }

    @Test
    public void test03(){
        driver.get("https://www.instagram.com");
    }

}
