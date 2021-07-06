package SourcePages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
public static WebDriver driver;
public static Properties prop; 

public TestBase(){
try {
  prop = new Properties();
  FileInputStream fis = new FileInputStream("E:\\workspace3\\Task1_BasicTestCasesOflinewebsite\\src\\main\\java\\Configfiles\\Config.properties");
  prop.load(fis);
}catch(Exception e){}
}
public static void initialization()
{   String browsername = prop.getProperty("browser");
     if(browsername.equals("chrome"))
	    {
    	 System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
	 driver = new ChromeDriver();
	 }
     else if(browsername.equals("FireFox"))
     { 
    	 System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
    	 driver = new FirefoxDriver();
     }
	 driver.get(prop.getProperty("url"));
	 
	}
}
