package tests;

import framework.dataprovidermanager.ExcelReader;
import framework.dataprovidermanager.PropertiesReader;
import framework.drivermanager.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Base {

    public WebDriver driver;

    WebDriverManager webDriverManager = new WebDriverManager();

    PropertiesReader propertiesReader = new PropertiesReader();

    ExcelReader excelReader = new ExcelReader();
    
    
    
    public WebDriver getDriver()
    {
        return driver;
    }

    public void setDriver()
    {
        driver = webDriverManager.createDriver(propertiesReader.getProperty("Browser"));
    }

    @BeforeTest
    public void createSession()
    {
        try
        {
            setDriver();
            driver.get(propertiesReader.getProperty("ApplicationURL"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @AfterTest
    public void endSession()
    {
        driver.close();
        driver.quit();
    }

    @BeforeTest
    public List<HashMap<String, String>> fetchTestData()
    {
        List <HashMap<String, String>> SheetData = new ArrayList<>();
        try
        {
            SheetData = excelReader.GetTestData("TestData");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return SheetData;
    }
}
