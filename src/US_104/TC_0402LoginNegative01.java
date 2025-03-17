package US_104;

import Utility.BaseDriver;
import org.junit.Test;

public class TC_0402LoginNegative01 extends BaseDriver {
    /**
     * Bu Test Senaryosu, geçersiz şifre ile oturum açma girişiminin başarısız olduğunu doğrulamak için hazırlanmıştır.
        This Test Scenario is prepared to verify that the login attempt with an incorrect password fails.
     */
    @Test
    public void TC_0402LoginTest() {
        driver.navigate().to("https://www.akakce.com/");




        WaitAndClose();
    }
}
