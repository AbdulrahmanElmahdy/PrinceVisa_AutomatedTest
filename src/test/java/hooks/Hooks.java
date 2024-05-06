package hooks;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static stepDefinitions.ApplyForVisa.selectedDestination;
import static stepDefinitions.ApplyForVisa.selectedPurpose;

public class Hooks {
    public static WebDriver driver;
    public static ExtentTest test;
    public static ExtentReports extent = new ExtentReports();
    public static ExtentSparkReporter spark;
    public static String name;
    public static String scenarioName;
    public static String methodName;

    @Before
    public static void startBrowser(Scenario scenario) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://princevisa.com/");
        driver.manage().window().maximize();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
        String strDate = sdf.format(cal.getTime());
        scenarioName = scenario.getName();
        name = scenarioName.concat(strDate).concat(".html");
        spark = new ExtentSparkReporter(new File("target/".concat(name)));
        extent.attachReporter(spark);
        extent.flush();
    }

    @After
    public static void tearDown() throws IOException {
        File file = spark.getFile();
        FileUtils.copyFile(file,new File("target/" + selectedDestination + "-" + selectedPurpose + "-".concat(name)));
        extent.flush();
        driver.quit();
    }
}
