package Praktikum14Cucumber.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory {
    public static WebDriver get() {
        String browser = ConfigurationReader.get("browser");
        WebDriver driver;
        switch (browser) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-search-engine-choice-screen");
                options.addArguments("--disable-popup-blocking");
                options.addArguments("--disable-notifications");
                options.addArguments("--disable-extensions");
                options.addArguments("--ignore-autocomplete-off-autofill");
                Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("autofill.profile_enabled", false);
                options.setExperimentalOption("prefs", prefs);
                if (ConfigurationReader.get("headless").equalsIgnoreCase("true")) {
                    options.addArguments("--headless");
                }
                driver = new ChromeDriver(options);
                if (ConfigurationReader.get("maximize").equalsIgnoreCase("true")) {
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
                }
                return driver;
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                return driver;
            }
            case "edge" -> {
                if (!System.getProperty("os.name").equalsIgnoreCase("windows")) {
                    throw new WrongThreadException("Ваша операционная система не поддерживает Edge");
                }
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                return driver;
            }
        }
        throw new WrongThreadException("WebDriver не выбран в конфигурационном файле configuration.properties");
    }
}
