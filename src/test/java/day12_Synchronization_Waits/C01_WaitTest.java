package day12_Synchronization_Waits;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.webaudio.WebAudio;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C01_WaitTest extends TestBase {
    /*
    iki method oluşturun implicitWait(),explicitWait()
    iki method için aşağıdaki adımları test edin

    1.https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    2.Remove butonuna basin.
    3.“It’s gone!” mesajinin goruntulendigini dogrulayin.
    4.Add buttonuna basin
    5.It’s back mesajinin gorundugunu test edin
    */

    @Test
    public void implicitWaitTesti(){

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        WebElement itsGoneYaziELementi=driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));

        Assert.assertTrue(itsGoneYaziELementi.isDisplayed());

        driver.findElement(By.xpath("//button[text()='Add']")).click();

        WebElement itsBackYaziElementi=driver.findElement(By.xpath("//p[text()=\"It's back!\"]"));

        Assert.assertTrue(itsBackYaziElementi.isDisplayed());
    }

    @Test
    public void explicitlyWaitTesti(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        /*
        WebElement itsGoneYaziElementi=driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));
        wait.until(ExpectedConditions.visibilityOf(itsGoneYaziElementi));
        Assert.assertTrue(itsGoneYaziElementi.isDisplayed());
        */

        /*
        explicitWait itsgoneWE görünür olmasını beklerken o web elementinin locatini kullanarak assert yapmak
        sorun olur ve exeption fırlatır. Henüz görülmeyen bir Webelementin locate edilmeside otamasyon için
        mümkün olmayabilir.
        (HTML kodları yazan developer farklı uygulamalar yapabilir).Bu durumda bekleme işlemi için explicitWait'i locate ile birlikte kullanırız.
        */

        WebElement itsGoneYaziElementi=wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//p[text()=\"It's gone!\"]")));
        Assert.assertTrue(itsGoneYaziElementi.isDisplayed());

        driver.findElement(By.xpath("//button[text()='Add']")).click();
        WebElement itsBackYaziElementi=wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//p[text()=\"It's back!\"]")));
        Assert.assertTrue(itsBackYaziElementi.isDisplayed());
    }
}
