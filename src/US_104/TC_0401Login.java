package US_104;

import Utility.BaseDriver;
import org.junit.Test;

public class TC_0401Login extends BaseDriver {
    /**Bu Test Senaryosu, kullanıcının başarılı bir şekilde oturum açmasını test etmek için hazırlanmıştır.
        This Test Scenario is prepared to test the successful login of the user.
     */
    @Test
    public void TC_0401LoginTest() {
        driver.navigate().to("https://www.akakce.com/");



        WaitAndClose();
    }
}
