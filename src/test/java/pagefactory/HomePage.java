package pagefactory;

import framework.webelementutility.WebElementUtil;
import tests.Base;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;



public class HomePage extends WebElementUtil {	
	
	
    public HomePage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }
	
    public By lnkSignIn = By.xpath("//a[contains(text(), 'Sign in')]");
    private By btnSubmitCreateAccount = By.xpath("//button[@id='SubmitCreate']");
    private By txtEmailCreate = By.xpath("//input[@name='email_create']");
    private By pgRegistration = By.xpath("//h3[text()='Your personal information']");
    
    
    public void login(String username, String password)
    {
        try
        {        	
        	commonWaitForElement(driver.findElement(lnkSignIn));
            commonClick(driver.findElement(lnkSignIn));
            commonWaitForElement(driver.findElement(txtEmailCreate));
            //test.log(LogStatus.PASS, "Navigated to the specified URL");
            commonSendTestData(driver.findElement(txtEmailCreate), username);
            commonClick(driver.findElement(btnSubmitCreateAccount));
            System.out.println("Wait");
            Thread.sleep(10000);
            commonWaitForElement(driver.findElement(pgRegistration));
        }
        catch (Exception e)
        {
        	Assert.fail(e.getMessage());
            e.printStackTrace();
        }
    }

}
