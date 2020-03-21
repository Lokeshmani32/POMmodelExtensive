package com.inetBanking.testCases;
 
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Parameters;

import com.inetBanking.utilities.Readconfig;

public class BaseClass {

	Readconfig readconfig = new Readconfig();
	
	public  String baseURL = readconfig.getApplicationURL();
	public  String username=readconfig.getUsername();
	public String password= readconfig.getPassword();
    /*public String ""= readconfig.getPassword();
    public String password= readconfig.getPassword();
  	public String password= readconfig.getPassword();*/
	public static WebDriver driver;
	public static Logger Logger;
	
	
	@Parameters("browser")  
	@BeforeClass
	public void setup(String br) {
		
		
	    
	    //org.apache.log4j.BasicConfigurator.configure();
	    Logger = org.apache.log4j.Logger.getLogger("eBanking");
	    PropertyConfigurator.configure("log4j.properties");
	    if (br.equals("chrome")) 
	    {
	    System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
	    driver = new ChromeDriver();
	    }else if (br.equals("firefox"))
	    {
	    	System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxpath());
		    driver = new FirefoxDriver();
	    }
	    driver.get(baseURL);
	}
	
	@AfterClass
	public void tearDown() {
		
		driver.quit();
	}
	public void captureScreen(WebDriver driver,String tname) throws IOException{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		File target = new File (System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");	
		
	}
}
