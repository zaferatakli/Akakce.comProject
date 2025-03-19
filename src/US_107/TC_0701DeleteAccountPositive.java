package US_107;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_0701DeleteAccountPositive extends BaseDriver {
    /**
     * <pre>
     * --> Bu test senaryosunda akakce.com sitesine gidilerek daha once olusturulmus ve dogrulanmis bir hesabi silme islemi yapilmaktadir.
     *
     * --> In this test scenario, a previously created and verified account is deleted by navigating to the akakce.com website.</pre>
     */
    @Test
    public void TC_0701DeleteAccountPositiveTest() {
        driver.get("https://www.akakce.com/");
        Assert.assertEquals("Web sitesine erisim saglanamadi.", "https://www.akakce.com/", driver.getCurrentUrl());
        System.out.println("Anasayfaya başarılı bir şekilde ulaşıldı.");
        MyFunc.sleep(2);

        WebElement login = driver.findElement(By.cssSelector("div[id='H_rl_v8']>:nth-child(2)"));
        login.click();
        System.out.println("Login butonuna tiklandi.");
        MyFunc.sleep(2);

        WebElement loginPageCheck = driver.findElement(By.cssSelector("#FrmLi > label:nth-child(3)"));
        Assert.assertEquals("Giriş sayfasına erişilemedi.", "Eposta", loginPageCheck.getText());
        System.out.println("Giriş sayfasına başarılı bir şekilde ulaşıldı.");
        MyFunc.sleep(2);

        WebElement testEmail = driver.findElement(By.cssSelector("input[id='lifrd'] +label+span>input"));
        testEmail.sendKeys("akakce128@gmail.com");
        Assert.assertEquals("E-posta adresi girilemedi.", "akakce128@gmail.com", testEmail.getAttribute("value"));
        System.out.println("E-posta adresi girildi.");
        MyFunc.sleep(1);

        WebElement testPassword = driver.findElement(By.cssSelector("input[id='lifrd'] +label+span+label+span>input"));
        testPassword.sendKeys("Abcd.1234");
        System.out.println("Sifre girildi.");
        MyFunc.sleep(1);

        WebElement loginButton = driver.findElement(By.cssSelector("#lfb"));
        loginButton.click();
        System.out.println("Login butonuna tiklandi.");
        MyFunc.sleep(2);

        WebElement accountCheck = driver.findElement(By.cssSelector("div[id='HM_v8'] > :nth-child(1) a"));
        Assert.assertEquals("Oturum açılamadı.", "Zafer", accountCheck.getText());
        System.out.println("Oturum başarılı bir şekilde açıldı.");

        WebElement accountName = driver.findElement(By.cssSelector("div[id='HM_v8'] :nth-child(2)"));
        accountName.click();
        System.out.println("Kullanici butonuna tiklandi.");
        MyFunc.sleep(1);

        WebElement myAccount = driver.findElement(By.cssSelector(" li[id='HM_p_v8'] +li+li+li+li>a"));
        myAccount.click();
        System.out.println("Hesabim butonuna tiklandi.");
        MyFunc.sleep(1);

        WebElement deleteMyAccountButtonCheck = driver.findElement(By.cssSelector("ul[id='AL'] :nth-child(5)"));
        Assert.assertEquals("Hesap sil butonu goruntulenemedi.", "Hesabımı Sil", deleteMyAccountButtonCheck.getText());
        System.out.println("Hesap sil butonu goruntulendi.");

        WebElement deleteMyAccountButton = driver.findElement(By.cssSelector("ul[id='AL'] :nth-child(5)"));
        deleteMyAccountButton.click();
        System.out.println("Hesap sil butonuna tiklandi.");
        MyFunc.sleep(2);

        WebElement enterYourPassword = driver.findElement(By.cssSelector("#p"));
        enterYourPassword.sendKeys("Abcd.1234");
        System.out.println("Sifre girildi.");
        MyFunc.sleep(2);

        WebElement deleteMyAccountButton1 = driver.findElement(By.cssSelector("input[id='a'] +span+span>input"));
        deleteMyAccountButton1.click();
        System.out.println("Hesap sil butonuna tiklandi.");
        MyFunc.sleep(2);
        Assert.assertEquals("Sifre dogru girilmis olmasina ragmen Hesap silme islemi basarisiz oldu, hesap silme mesaji goruntulenmedi.", "Hesabın silindi. Seni tekrar aramızda görmek isteriz.", driver.findElement(By.cssSelector("div[id='m-w'] p")).getText());
        System.out.println("Hesap basarili bir sekilde silindi. ");

        WaitAndClose();
    }
}
