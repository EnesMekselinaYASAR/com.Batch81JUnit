package day14_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {
    @Test
    public void readExcelTesti() throws IOException {
        /*
        input olarak verilen :
        satırNo,sutunNo değerlerini parametre olarak alıp
        o cell'deki datayı String olarak bana döndüren bir method oluşturalım
         */

        int satirNo=12;
        int sutunNo=2;

        // donen String'in Baku oldugunu test edin
        String expectedData="Baku";

        String actualData=banaDataGetir(satirNo-1,sutunNo-1);
        Assert.assertEquals(expectedData,actualData);
    }

    private String banaDataGetir(int satirIndex, int sutunIndex) throws IOException {
        String istenenData="";
        String dosyaYolu="src/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
        istenenData=workbook
                .getSheet("Sayfa1")
                .getRow(satirIndex)
                .getCell(sutunIndex)
                .toString();

        return istenenData;

    }
}
