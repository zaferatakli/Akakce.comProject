package US_105;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_0501Order extends BaseDriver {
        /**<pre>
         * --> Bu test senaryosunda akakce.com sitesine gidilerek login işlemi yapılır ve login işlemi sonrası profil
         * sayfasına gidilerek sipariş listesi kontrol edilir.
         *
         * --> In this test scenario, the login process is performed by navigating to the akakce.com website.After logging in,
         * the profile page is accessed, and the order list is checked.</pre>*/
    @Test
    public void TC_0501OrderTest() {
        driver.navigate().to("https://www.akakce.com/");

        Assert.assertEquals("Yanlış sayfaya gidildi!", "https://www.akakce.com/", driver.getCurrentUrl());
        System.out.println("AKAKÇE doğru şekilde yüklendi.");
        MyFunc.sleep(2);

        WebElement login = driver.findElement(By.cssSelector("div[id='H_rl_v8'] a+a"));
        login.click();
        System.out.println("GİRİŞ butonuna clicklendi.");
        MyFunc.sleep(2);

        WebElement loginPageCheck = driver.findElement(By.cssSelector("#FrmLi > label:nth-child(3)"));
        Assert.assertEquals("Giriş sayfasına erişilemedi.", "Eposta", loginPageCheck.getText());
        System.out.println("Giriş sayfasına başarılı bir şekilde ulaşıldı.");
        MyFunc.sleep(2);

        WebElement inbox = driver.findElement(By.cssSelector("div[id='L_h_v8'] > form > span > input[id='life']"));
        inbox.sendKeys("fosan56532@bankrau.com");
        Assert.assertEquals("E-POSTA girilemedi", "fosan56532@bankrau.com", inbox.getAttribute("value"));
        System.out.println("E-POSTA duğru şekilde girildi.");
        MyFunc.sleep(1);

        WebElement passwordBox = driver.findElement(By.cssSelector("div[id='L_h_v8'] > form > span > input[id='lifp']"));
        passwordBox.sendKeys("WKC-7ah-9Da-xez");
        System.out.println("ŞİFRE girildi.");
        MyFunc.sleep(1);

        WebElement loginButton = driver.findElement(By.cssSelector("div[id='L_h_v8'] > form >input[id='lfb']"));
        loginButton.click();
        System.out.println("GİRİŞ butonu CLICK");
        MyFunc.sleep(1);
        Assert.assertEquals("Yanlış sayfaya gidildi!", "https://www.akakce.com/", driver.getCurrentUrl());
        System.out.println("ANA SAYFA doğru şekilde yüklendi.");
        MyFunc.sleep(1);

        WebElement account = driver.findElement(By.cssSelector("div[id='HM_v8']>i>a"));
        account.click();
        System.out.println("HESABA CLICK'lendi");
        MyFunc.sleep(1);

        Assert.assertEquals("Yanlış sayfaya gidildi!", "https://www.akakce.com/akakcem/", driver.getCurrentUrl());
        System.out.println("HESABIM sayfası yüklendi.");
        MyFunc.sleep(1);

        WebElement myOrders = driver.findElement(By.cssSelector("a[href='/akakcem/siparislerim/']"));
        myOrders.click();
        System.out.println("SİPARİŞLERİM CLICK'lendi");
        MyFunc.sleep(1);

        Assert.assertEquals("Yanlış sayfaya gidildi!", "https://www.akakce.com/akakcem/siparislerim/", driver.getCurrentUrl());
        System.out.println("SİPARİŞLERİM sayfası yüklendi.");
        MyFunc.sleep(1);

        WebElement orderControl = driver.findElement(By.cssSelector("div[id='user-order-info'] div"));
        Assert.assertTrue("Aranılan mesaj bulunamadı", orderControl.getText().contains("Kayıtlı siparişiniz bulunmuyor."));
        System.out.println("Sipariş olmadığı doğrulandı.");

        WaitAndClose();
    }
}
