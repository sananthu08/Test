package com.ictakwebsite.scripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {

		WebDriver driver;
	    public static Properties prop = null;
	    String driverPath = "E:drivers\\chromedriver.exe";
	public static void TestBase() {
	        try {
	        	//Below line creates an object of Properties called 'prop'
	            prop = new Properties();
	          //Below line creates an object of FileInputStream called 'ip'. 
	          //Give the path of the properties file which you have created
	            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources"
	                    + "/config.properties");
	            //Below line of code will load the property file
	            prop.load(ip);
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	@BeforeTest
	public void onSetup() {
	    TestBase(); // for loading the configurations
	    String browserName = prop.getProperty("browser");

	    if (browserName.equals("chrome")) {
	    	System.setProperty("webdriver.chrome.driver", driverPath);
	        driver = new ChromeDriver();

	    }
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get(prop.getProperty("url"));
	    driver.manage().window().maximize();   
	}
	
@AfterTest
public void quitBrowser() throws IOException {
    driver.quit();
}
}

