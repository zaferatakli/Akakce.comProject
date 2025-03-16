package US_106;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_0601MesajKutusuKontrolü extends BaseDriver {

    @Test
    public void mesajKutusuKontrolü() {
        driver.get("https://www.akakce.com/");

        WebElement loginButton = driver.findElement(By.cssSelector("div[id='H_v8']>header>div+div>div>a+a"));
        loginButton.click();

        WebElement email = driver.findElement(By.cssSelector("div[id='L_h_v8']>h2+form>span>input"));
        email.sendKeys("noxomo9201@erapk.com");

        WebElement password = driver.findElement(By.cssSelector("div[id='L_h_v8']>h2+form>span+label+span>input"));
        password.sendKeys("Test12345");

        WebElement loginBtn = driver.findElement(By.cssSelector("div[id='L_h_v8']>h2+form>span+label+span+span+label+a+input"));
        loginBtn.click();

        WebElement profile = driver.findElement(By.cssSelector("div[class='g-3_v8 hm_hp_v8']>span+div>i"));
        profile.click();

        WebElement messageButton = driver.findElement(By.cssSelector("div[class='wbb_v8']>span+div+span+ul>li>b+a+a"));
        messageButton.click();

        WebElement message = driver.findElement(By.cssSelector("div[id='C4w']>style+div>p"));

        Assert.assertTrue("Mesaj kutusu açılmadı...", message.getText().contains("Listelenecek mesaj bulunamadı."));

        WaitAndClose();
    }

}
