package day11_faker_file;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {
    @Test
    public void test01(){
        System.out.println(System.getProperty("user.dir"));
        // bana içinde olduğum projenin yolunu(path) ini verir---> C:\Users\enesm\IdeaProjects\com.Batch81JUnit

        System.out.println(System.getProperty("user.home"));
        // C:\Users\enesm ----> yani benim bilgisayarımın bana özel kısmını verdi

        //masaüstümüzdeki text dosyasının varlığını test edelim
        // "C:\Users\enesm\Desktop\text.txt"
        String dosyaYolu=System.getProperty("user.home")+ "\\Desktop\\text.txt";
        System.out.println(dosyaYolu); // C:\Users\enesm\Desktop\text.txt

         /*
        bilgisayramızdaki bir dosyanın varlığını test etmemiz için once o dosyaya ulaşmamız gerekir

        Javada dosya erişimi için dosya yoluna (path) ihtiyaç vardır.

        Her bilgisayarın kullanıcı adı farklı olacağından masaustu dosya yolu birbirinden farklı olacaktır

        Testlerimizn tüm bilgisayarlarda çalışması için dosya yolunu dinamik yapmak zorundayız.

        Bunun için
            her bilgisayarın birbirinden farklı olan yolunu bulmak adına;
        */
        String farkliKisim = System.getProperty("user.home");

        // herkesin bilgisayarında ortak olan kısım ise
        String ortakKisim = "\\Desktop\\text.txt";

        String masaustuDosyaYolu = farkliKisim + ortakKisim;

        System.out.println(Files.exists(Paths.get(masaustuDosyaYolu))); // true
        //text.txt masaustunde böyle bir dosyanın olup olmadığını kontrol ediyor.

        Assert.assertTrue(Files.exists(Paths.get(masaustuDosyaYolu))); // Tests passed


    }


}
