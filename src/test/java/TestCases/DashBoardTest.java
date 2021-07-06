package TestCases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import SourcePages.*;

public class DashBoardTest extends TestBase
{
	LoginPage login;
	DashBoardPage dashboard;
	Logger log = Logger.getLogger(DashBoardTest.class);
	
public DashBoardTest()
	{
		super();
	}

@BeforeSuite
public void setup()
{
initialization();
login = new LoginPage();
dashboard = login.ValidLogin();
}

@Test
//Checking headers list
public void test01()
{
	log.info("Checking headers list");
	for(int j=1;j<=4;j++)
	{
       String str = dashboard.Validatingheaders(j);	 
       Assert.assertEquals(str,dashboard.header.get(j-1));
	}
}    

@Test
//Checking Users  page link
public void test02()
{
 	dashboard.Usersclick();
 	Assert.assertEquals(driver.getTitle(), "JavaByKiran | User");
 	driver.navigate().back();
}

@Test
//Checking Users  operators link
public void test03()
{
	dashboard.Operatorclick();
	Assert.assertEquals(driver.getTitle(), "JavaByKiran | Operators");
	driver.get("file:///C:/Selenium/Offline%20Website/Offline%20Website/pages/examples/dashboard.html");
}

@Test
//Checking Users  Usefullinks link
public void test04()
{
	dashboard.Usefullinkpageclick();
	Assert.assertEquals(driver.getTitle(), "JavaByKiran | Useful Links");
	driver.get("file:///C:/Selenium/Offline%20Website/Offline%20Website/pages/examples/dashboard.html");
}

@Test
//Checking Users  Downloads link
public void test05()
{
	dashboard.Downloadpageclick();
	Assert.assertEquals(driver.getTitle(), "JavaByKiran | Downloads");
	driver.get("file:///C:/Selenium/Offline%20Website/Offline%20Website/pages/examples/dashboard.html");
}

@Test
public void test06()
{
Assert.assertEquals(true, dashboard.Seleniumiconactive());	

}
}
 