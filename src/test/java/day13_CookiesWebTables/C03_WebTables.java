package day13_CookiesWebTables;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C03_WebTables extends TestBase {
    @Test
    public void dinamikYazici(){
        // onceki class'daki adrese gidip
        // girisYap Method'unu kullanarak sayfaya giris yapin
        // input olarak verilen satir sayisi ve sutun sayisina sahip
        // cell'deki text'i yazdirin

        int satir=4;
        int sutun=4;

        girisYap();

        WebElement arananCell=driver.findElement(By.xpath("//tbody//tr["+satir+"]//td["+sutun+"]"));
        System.out.println(arananCell.getText());
    }

    public void girisYap() {
        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.xpath("//button[@id='details-button']")).click();
        driver.findElement(By.xpath("//*[text()='www.hotelmycamp.com sitesine ilerle (güvenli değil)']")).click();
        driver.findElement(By.linkText("Log in")).click();
        Actions actions=new Actions(driver);
        WebElement username=driver.findElement(By.id("UserName"));
        actions.click(username).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager1!").
                sendKeys(Keys.ENTER).
                perform();
    }
}
