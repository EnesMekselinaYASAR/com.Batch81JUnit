package day11_faker_file;

import Utilities.TestBase;
import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C01_Faker extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        // 1- https://www.facebook.com adresine gidelim.
        driver.get("https://www.facebook.com");
        Actions actions = new Actions(driver);
        Faker faker=new Faker();


        // 2- Yeni hesap olustur butonuna basalim.
        WebElement account = driver.findElement(By.xpath("(//a[@role='button'])[2]"));
        account.click();

        // 3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim.
        WebElement name = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
        String fakeMail=faker.internet().emailAddress();
        actions.click(name)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(fakeMail)
                .sendKeys(Keys.TAB)
                .sendKeys(fakeMail)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("29")
                .sendKeys(Keys.TAB)
                .sendKeys("Haz")
                .sendKeys(Keys.TAB)
                .sendKeys("1995")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.RIGHT)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

        Thread.sleep(3000);
    }
}
