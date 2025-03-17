package US_106;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_0501Siparis extends BaseDriver {
    /**
     * <pre>
     * Bu Code AKAKÇE PROJE US_105 için yazılmıştır.
     * Sipariş listesi kontrolü amaçlıdır.
     * 1- AKAKÇE sayfasına <a href="https://www.akakce.com">https://www.akakce.com</a> giriş yapılır.
     * 2- Giriş yapılır.
     * 3- Hesabım sayfasına gidilir.
     * 4- Siparişlerim sayfasına gidilir.
     * 5- "Kayıtlı siparişiniz bulunmuyor." mesajı görülür.</pre>
     */
    @Test
    public void TC_0501SiparisTest() {

        //AKAKÇE sayfasına yönlendirildi.
        driver.navigate().to("https://www.akakce.com/");
        //Sayfa kontrolü,
        Assert.assertEquals("Yanlış sayfaya gidildi!", "https://www.akakce.com/", driver.getCurrentUrl());
        System.out.println("AKAKÇE doğru şekilde yüklendi.");
        MyFunc.sleep(1);

        // Giriş Butonuna CLİCK
        WebElement girisBotonu = driver.findElement(By.cssSelector("div[id='H_rl_v8'] a+a"));
        girisBotonu.click();
        System.out.println("GİRİŞ butonuna clicklendi.");
        MyFunc.sleep(1);
        // Giriş sayfası kontrolü.
        Assert.assertEquals("Yanlış sayfaya gidildi!", "https://www.akakce.com/akakcem/giris/", driver.getCurrentUrl());
        System.out.println("GİRİŞ sayfası yüklendi.");
        MyFunc.sleep(1);

        // E-posta girişi
        WebElement epostaKutusu = driver.findElement(By.cssSelector("div[id='L_h_v8'] > form > span > input[id='life']"));
        epostaKutusu.sendKeys("fosan56532@bankrau.com");
        // E-posta giriş kontrolü
        Assert.assertEquals("E-POSTA girilemedi", "fosan56532@bankrau.com", epostaKutusu.getAttribute("value"));
        System.out.println("E-POSTA duğru şekilde girildi.");
        MyFunc.sleep(1);

        // Şifre girişi
        WebElement sifreKutusu = driver.findElement(By.cssSelector("div[id='L_h_v8'] > form > span > input[id='lifp']"));
        sifreKutusu.sendKeys("WKC-7ah-9Da-xez");
        System.out.println("ŞİFRE girildi.");
        MyFunc.sleep(1);

        // Giriş Butonuna CLİCK
        WebElement girisYapBotonu = driver.findElement(By.cssSelector("div[id='L_h_v8'] > form >input[id='lfb']"));
        girisYapBotonu.click();
        System.out.println("GİRİŞ butonu CLICK");
        MyFunc.sleep(1);
        Assert.assertEquals("Yanlış sayfaya gidildi!", "https://www.akakce.com/", driver.getCurrentUrl());
        System.out.println("ANA SAYFA doğru şekilde yüklendi.");
        MyFunc.sleep(1);

        // Hesap CLICK
        WebElement hesapButonu = driver.findElement(By.cssSelector("div[id='HM_v8']>i>a"));
        hesapButonu.click();
        System.out.println("HESABA CLICK'lendi");
        MyFunc.sleep(1);
        // Hesabım sayfası giriş sayfası kontrolü.
        Assert.assertEquals("Yanlış sayfaya gidildi!", "https://www.akakce.com/akakcem/", driver.getCurrentUrl());
        System.out.println("HESABIM sayfası yüklendi.");
        MyFunc.sleep(1);

        // Siparişlerim CLICK
        WebElement siparislerimButonu = driver.findElement(By.cssSelector("a[href='/akakcem/siparislerim/']"));
        siparislerimButonu.click();
        System.out.println("SİPARİŞLERİM CLICK'lendi");
        MyFunc.sleep(1);
        // Hesabım sayfası giriş sayfası kontrolü.
        Assert.assertEquals("Yanlış sayfaya gidildi!", "https://www.akakce.com/akakcem/siparislerim/", driver.getCurrentUrl());
        System.out.println("SİPARİŞLERİM sayfası yüklendi.");
        MyFunc.sleep(1);

        // Sipariş kontrol
        WebElement kontrol = driver.findElement(By.cssSelector("div[id='user-order-info'] div"));
        Assert.assertTrue("Aranılan mesaj bulunamadı", kontrol.getText().contains("Kayıtlı siparişiniz bulunmuyor."));
        System.out.println("Sipariş olmadığı doğrulandı.");

        WaitAndClose();
    }
}
