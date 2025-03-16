package US_104;

import Utility.BaseDriver;
import org.junit.Test;

public class TC_0403Login extends BaseDriver {
    /**Bu Test Senaryosu, geçersiz bir e-posta adresiyle oturum açma girişiminin reddedildiğini test etmek için hazırlanmıştır.
        This Test Scenario is prepared to test that the login attempt with an invalid email address is rejected.
     */
    @Test
    public void TC_0403LoginTest() {
        driver.navigate().to("https://www.akakce.com/");




        WaitAndClose();
    }
}
