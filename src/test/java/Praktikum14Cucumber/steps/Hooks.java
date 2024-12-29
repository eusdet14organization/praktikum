package Praktikum14Cucumber.steps;


import Praktikum14Cucumber.context.TestContext;
import Praktikum14Cucumber.utils.ConfigurationReader;
import Praktikum14Cucumber.utils.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static Praktikum14Cucumber.context.TestContext.getDriver;
import static Praktikum14Cucumber.context.TestContext.remoteDriver;

public class Hooks {
    @Before
    public void set(Scenario scenario) {
        WebDriver driver = DriverFactory.get();
        TestContext.setDriver(driver);
        driver.get(ConfigurationReader.get("base_url"));
        TestContext.scenario = scenario;
    }

    @After
    public void afterMethod(Scenario scenario) {
        if (scenario.isFailed()) {
            WebDriver driver = getDriver();
            if (driver != null) {
                TakesScreenshot ts = (TakesScreenshot) driver;
                byte[] src = ts.getScreenshotAs(OutputType.BYTES);
                scenario.attach(src, "image/png", "screenshot");
            }
        }
        closeDriver();
    }

    private  void closeDriver(){
        WebDriver driver = getDriver();
        if (driver!=null){
            driver.quit();
            remoteDriver();
        }
    }
}
