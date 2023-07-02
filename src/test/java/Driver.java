import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {
    WebDriver driver;

    public void webDriver() {
        //Драйвер для хрома
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);


        //Драйвер для яндекса
       /* System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\Yandex\\bin\\yandexdriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\Crubbuterella\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        driver = new ChromeDriver(options);*/

    }
}
