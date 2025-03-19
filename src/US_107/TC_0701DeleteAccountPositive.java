package US_107;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_0701DeleteAccountPositive extends BaseDriver {
    /**
     *Bu test senaryosunda akakce.com sitesine gidilerek daha once olusturulmus ve dogrulanmis bir hesabi silme islemi yapilmaktadir.
     * In this test scenario, a previously created and verified account is deleted by navigating to the akakce.com website.
     */
    @Test
    public void TC_0701DeleteAccountPositiveTest() {
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

        WebElement enterYourPassword = driver.findElement(By.cssSelector("#p"));
        enterYourPassword.sendKeys("Abcd.1234");
        MyFunc.sleep(3);

        WebElement deleteMyAccountButton1 = driver.findElement(By.cssSelector("input[id='a'] +span+span>input"));
        deleteMyAccountButton1.click();
        Assert.assertEquals("Dogru şifre", "https://www.akakce.com/", driver.getCurrentUrl());
        System.out.println("Hesabın silindi. Seni tekrar aramızda görmek isteriz.");

        WaitAndClose();
    }
}
