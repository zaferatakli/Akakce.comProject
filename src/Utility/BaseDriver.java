package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.Random;

public class BaseDriver {
    public static WebDriver driver;

    static {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    public static void WaitAndClose() {
        MyFunc.sleep(6);
        driver.quit();
    }
    public static String generateRandomEmail() {
        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";
        String[] domains = {"gmail.com", "yahoo.com", "outlook.com", "hotmail.com"};
        Random random = new Random();

        StringBuilder username = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            username.append(characters.charAt(random.nextInt(characters.length())));
        }

        String domain = domains[random.nextInt(domains.length)];

        return username.toString() + "@" + domain;
    }
    public static String generateRandomPassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*";
        Random random = new Random();

        StringBuilder password = new StringBuilder();
        while (!password.toString().matches(".*[A-Z].*") || !password.toString().matches(".*[a-z].*") || !password.toString().matches(".*[0-9].*") || !password.toString().matches(".*[!@#$%^&*].*")) {
            password.setLength(0);
            for (int i = 0; i < 8; i++) {
                password.append(characters.charAt(random.nextInt(characters.length())));
            }
        }

        return password.toString();
    }
}
