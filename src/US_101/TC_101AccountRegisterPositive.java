package US_101;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_101AccountRegisterPositive extends BaseDriver {
    /**<pre>
     * --> Bu senaryoda sitede doğru bilgiler girilerek hesap açma senaryosu sağlanmıştır.
     *
     * --> In this scenario, the account opening scenario was provided by entering the correct information on the site.</pre>*/
    @Test
    public void TC_0101AccountTest() {
        driver.navigate().to("https://www.akakce.com/");
        MyFunc.sleep(2);
        Assert.assertEquals("Yanlış sayfaya girldi", "https://www.akakce.com/", driver.getCurrentUrl());
        System.out.println("Akakçe sayfasına girildi");

        WebElement signUp = driver.findElement(By.cssSelector("[id='H_st_v8'] + div >:nth-child(1)"));
        Assert.assertEquals("Yanlış sayfaya girildi", "https://www.akakce.com/", driver.getCurrentUrl());
        System.out.println("Hesap aç görüntülendi");
        signUp.click();
        MyFunc.sleep(2);

        WebElement name = driver.findElement(By.cssSelector("[id='FrmRnuS'] span > input"));
        name.sendKeys("Behlul");
        Assert.assertEquals("Behlul", name.getAttribute("value"));
        System.out.println("Ad girişi başarılı");
        MyFunc.sleep(1);

        WebElement surname = driver.findElement(By.cssSelector("[id='FrmRnuS'] >:nth-child(7) >input"));
        surname.sendKeys("Kacar");
        Assert.assertEquals("Kacar", surname.getAttribute("value"));
        System.out.println("Soyad girişi başarılı");
        MyFunc.sleep(1);

        String randomEmail = BaseDriver.generateRandomEmail();
        WebElement email = driver.findElement(By.cssSelector("[id='FrmRnuS'] >:nth-child(9) >input"));
        email.sendKeys(randomEmail);
        Assert.assertEquals(randomEmail, email.getAttribute("value"));
        System.out.println("Email girişi başarılı");
        MyFunc.sleep(1);

        WebElement reEmail = driver.findElement(By.cssSelector("[id='FrmRnuS'] >:nth-child(11) >input"));
        reEmail.sendKeys(randomEmail);
        Assert.assertEquals(randomEmail, reEmail.getAttribute("value"));
        System.out.println("Tekrar Email girişi başarılı");
        MyFunc.sleep(1);

        String randomPassword = BaseDriver.generateRandomPassword();
        WebElement password = driver.findElement(By.cssSelector("[id='FrmRnuS'] >:nth-child(13) >input"));
        password.sendKeys(randomPassword);
        Assert.assertEquals(randomPassword, password.getAttribute("value"));
        System.out.println("Şifre girişi başarılı");
        MyFunc.sleep(1);

        WebElement rePassword = driver.findElement(By.cssSelector("[id='FrmRnuS'] >:nth-child(15) >input"));
        rePassword.sendKeys(randomPassword);
        Assert.assertEquals(randomPassword, rePassword.getAttribute("value"));
        System.out.println("Tekrar Şifre girişi başarılı");
        MyFunc.sleep(1);

        WebElement gender = driver.findElement(By.cssSelector("[id='FrmRnuS'] span ~ span label+label >input"));
        gender.click();
        Assert.assertTrue("Hatalı seçim", gender.isSelected());
        System.out.println("Erkek seçildi");
        MyFunc.sleep(1);

        WebElement city = driver.findElement(By.cssSelector("[id='FrmRnuS'] >:nth-child(18) select >:nth-child(2)"));
        city.click();
        Assert.assertTrue("Hatalı seçim", city.isSelected());
        System.out.println("İl doğru girildi");
        MyFunc.sleep(1);

        WebElement district = driver.findElement(By.cssSelector("[id='FrmRnuS'] >:nth-child(19) label + select >:nth-child(6)"));
        district.click();
        Assert.assertTrue("Hatalı seçim", district.isSelected());
        System.out.println("ilçe doğru girildi");
        MyFunc.sleep(1);

        WebElement day = driver.findElement(By.cssSelector("[id='FrmRnuS'] >:nth-child(23) span select >:nth-child(2)"));
        day.click();
        Assert.assertTrue("Hatalı seçim", day.isSelected());
        System.out.println("Gün doğru girildi");
        MyFunc.sleep(1);

        WebElement month = driver.findElement(By.cssSelector("[id='FrmRnuS'] >:nth-child(23) span + span select >:nth-child(2)"));
        month.click();
        Assert.assertTrue("Hatalı seçim", month.isSelected());
        System.out.println("Ay doğru girildi");
        MyFunc.sleep(1);

        WebElement year = driver.findElement(By.cssSelector("[id='FrmRnuS'] >:nth-child(23) span + span + span select >:nth-child(14)"));
        year.click();
        Assert.assertTrue("Hatalı seçim", year.isSelected());
        System.out.println("Yıl doğru girildi");
        MyFunc.sleep(1);

        WebElement accept = driver.findElement(By.cssSelector("[id='FrmRnuS'] >:nth-child(24) input"));
        accept.click();
        Assert.assertTrue("Hatalı seçim", accept.isSelected());
        System.out.println("Sözleşme kabul et seçildi");
        MyFunc.sleep(1);

        WebElement notification = driver.findElement(By.cssSelector("[id='FrmRnuS'] >:nth-child(25) input"));
        notification.click();
        Assert.assertTrue("Hatalı seçim", notification.isSelected());
        System.out.println("Bildirimleri kabul et seçildi");
        MyFunc.sleep(1);

        WebElement submit = driver.findElement(By.cssSelector("[id='FrmRnuS'] >:nth-child(27) "));
        submit.click();
        System.out.println("Hesap Aç seçildi");
        MyFunc.sleep(2);

        WebElement accountCheck = driver.findElement(By.cssSelector("div[id='HM_v8'] > :nth-child(1) a"));
        Assert.assertEquals("Oturum açılamadı.", "Behlul", accountCheck.getText());
        System.out.println("Hesap başarılı bir şekilde olusturuldu.");

        WaitAndClose();
    }
}
