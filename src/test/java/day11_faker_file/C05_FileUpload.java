package day11_faker_file;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C05_FileUpload extends TestBase {
    /*
    -https://the-internet.herokuapp.com/upload sayfasına git
    -chooseFile butonuna basalım.
    -Yüklemek istediğimiz dosyayı seçelim*(Bu işlemi selenium ile yapma şansımız yok)

   **
   Çünkü web tabanlı bir uygulama değil. sendKeys methodu imdadımıza yetişir.
   eğer chooseFile butonun var olan bi dosyanın dosya yolunu yollarsanız
   seçme işlemi otomatik olarak yapılmış olacaktır.

   **

    -Upload butonuna basalım
    -"File Uploaded!" textinin görüntülendiğini test edelim.
     */

    @Test
    public void uploadTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonunu locate ettik.
        WebElement dosyaSecButonu = driver.findElement(By.id("file-upload"));

        //2.adım yükelencek dosyanın dosya yolunu oluşturalım
        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\Desktop\\text.txt";

        String yüklenecekDosya = farkliKisim + ortakKisim;

        //3.Adım: sendKeys ile dosya yolunu, seçme butonuna yollayalım
        dosyaSecButonu.sendKeys(yüklenecekDosya);

        //upload butonuna basalım
        driver.findElement(By.className("button")).click();


        // -"File Uploaded!" textinin görüntülendiğini test edelim.
        WebElement yazıElementi = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(yazıElementi.isDisplayed());

        Thread.sleep(5000);

    }

}
