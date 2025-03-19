package US_107;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_0702DeleteAccountNegative extends BaseDriver {
    /**<pre>
     *  --> Bu test senaryosunda, akakce.com sitesinde daha önce oluşturulmuş ve doğrulanmış bir hesaba giriş
     *  yapmadan hesap silme işleminin gerçekleştirilemez. Hesaba giris yapilarak silme islemi sirasinda
     *  sorulan sifre alanina yanlis sifre girilerek silinme yapilamadigini dogrulamaktadir.
     *
     *  --> In this test scenario, it is verified that the account deletion process cannot be performed without
     *  logging into a previously created and verified account on akakce.com. Additionally, it is confirmed
     *  that the account cannot be deleted when an incorrect password is entered in the password field during
     *  the deletion process after logging in.</pre>*/
    @Test
    public void TC_0702DeleteAccountNegativeTest() {
        driver.get("https://www.akakce.com/");
        System.out.println("Akakce.com sitesine gidildi.");
        MyFunc.sleep(2);

        WebElement login = driver.findElement(By.cssSelector("div[id='H_rl_v8']>:nth-child(2)"));
        login.click();
        MyFunc.sleep(2);
        System.out.println("Login butonuna tiklandi.");

        WebElement email = driver.findElement(By.cssSelector("input[id='lifrd'] +label+span>input"));
        email.sendKeys("akakce128@gmail.com");
        System.out.println("Email adresi girildi.");
        MyFunc.sleep(1);

        WebElement password = driver.findElement(By.cssSelector("input[id='lifrd'] +label+span+label+span>input"));
        password.sendKeys("Abcd.1234");
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

        WebElement deleteMyAccountButton = driver.findElement(By.cssSelector("ul[id='AL'] :nth-child(5)"));
        deleteMyAccountButton.click();
        System.out.println("Hesap sil butonuna tiklandi.");
        MyFunc.sleep(2);

        WebElement incorrectPassword = driver.findElement(By.cssSelector("#p"));
        incorrectPassword.sendKeys("gecersizşifre123456");
        System.out.println("Hatali sifre girildi.");
        MyFunc.sleep(2);

        WebElement deleteMyAccountButton1 = driver.findElement(By.cssSelector("input[id='a'] +span+span>input"));
        deleteMyAccountButton1.click();
        System.out.println("Hesap sil butonuna tiklandi.");

        WebElement errorMessage = driver.findElement(By.cssSelector("div[id='m-w'] p"));
        MyFunc.sleep(2);
        System.out.println("Hata mesaji goruntulendi.");
        Assert.assertEquals("Sifre hatali girilmis olmasina ragmen hata mesaji goruntulenmedi.", "Mevcut şifrenizi doğru girdiğinizden emin olun.", errorMessage.getText());
        System.out.println("Hatali sifre girildi ve Hesap silme işlemi başarısız oldu. Hata mesajı doğrulandı.");

        WaitAndClose();
    }
}
