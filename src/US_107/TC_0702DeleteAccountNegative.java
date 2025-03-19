package US_107;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_0702DeleteAccountNegative extends BaseDriver {
    /**
     *Bu test senaryosunda, akakce.com sitesinde daha önce oluşturulmuş ve doğrulanmış bir hesaba giriş
     *  yapmadan hesap silme işleminin gerçekleştirilemez. Hesaba giris yapilarak silme islemi sirasinda
     *  sorulan sifre alanina yanlis sifre girilerek silinme yapilamadigini dogrulamaktadir.
     *  In this test scenario, it is verified that the account deletion process cannot be performed without
     *  logging into a previously created and verified account on akakce.com. Additionally, it is confirmed
     *  that the account cannot be deleted when an incorrect password is entered in the password field during
     *  the deletion process after logging in.
     */
    @Test
    public void TC_0702DeleteAccountNegativeTest() {
        driver.get("https://www.akakce.com/");

        WebElement loginButton = driver.findElement(By.cssSelector("div[id='H_rl_v8']>:nth-child(2)"));
        loginButton.click();
        MyFunc.sleep(3);

        WebElement email = driver.findElement(By.cssSelector("input[id='lifrd'] +label+span>input"));
        email.sendKeys("akakce128@gmail.com");
        MyFunc.sleep(3);

        WebElement password = driver.findElement(By.cssSelector("input[id='lifrd'] +label+span+label+span>input"));
        password.sendKeys("Abcd.1234");
        MyFunc.sleep(3);

        WebElement login = driver.findElement(By.cssSelector("#lfb"));
        login.click();
        MyFunc.sleep(3);

        WebElement userButton = driver.findElement(By.cssSelector("div[id='HM_v8'] :nth-child(2)"));
        userButton.click();
        MyFunc.sleep(3);

        WebElement myAccountButton = driver.findElement(By.cssSelector(" li[id='HM_p_v8'] +li+li+li+li>a"));
        myAccountButton.click();
        MyFunc.sleep(3);

        WebElement deleteMyAccountButton = driver.findElement(By.cssSelector("ul[id='AL'] :nth-child(5)"));
        deleteMyAccountButton.click();
        MyFunc.sleep(3);

        WebElement incorrectPassword = driver.findElement(By.cssSelector("#p"));
        incorrectPassword.sendKeys("gecersizşifre123456");
        MyFunc.sleep(3);

        WebElement deleteMyAccountButton1 = driver.findElement(By.cssSelector("input[id='a'] +span+span>input"));
        deleteMyAccountButton1.click();

        WebElement errorMessage = driver.findElement(By.cssSelector("div[id='m-w'] p"));
        MyFunc.sleep(3);
        Assert.assertEquals("hatalı şifre", "Mevcut şifrenizi doğru girdiğinizden emin olun.", errorMessage.getText());

        WaitAndClose();
    }
}
