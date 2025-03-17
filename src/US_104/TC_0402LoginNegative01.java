package US_104;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_0402LoginNegative01 extends BaseDriver {
    /**
     * Bu Test Senaryosu, geçersiz şifre ile oturum açma girişiminin başarısız olduğunu doğrulamak için hazırlanmıştır.
        This Test Scenario is prepared to verify that the login attempt with an incorrect password fails.
     */
    @Test
    public void TC_0402LoginTest() {
        driver.navigate().to("https://www.akakce.com/");
        Assert.assertEquals("Web sitesine erisim saglanamadi.", "https://www.akakce.com/", driver.getCurrentUrl());
        System.out.println("Anasayfaya başarılı bir şekilde ulaşıldı.");
        MyFunc.sleep(2);

        WebElement login = driver.findElement(By.cssSelector("div[id='H_rl_v8'] :nth-child(2)"));
        login.click();
        System.out.println("Giriş yap butonuna tıklandı.");
        MyFunc.sleep(2);

        WebElement fakeEmail = driver.findElement(By.cssSelector("div[id='L_h_v8'] :nth-child(4) input"));
        fakeEmail.sendKeys("cigeyab754@erapk.com");
        Assert.assertEquals("E-posta adresi girilemedi.", "cigeyab754@erapk.com", fakeEmail.getAttribute("value"));
        System.out.println("E-posta adresi girildi.");
        MyFunc.sleep(2);

        WebElement incorrectPassword = driver.findElement(By.cssSelector("div[id='L_h_v8'] :nth-child(6) input"));
        incorrectPassword.sendKeys("HataliSifre123");
        Assert.assertEquals("Şifre girilemedi.", "HataliSifre123", incorrectPassword.getAttribute("value"));
        System.out.println("Gecersiz Şifre girildi.");
        MyFunc.sleep(2);

        WebElement loginButton = driver.findElement(By.cssSelector("div[id='L_h_v8'] :nth-child(10)"));
        loginButton.click();
        System.out.println("Giriş yap butonuna tıklandı.");
        MyFunc.sleep(2);

        WebElement errorMessage=driver.findElement(By.cssSelector("div#m-w p"));
        Assert.assertEquals("Hatalı şifre girişi yapılmasına rağmen hata mesajı görüntülenemedi","Şifre doğru değil. Lütfen kontrol edip yeniden deneyin.",errorMessage.getText());
        System.out.println("Hatali sifre girisi yapildi ve hata mesaji goruntulendi");

        WaitAndClose();
    }
}
