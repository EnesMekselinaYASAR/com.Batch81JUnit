package day08_alerts_iframe_basicauth;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Alerts {

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
        //driver.close();
    }

    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();

        // alert'te OK tusuna basin
        driver.switchTo().alert().accept();

        // result kisminda "You successfully clicked an alert" yazdigini test edin

        String expectedResult="You successfully clicked an alert";
        WebElement sonucYaziElementi=driver.findElement(By.xpath("//p[@id='result']"));
        String actualResult=sonucYaziElementi.getText();

        Assert.assertEquals(expectedResult,actualResult);

    }

    /*
    Herhangi bir web sitesine gidince veya
    bir websitesinde herhangi bir islem yaptiginizda ortaya cikan uyarilara alert diyoruz

    Eger bir alert inspect yapilabiliyorsa o alert otomasyon ile kullanilabilir.
    Bu tur alertlere html alert denir. ve bunlar icin ekstra bir islem yapmaya gerek yoktur.
    Tum webelementler gibi locate edip istedigimiz islemleri yapabiliriz.

    Ancak web uygulamalarinda html alert yaninda java script alert de bulunabilir
    java script alert ler locate edilemez.
    seleniumda JS alert ler icin cok ozel bir yontem gelistirmistir

     */


}
