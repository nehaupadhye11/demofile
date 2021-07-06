package TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import SourcePages.LoginPage;
import SourcePages.TestBase;

public class LoginTest extends TestBase{
	LoginPage login;
  public LoginTest()
	{
		super();
	}
  
@BeforeSuite
public void setup()
{
  initialization();
  login = new LoginPage();
}
	@Test
	//Log in fails if wrong username and password entered
	public void test01()
	{   login.Cleardata();
		login.EnterDetails("abcd","12345");
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Log in");
	}
	
	@Test
	//Displaying labels with the username and pass word if wrong data entered
	public void test02()
	{   login.Cleardata();
		login.EnterDetails("abcd", "12345");
		Assert.assertEquals(login.Emaillabeltext(), "Please enter email as kiran@gmail.com");
		Assert.assertEquals(login.Passwordlabeltext(), "Please enter password 123456");
	}

	@Test
	//Checking if logo is visible
	public void test03()
	{
		Assert.assertEquals(login.Imagevisible(), true);
	}
	
	@Test
	//validating the register user link
	public void test04()
	{ 
		Assert.assertEquals(login.Registerlink(), "JavaByKiran | Registration Page");
	      driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void test05()
	//Valid login
	{
		login.Cleardata();
	    login.EnterDetails(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
		driver.get(prop.getProperty("url"));
	}
}
