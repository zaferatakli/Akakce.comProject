package US_103;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;



public class US_103 extends BaseDriver {
    @Test
    public void TC_0301 (){
        // 1. Akakce.com'u aç
        driver.get("https://www.akakce.com");
        MyFunc.sleep(3);

        // 2. "Giriş Yap" linkine tıkla
        WebElement girisYapLink = driver.findElement(By.cssSelector("div[id =H_rl_v8] > a:nth-child(2)"));
        girisYapLink.click();
        MyFunc.sleep(3);

        // 3. Kullanıcı adı ve şifreyi gir, giriş yap
        WebElement emailField=driver.findElement(By.cssSelector("input[id='life']"));
        emailField.sendKeys("sibeloztemel31@gmail.com");
        WebElement passwordField=driver.findElement(By.cssSelector("input[id='lifp']"));
        passwordField.sendKeys("Sibel5742");
        WebElement loginButton=driver.findElement(By.cssSelector("input[id='lfb']"));
        loginButton.click();

        //4. Giriş dogrulaması
        WebElement checkLogin=driver.findElement(By.cssSelector("div[id='HM_v8']>i>a"));
        Assert.assertTrue("Giriş yapılamadı",checkLogin.getText().equals("Sibel"));

        //5."Çıkış Yap" butonuna tıkla
        checkLogin=driver.findElement(By.cssSelector("a[id='H_a_v8']"));
        checkLogin.click();
        WebElement logoutButton = driver.findElement(By.cssSelector("div[id='HM_v8']>ul>li:nth-child(6)>a"));
        logoutButton.click();

        MyFunc.sleep(3);












        WaitAndClose();
    }

}
