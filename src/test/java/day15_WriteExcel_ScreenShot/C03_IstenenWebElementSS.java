package day15_WriteExcel_ScreenShot;

import Utilities.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class C03_IstenenWebElementSS extends TestBase {
    @Test
    public void webElementSS() throws IOException {

        // amazona gidip nutella aratalim
        // ve sonuc sayisinin oldugu web elementin fotosunu cekelim

        driver.get("https://www.amazon.com");
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        WebElement sonucYaziElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        File sonucYaziElementSS= new File("target/ekrangoruntuleri/sonucYaziSS.jpeg");
        File temp=sonucYaziElementi.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(temp,sonucYaziElementSS);
    }
}
