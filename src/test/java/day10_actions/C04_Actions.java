package day10_actions;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C04_Actions extends TestBase {
    /*
    1.https://demoqa.com/droppable adresine gidelim
    2. “Drag me” butonunu tutup “Drop here” kutusunun ustune
    3.“Drop here” yazisi yerine “Dropped!” oldugunu test edin
    */

    @Test
    public void test01(){
        driver.get("https://demoqa.com/droppable");

        Actions actions=new Actions(driver);
        WebElement dragMe=driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropHere=driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        actions.dragAndDrop(dragMe,dropHere).perform();

        String expectedYazi="Dropped!";
        String actualYazi= driver.findElement(By.xpath("//*[text()='Dropped!']")).getText();
        Assert.assertEquals(expectedYazi,actualYazi);
    }
}
