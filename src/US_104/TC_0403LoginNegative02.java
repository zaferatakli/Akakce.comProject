package US_104;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_0403LoginNegative02 extends BaseDriver {
        /**
         * Bu Test Senaryosu, geçersiz bir e-posta adresiyle oturum açma girişiminin reddedildiğini test etmek için hazırlanmıştır.
         * This Test Scenario is prepared to test that the login attempt with an invalid email address is rejected.
         */
    @Test
    public void TC_0403LoginTest() {
        driver.navigate().to("https://www.akakce.com/");
        Assert.assertEquals("Web sitesine erisim saglanamadi.", "https://www.akakce.com/", driver.getCurrentUrl());
        System.out.println("Anasayfaya başarılı bir şekilde ulaşıldı.");
        MyFunc.sleep(2);

        WebElement login = driver.findElement(By.cssSelector("div[id='H_rl_v8'] :nth-child(2)"));
        login.click();
        System.out.println("Giriş yap butonuna tıklandı.");
        MyFunc.sleep(2);

        WebElement incorrectEmail = driver.findElement(By.cssSelector("div[id='L_h_v8'] :nth-child(4) input"));
        incorrectEmail.sendKeys("hatali@email.com");
        Assert.assertEquals("Hatali e-posta adresi girilemedi.", "hatali@email.com", incorrectEmail.getAttribute("value"));
        System.out.println("Gecersiz e-posta adresi girildi.");
        MyFunc.sleep(2);

        WebElement correctPassword = driver.findElement(By.cssSelector("div[id='L_h_v8'] :nth-child(6) input"));
        correctPassword.sendKeys("Tz12345678.");
        Assert.assertEquals("Şifre girilemedi.", "Tz12345678.", correctPassword.getAttribute("value"));
        System.out.println("Şifre girildi.");
        MyFunc.sleep(2);

        WebElement loginButton = driver.findElement(By.cssSelector("div[id='L_h_v8'] :nth-child(10)"));
        loginButton.click();
        System.out.println("Giriş yap butonuna tıklandı.");
        MyFunc.sleep(2);

        WebElement errorMessage=driver.findElement(By.cssSelector("div#m-w p"));
        Assert.assertEquals("Hatali e-posta adresi girilmesine ragmen hata mesaji gorulmedi.","Bu e-postaya kayıtlı bir hesap bulunamadı.",errorMessage.getText());
        System.out.println("Hatali e-posta adresi girildi ve hata mesaji goruntulendi.");

        WaitAndClose();
    }
}
