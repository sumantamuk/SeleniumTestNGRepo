package tests;

import org.testng.annotations.Test;

import org.testng.asserts.*;

import org.testng.annotations.*;
import framework.dataprovidermanager.CommonMethods;
import pagefactory.HomePage;
import java.util.HashMap;
import java.util.List;




public class TestCase_01 extends Base{

    public List<HashMap<String, String>> TestData;
    
    HomePage homePage;
    @BeforeMethod
    public void initializeElements()
    {
        TestData = fetchTestData();
        homePage = new HomePage(driver);
    }

    @Test
	public void CheckUserIsAbleToLogin()
    {
        try
        {
        	int rnd=new CommonMethods().generateRandomNumber();
            String[] arrSplit = TestData.get(0).get("EmailID").split("@");            
            homePage.login(arrSplit[0]+String.valueOf(rnd)+"@"+arrSplit[1], TestData.get(0).get("Password"));
            //homePage.login(arrSplit[0]+String.valueOf(rnd)+arrSplit[1], TestData.get(0).get("Password"));
        }
        catch (org.openqa.selenium.NoSuchElementException e)
        {
            e.printStackTrace();
        }
    }
    
    

}
