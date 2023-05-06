package day08_alerts_iframe_basicauth;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
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
        driver.close();
    }

    @Test
    public void test01(){

    }
}
