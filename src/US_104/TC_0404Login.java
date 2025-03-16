package US_104;

import Utility.BaseDriver;
import org.junit.Test;

public class TC_0404Login extends BaseDriver {
    /**Bu Test Senaryosu, boş (NULL) e-posta ve şifre ile oturum açma girişiminin başarısız olduğunu doğrulamak için hazırlanmıştır.
        This Test Scenario is prepared to verify that the login attempt with a null (empty) email and password fails.
     */
    @Test
    public void TC_0404LoginTest() {
        driver.navigate().to("https://www.akakce.com/");




        WaitAndClose();
    }
}
