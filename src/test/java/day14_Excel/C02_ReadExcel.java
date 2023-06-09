package day14_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {
    @Test
    public void readExcel() throws IOException {
        /* Dosya yolunu bir String degiskene atayalim
         FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
         Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Sheet objesi olusturun workbook.getSheetAt(index)
         Row objesi olusturun sheet.getRow(index)
        Cell objesi olusturun row.getCell(index)
        3.index'deki satırın  3. indexindeki datanın Cezayir olduğunu test edin.*/

        String dosyaYolu="src/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
        String actualData=workbook
                .getSheet("Sayfa1")
                .getRow(3).getCell(3)
                .toString();
        System.out.println(actualData);
    }
}
