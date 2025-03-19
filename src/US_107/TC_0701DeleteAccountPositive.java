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
        System.out.println("Akakce.com sitesine gidildi.");

        WebElement loginButton = driver.findElement(By.cssSelector("div[id='H_rl_v8']>:nth-child(2)"));
        loginButton.click();
        System.out.println("Login butonuna tiklandi.");
        MyFunc.sleep(2);

        WebElement email = driver.findElement(By.cssSelector("input[id='lifrd'] +label+span>input"));
        email.sendKeys("akakce128@gmail.com");
        System.out.println("Email adresi girildi.");
        MyFunc.sleep(2);

        WebElement password = driver.findElement(By.cssSelector("input[id='lifrd'] +label+span+label+span>input"));
        password.sendKeys("Abcd.1234");
        System.out.println("Sifre girildi.");
        MyFunc.sleep(2);

        WebElement login = driver.findElement(By.cssSelector("#lfb"));
        login.click();
        System.out.println("Login butonuna tiklandi.");
        MyFunc.sleep(2);

        WebElement accountName = driver.findElement(By.cssSelector("div[id='HM_v8'] :nth-child(2)"));
        accountName.click();
        System.out.println("Kullanici butonuna tiklandi.");
        MyFunc.sleep(2);

        WebElement myAccount = driver.findElement(By.cssSelector(" li[id='HM_p_v8'] +li+li+li+li>a"));
        myAccount.click();
        System.out.println("Hesabim butonuna tiklandi.");
        MyFunc.sleep(2);

        WebElement deleteMyAccountButtonCheck = driver.findElement(By.cssSelector("ul[id='AL'] :nth-child(5)"));
        Assert.assertEquals("Hesap sil butonu goruntulenemedi.", "Hesabımı Sil", deleteMyAccountButtonCheck.getText());
        System.out.println("Hesap sil butonu goruntulendi.");
        MyFunc.sleep(2);

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
