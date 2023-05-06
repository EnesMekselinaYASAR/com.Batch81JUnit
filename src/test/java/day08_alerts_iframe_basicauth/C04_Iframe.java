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

public class C04_Iframe {
    /*
    bir method oluşturun: iframetest
    *An IFrame containing... ." textinin erişilebilir olduğunu test edin ve konsolda yazdırın
    *text box'a  "Merhaba Dunya!" yazın.
    *Text Box'ın altında bulunan "Elemental Selenium" linkinin textinin görünür olduğunu doğrulayın ve konsolda yazdırın
    */

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
        //driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement baslikElement=driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(baslikElement.isEnabled());
        System.out.println(baslikElement.getText()); // An iFrame containing the TinyMCE WYSIWYG Editor

        // *text box'a  "Merhaba Dunya!" yazın.
        //*text box'ı doğru locate etmemize rağmen driver bulamadı
        //bunun üzerine html kodlarını incelediğimizde  text box'ın aslında bir iframe içerisinde olduğunu gördük
        //bu durumda önce iframe i locate edip switchTo ile o iframe e geçmeliyiz.

        WebElement iframeWebElement=driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframeWebElement);
        WebElement textKutusu= driver.findElement(By.className("mce-content-body"));
        textKutusu.click();
        textKutusu.clear();
        Thread.sleep(3000);
        textKutusu.sendKeys("Merhaba Dunya!");

        Thread.sleep(5000);

        //*Text Box'ın altında bulunan "Elemental Selenium" linkinin textinin görünür olduğunu doğrulayın ve konsolda yazdırın

        //Link yazı elementini doğru olmasına ragmen yazdırmadı, çünkü yukarıda ifram'e geçis yapmıştık
        // bu durumda önce iframe i locate edip switchTo ile o iframe e geçmeliyiz.
        driver.switchTo().defaultContent();

        WebElement linkYaziElementi=driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(linkYaziElementi.isDisplayed());
        System.out.println(linkYaziElementi.getText()); // Elemental Selenium

         /*
        iframe den çıkmak için 2 komut vardır.
        *driver.switchTo().parentFrame();-->1 üst seviiyedeki frame' e çıkartır.
        *driver.switchTo().defaultContent();-->En üstteki frame'e çıkmak için kullanılır.
         */


    }
        /*
        Bir web sitesinde bir video(youtube vs) varsa <iframe> tag'i içerisindeyse bu video'yu direkt locate edip çalıştırmak dinamik olmaz.
        Çünkü link değişebilir ve locate'imiz çalışmaz.
        Bunun için bütün frame'leri bir array liste atıp index ile frame'i seçip sonrasında play tuşunu locate edip çalıştırabiliriz.
        */
}
