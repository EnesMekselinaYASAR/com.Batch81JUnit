package day11_faker_file;

import Utilities.TestBase;
import org.junit.Test;

public class C02_KeyboardActions extends TestBase {
        /*
        1.https://html.com/tags/iframe/ sayfasına gidelim
        2.videoyu görecek kadar aşağıya in
        3.videoyu izlemek için play tuşuna basın
        4.videoyu çalıştırdığınızı test edin
        */
    @Test
    public void keyboardActionsTest(){
        driver.get("https://html.com/tags/iframe/");

    }
}
