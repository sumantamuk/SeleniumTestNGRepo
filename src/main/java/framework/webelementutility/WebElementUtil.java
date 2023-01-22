package framework.webelementutility;


import javax.net.ssl.X509ExtendedTrustManager;

import org.jsoup.Connection.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.model.Test;


public class WebElementUtil{
	
	public ExtentTest test;
    public WebDriver driver;
    public ExtentReports extentReport = 

    public WebElementUtil(WebDriver driver)
    {
        this.driver=driver;
    }
    
    public void commonWaitForElement(WebElement element) throws InterruptedException
    {
        int counter = 0;
        while(counter<=30)
        {
            try
            {
                WebDriverWait wait = new WebDriverWait(driver, 60);
                Thread.sleep(1000);
                wait.until(ExpectedConditions.elementToBeClickable(element));
                test.log(LogStatus.INFO, "Element loaded");
                break;                
            }
            catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.StaleElementReferenceException | org.openqa.selenium.ElementNotInteractableException e)
            {            	
                counter++;                
            }
        }
    }

    public void commonClick(WebElement element)
    {
        int counter = 0;
        while(counter<=30)
        {
            try
            {
                WebDriverWait wait = new WebDriverWait(driver, 60);
                wait.until(ExpectedConditions.elementToBeClickable(element));
                element.click();
                break;
            }
            catch (org.openqa.selenium.StaleElementReferenceException | org.openqa.selenium.ElementNotInteractableException e)
            {
                counter++;
                e.printStackTrace();
            }
        }
    }

    public void commonSendTestData(WebElement element, String testData)
    {
        int counter = 0;
        while(counter<=30)
        {
            try
            {
                WebDriverWait wait = new WebDriverWait(driver, 60);
                wait.until(ExpectedConditions.elementToBeClickable(element));
                element.sendKeys(testData);
                break;
            }
            catch (org.openqa.selenium.StaleElementReferenceException | org.openqa.selenium.ElementNotInteractableException e)
            {
                counter++;
                e.printStackTrace();
            }
        }
    }

    public void commonSelectDropdown(WebElement element, String testData)
    {
        int counter = 0;
        while(counter<=30)
        {
            try
            {
                WebDriverWait wait = new WebDriverWait(driver, 60);
                wait.until(ExpectedConditions.elementToBeClickable(element));
                Select selectdropdown = new Select(element);
                selectdropdown.selectByVisibleText(testData);
                break;
            }
            catch (org.openqa.selenium.StaleElementReferenceException | org.openqa.selenium.ElementNotInteractableException e)
            {
                counter++;
                e.printStackTrace();
            }
        }
    }
}
