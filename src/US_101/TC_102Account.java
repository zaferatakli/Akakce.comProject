package US_101;
import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class TC_102Account extends BaseDriver {
    /*
    Bu senaryoda soyadı kısmı boş bırakılarak hata mesajı alınması sağlanmıştır.
     */
    @Test
    public void TC_0102AccountTest() {
        driver.navigate().to("https://www.akakce.com/");
        MyFunc.sleep(2);
        Assert.assertEquals("Yanlış sayfaya girldi", "https://www.akakce.com/", driver.getCurrentUrl());
        System.out.println("Akakçe sayfasına girildi");

        WebElement signUp = driver.findElement(By.cssSelector("[id='H_st_v8'] + div >:nth-child(1)"));
        Assert.assertEquals("Yanlış sayfaya girldi", "https://www.akakce.com/", driver.getCurrentUrl());
        System.out.println("Hesap aç görüntülendi");
        signUp.click();
        MyFunc.sleep(2);

        WebElement name = driver.findElement(By.cssSelector("[id='FrmRnuS'] span > input"));
        name.sendKeys("Behlul");
        MyFunc.sleep(2);
        Assert.assertEquals("Behlul", name.getAttribute("value"));
        System.out.println("Ad girişi başarılı");

        WebElement surname = driver.findElement(By.cssSelector("[id='FrmRnuS'] >:nth-child(7) >input"));
        surname.sendKeys(" ");
        MyFunc.sleep(2);
        Assert.assertEquals(" ", surname.getAttribute("value"));
        System.out.println("Soyad kısmı boş bırakıldı");

        WebElement email = driver.findElement(By.cssSelector("[id='FrmRnuS'] >:nth-child(9) >input"));
        email.sendKeys("fadoda7438@dmener.com");
        MyFunc.sleep(2);
        Assert.assertEquals("fadoda7438@dmener.com", email.getAttribute("value"));
        System.out.println("Email girişi başarılı");

        WebElement reEmail = driver.findElement(By.cssSelector("[id='FrmRnuS'] >:nth-child(11) >input"));
        reEmail.sendKeys("fadoda7438@dmener.com");
        MyFunc.sleep(2);
        Assert.assertEquals("fadoda7438@dmener.com", reEmail.getAttribute("value"));
        System.out.println("Tekrar Email girişi başarılı");

        WebElement password = driver.findElement(By.cssSelector("[id='FrmRnuS'] >:nth-child(13) >input"));
        password.sendKeys("Bugfathers04");
        MyFunc.sleep(2);
        Assert.assertEquals("Bugfathers04", password.getAttribute("value"));
        System.out.println("Şifre girişi başarılı");

        WebElement rePassword = driver.findElement(By.cssSelector("[id='FrmRnuS'] >:nth-child(15) >input"));
        rePassword.sendKeys("Bugfathers04");
        MyFunc.sleep(2);
        Assert.assertEquals("Bugfathers04", rePassword.getAttribute("value"));
        System.out.println("Tekrar Şifre girişi başarılı");

        WebElement gender = driver.findElement(By.cssSelector("[id='FrmRnuS'] span ~ span label+label >input"));
        gender.click();
        MyFunc.sleep(2);
        Assert.assertTrue("Hatalı seçim", gender.isSelected());
        System.out.println("Erkek seçildi");

        WebElement city = driver.findElement(By.cssSelector("[id='FrmRnuS'] >:nth-child(18) select >:nth-child(2)"));
        city.click();
        MyFunc.sleep(2);
        Assert.assertTrue("Hatalı seçim", city.isSelected());
        System.out.println("İl doğru girldi");

        WebElement district = driver.findElement(By.cssSelector("[id='FrmRnuS'] >:nth-child(19) label + select >:nth-child(6)"));
        district.click();
        MyFunc.sleep(2);
        Assert.assertTrue("Hatalı seçim", district.isSelected());
        System.out.println("ilçe doğru girldi");

        WebElement day = driver.findElement(By.cssSelector("[id='FrmRnuS'] >:nth-child(23) span select >:nth-child(2)"));
        day.click();
        MyFunc.sleep(2);
        Assert.assertTrue("Hatalı seçim", day.isSelected());
        System.out.println("Gün doğru girldi");

        WebElement month = driver.findElement(By.cssSelector("[id='FrmRnuS'] >:nth-child(23) span + span select >:nth-child(2)"));
        month.click();
        MyFunc.sleep(2);
        Assert.assertTrue("Hatalı seçim", month.isSelected());
        System.out.println("Ay doğru girldi");

        WebElement year = driver.findElement(By.cssSelector("[id='FrmRnuS'] >:nth-child(23) span + span + span select >:nth-child(14)"));
        year.click();
        MyFunc.sleep(2);
        Assert.assertTrue("Hatalı seçim", year.isSelected());
        System.out.println("Yıl doğru girldi");

        WebElement accept = driver.findElement(By.cssSelector("[id='FrmRnuS'] >:nth-child(24) input"));
        accept.click();
        MyFunc.sleep(2);
        Assert.assertTrue("Hatalı seçim", accept.isSelected());
        System.out.println("Sözleşme kabul et seçildi");

        WebElement notification = driver.findElement(By.cssSelector("[id='FrmRnuS'] >:nth-child(25) input"));
        notification.click();
        MyFunc.sleep(2);
        Assert.assertTrue("Hatalı seçim", notification.isSelected());
        System.out.println("Bildirimleri kabul et seçildi");

        WebElement submit = driver.findElement(By.cssSelector("[id='FrmRnuS'] >:nth-child(27) "));
        submit.click();
        MyFunc.sleep(5);
        Assert.assertTrue("Hatalı seçim", submit.isSelected());
        System.out.println("Hesap Aç seçildi");

        WaitAndClose();
    }
}
