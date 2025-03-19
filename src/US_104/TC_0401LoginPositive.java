package US_104;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_0401LoginPositive extends BaseDriver {
        /**<pre>
         * --> Bu Test Senaryosu, kullanıcının başarılı bir şekilde oturum açmasını test etmek için hazırlanmıştır.
         *
         * --> This Test Scenario is prepared to test the successful login of the user.</pre>*/
    @Test
    public void TC_0401LoginTest() {
        driver.navigate().to("https://www.akakce.com/");
        Assert.assertEquals("Web sitesine erisim saglanamadi.", "https://www.akakce.com/", driver.getCurrentUrl());
        System.out.println("Anasayfaya başarılı bir şekilde ulaşıldı.");
        MyFunc.sleep(2);

        WebElement login = driver.findElement(By.cssSelector("div[id='H_rl_v8'] :nth-child(2)"));
        login.click();
        System.out.println("Giriş yap butonuna tıklandı.");
        MyFunc.sleep(2);

        WebElement testEmail = driver.findElement(By.cssSelector("div[id='L_h_v8'] :nth-child(4) input"));
        testEmail.sendKeys("cigeyab754@erapk.com");
        Assert.assertEquals("E-posta adresi girilemedi.", "cigeyab754@erapk.com", testEmail.getAttribute("value"));
        System.out.println("E-posta adresi girildi.");
        MyFunc.sleep(1);

        WebElement testPassword = driver.findElement(By.cssSelector("div[id='L_h_v8'] :nth-child(6) input"));
        testPassword.sendKeys("Tz12345678.");
        Assert.assertEquals("Şifre girilemedi.", "Tz12345678.", testPassword.getAttribute("value"));
        System.out.println("Şifre girildi.");
        MyFunc.sleep(1);

        WebElement loginButton = driver.findElement(By.cssSelector("div[id='L_h_v8'] :nth-child(10)"));
        loginButton.click();
        System.out.println("Giriş yap butonuna tıklandı.");
        MyFunc.sleep(1);

        WebElement account = driver.findElement(By.cssSelector("div[id='HM_v8'] > :nth-child(1) a"));
        Assert.assertEquals("Oturum açılamadı.", "TestName", account.getText());
        System.out.println("Oturum başarılı bir şekilde açıldı.");

        WaitAndClose();
    }
}
