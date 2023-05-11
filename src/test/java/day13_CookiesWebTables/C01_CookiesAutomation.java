package day13_CookiesWebTables;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class C01_CookiesAutomation extends TestBase {
     /*
    1-Amazon anasayfaya gidin
    2-tum cookie’leri listeleyin
    3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
    4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
    5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
    6-eklediginiz cookie’nin sayfaya eklendigini test edin
    7-ismi skin olan cookie’yi silin ve silindigini test edin
    8-tum cookie’leri silin ve silindigini test edin
    */

    @Test
    public void cookieTest01(){
        driver.get("https://www.amazon.com");
        Set<Cookie> cookiesSet=driver.manage().getCookies();
        System.out.println(cookiesSet);

        int sayac=1;
        for (Cookie each:cookiesSet
             ) {
            System.out.println(sayac+ " .ci cookie: "+ each);
            System.out.println("name : "+each.getName());
            System.out.println("value : "+each.getValue());
            sayac++;
        }

        int cookieSayisi=cookiesSet.size();
        Assert.assertTrue(cookieSayisi>5);

        for (Cookie each:cookiesSet
             ) {
            if (each.getName().equals("i18n-prefs")){
                Assert.assertEquals("USD",each.getValue());
            }
        }

        Cookie cookie=new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(cookie);

        cookiesSet=driver.manage().getCookies();

        sayac=1;
        for (Cookie each:cookiesSet
        ) {
            System.out.println(sayac+ " .ci cookie: "+ each);
            sayac++;
        }

        Assert.assertTrue(cookiesSet.contains(cookie));
        driver.manage().deleteCookieNamed("skin");
        Assert.assertFalse(cookiesSet.contains("skin"));

        driver.manage().deleteAllCookies();
        cookiesSet=driver.manage().getCookies();
        Assert.assertTrue(cookiesSet.isEmpty());





    }
}
