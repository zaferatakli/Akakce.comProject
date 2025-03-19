package US_106;
import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_0601MessageBoxCheck extends BaseDriver {
        /**<pre>
         * --> Bu test senaryosunda akakce.com sitesine gidilerek login işlemi yapılır ve login işlemi sonrası profil
         * sayfasına gidilirek mesaj kutusu kontrolü sağlanır.
         *
         * --> In this test scenario, the login process is performed by navigating to the akakce.com website.After logging in,
         * the profile page is accessed, and the message box is checked.</pre>*/
    @Test
    public void mesajKutusuKontrolü() {
        driver.get("https://www.akakce.com/");
        Assert.assertEquals("Web sitesine erişim sağlanamadı...", "https://www.akakce.com/", driver.getCurrentUrl());
        System.out.println("Anasayfaya başarılı bir şekilde ulaşıldı");

        WebElement loginButton = driver.findElement(By.cssSelector("div[id='H_v8']>header>div+div>div>a+a"));
        loginButton.click();
        System.out.println("Login butonuna tıklandı");
        MyFunc.sleep(2);

        WebElement email = driver.findElement(By.cssSelector("div[id='L_h_v8']>h2+form>span>input"));
        email.sendKeys("noxomo9201@erapk.com");
        System.out.println("Email girildi");
        MyFunc.sleep(1);

        WebElement password = driver.findElement(By.cssSelector("div[id='L_h_v8']>h2+form>span+label+span>input"));
        password.sendKeys("Test12345");
        System.out.println("Şifre girildi");
        MyFunc.sleep(1);

        WebElement loginBtn = driver.findElement(By.cssSelector("div[id='L_h_v8']>h2+form>span+label+span+span+label+a+input"));
        loginBtn.click();
        System.out.println("Login butonuna tıklandı");
        MyFunc.sleep(1);

        WebElement profile = driver.findElement(By.cssSelector("div[class='g-3_v8 hm_hp_v8']>span+div>i"));
        profile.click();
        System.out.println("Profil sayfasına gidildi");
        MyFunc.sleep(1);

        WebElement messageButton = driver.findElement(By.cssSelector("div[class='wbb_v8']>span+div+span+ul>li>b+a+a"));
        messageButton.click();
        System.out.println("Mesaj butonuna tıklandı");
        MyFunc.sleep(2);

        WebElement message = driver.findElement(By.cssSelector("div[id='C4w']>style+div>p"));
        Assert.assertTrue("Mesaj kutusu açılmadı...", message.getText().contains("Listelenecek mesaj bulunamadı."));
        System.out.println("Mesaj kutusu kontrolü başarılı");

        WaitAndClose();
    }
}
