package US_103;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TC_0301Logout extends BaseDriver {
    /**
     * <pre>
     * --> Bu Test Senaryosu, kullanıcının başarılı bir şekilde cikis yapmasini test etmek için hazırlanmıştır.
     *
     * --> This Test Scenario is designed to test the successful logout of the user.</pre>
     */
    @Test
    public void TC_0301LogoutTest() {
        driver.get("https://www.akakce.com");
        Assert.assertEquals("Web sitesine erisim saglanamadi.", "https://www.akakce.com/", driver.getCurrentUrl());
        System.out.println("Anasayfaya başarılı bir şekilde ulaşıldı.");
        MyFunc.sleep(2);

        WebElement login = driver.findElement(By.cssSelector("div[id =H_rl_v8] > a:nth-child(2)"));
        login.click();
        System.out.println("Giriş yap butonuna tıklandı.");
        MyFunc.sleep(2);

        WebElement loginPageCheck = driver.findElement(By.cssSelector("#FrmLi > label:nth-child(3)"));
        Assert.assertEquals("Giriş sayfasına erişilemedi.", "Eposta", loginPageCheck.getText());
        MyFunc.sleep(2);

        WebElement testEmail = driver.findElement(By.cssSelector("input[id='life']"));
        testEmail.sendKeys("sibeloztemel31@gmail.com");
        Assert.assertEquals("E-posta adresi girilemedi.", "sibeloztemel31@gmail.com", testEmail.getAttribute("value"));
        System.out.println("E-posta adresi girildi.");

        WebElement testPassword = driver.findElement(By.cssSelector("input[id='lifp']"));
        testPassword.sendKeys("Sibel5742");
        Assert.assertEquals("Şifre girilemedi.", "Sibel5742", testPassword.getAttribute("value"));
        System.out.println("Şifre girildi.");

        WebElement loginButton = driver.findElement(By.cssSelector("input[id='lfb']"));
        loginButton.click();
        System.out.println("Giriş yap butonuna tıklandı.");
        MyFunc.sleep(1);

        WebElement accountCheck = driver.findElement(By.cssSelector("div[id='HM_v8']>i>a"));
        Assert.assertEquals("Oturum açılamadı.", "Sibel", accountCheck.getText());
        System.out.println("Oturum başarılı bir şekilde açıldı.");
        MyFunc.sleep(2);

        Actions actions = new Actions(driver);
        WebElement account = driver.findElement(By.cssSelector("div[id='HM_v8']>i>a"));
        actions.moveToElement(account).build().perform();
        WebElement logoutButton = driver.findElement(By.cssSelector("div[id='HM_v8']>ul>li:nth-child(6)>a"));
        logoutButton.click();
        System.out.println("Çıkış yap butonuna tıklandı.");
        MyFunc.sleep(2);

        Assert.assertEquals("Web sitesine erisim saglanamadi.", "https://www.akakce.com/", driver.getCurrentUrl());
        System.out.println("Çıkış işlemi başarılı bir şekilde gerçekleşti.");

        WaitAndClose();
    }
}
