package US_104;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_0404LoginNegative03 extends BaseDriver {
        /**<pre>
         * --> Bu Test Senaryosu, boş (NULL) e-posta ve şifre ile oturum açma girişiminin başarısız olduğunu doğrulamak için hazırlanmıştır.
         *
         * --> This Test Scenario is prepared to verify that the login attempt with a null (empty) email and password fails.</pre>*/
    @Test
    public void TC_0404LoginTest() {
        driver.navigate().to("https://www.akakce.com/");

        Assert.assertEquals("Web sitesine erisim saglanamadi.", "https://www.akakce.com/", driver.getCurrentUrl());
        System.out.println("Anasayfaya başarılı bir şekilde ulaşıldı.");
        MyFunc.sleep(2);

        WebElement login = driver.findElement(By.cssSelector("div[id='H_rl_v8'] :nth-child(2)"));
        login.click();
        System.out.println("Giriş yap butonuna tıklandı.");
        MyFunc.sleep(2);

        WebElement testEmail = driver.findElement(By.cssSelector("div[id='L_h_v8'] :nth-child(4) input"));
        testEmail.sendKeys("");
        Assert.assertEquals("E-posta adresi girilemedi.", "", testEmail.getAttribute("value"));
        System.out.println("E-posta adresi alani bos birakildi.");
        MyFunc.sleep(2);

        WebElement testPassword = driver.findElement(By.cssSelector("div[id='L_h_v8'] :nth-child(6) input"));
        testPassword.sendKeys("");
        Assert.assertEquals("Şifre girilemedi.", "", testPassword.getAttribute("value"));
        System.out.println("Şifre alani bos birakildi.");
        MyFunc.sleep(2);

        WebElement loginButton = driver.findElement(By.cssSelector("div[id='L_h_v8'] :nth-child(10)"));
        loginButton.click();
        System.out.println("Giriş yap butonuna tıklandı.");
        MyFunc.sleep(2);

        WebElement errorMessage=driver.findElement(By.cssSelector("div#m-w p"));
        Assert.assertEquals("E-posta ve sifre alanlari bos birakilmasina ragmen hata mesaji goruntulenmedi.","Lütfen e-posta adresinizi yazın.",errorMessage.getText());
        System.out.println("E-posta ve sifre alanlari bos birakildi ve hata mesaji goruntulendi.");

        WaitAndClose();
    }
}
