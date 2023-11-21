package StepDef;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks {
    public static WebDriver webDriver;
    @Before
    public void openBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().forceDownload().setup();

        webDriver = new ChromeDriver(options);
        String appUrl = "https://www.saucedemo.com/";
        webDriver.get(appUrl);
        webDriver.manage().window().maximize();

    }
    @After
        public void closeDriver(){
        webDriver.quit();
    }
}
