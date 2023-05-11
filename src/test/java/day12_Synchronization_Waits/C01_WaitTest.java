package day12_Synchronization_Waits;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.webaudio.WebAudio;

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


}
