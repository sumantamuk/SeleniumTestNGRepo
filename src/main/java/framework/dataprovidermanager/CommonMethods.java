package framework.dataprovidermanager;

public class CommonMethods {
	public int generateRandomNumber()
    {	
		int rndNum = 0;
		try
        {        
	        int min = 1000;
	        int max = 9999;
	        rndNum = (int)(Math.random()*(max-min+1)+min);	        
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return rndNum;
    }

}
