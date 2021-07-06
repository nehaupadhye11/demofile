package TestCases;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import SourcePages.DashBoardPage;
import SourcePages.LoginPage;
import SourcePages.TestBase;
import SourcePages.UserPage;

public class UserTest extends TestBase {
 LoginPage login;
 DashBoardPage dashboard;
 UserPage userpage;
 
 UserTest()
 {
	 super();
 }

 @BeforeSuite
 public void setup()
 {
	 initialization();
	 login = new LoginPage();
	 dashboard = login.ValidLogin();
	 userpage = dashboard.Usersclick();
	 
 }
	
@Test
//Validating user's name 
public void test01()
{
   ArrayList<String> exp = new ArrayList<String>();
   ArrayList<String> act = new ArrayList<String>();
   for(int i =1;i<=4;i++)
   { 
	   exp.add(userpage.readexcel(1, i));
  }
act = userpage.UserData();
Assert.assertEquals(exp, act);
}

@Test
//Validating @gmail.com is present in email field 
public void test02()
{  
	 ArrayList<String> act = new ArrayList<String>();
	 ArrayList<Boolean> flags = new ArrayList<Boolean>();
	 act = userpage.EmailData();
	 ArrayList<Boolean> expflags = new ArrayList<Boolean>();
	 
	 for(String e : act)
	  { expflags.add(true);
		if(e.contains("@gmail.com"))
		{
			flags.add(true);
		}
		else
			flags.add(false);
	  }
 Assert.assertEquals(flags,expflags);
}

@Test
//Checking Email id field
public void test03()
{
	 ArrayList<String> exp = new ArrayList<String>();
	   ArrayList<String> act = new ArrayList<String>();
	   for(int i=1;i<=4;i++)
	   { 
		   exp.add(userpage.readexcel(2, i));
	  }
	act = userpage.EmailData();
	Assert.assertEquals(exp, act);

}

@Test
//Checking Email id field
public void test04()
{
	 ArrayList<String> exp = new ArrayList<String>();
	   ArrayList<String> act = new ArrayList<String>();
	   for(int i=1;i<=4;i++)
	   { 
		   exp.add(userpage.readexcel(2, i));
	  }
	act = userpage.EmailData();
	Assert.assertEquals(exp, act);

}

@Test
//Checking mobile numbers length
public void test05()
{
	ArrayList<String> act = new ArrayList<String>();
	act = userpage.MobileData();
	SoftAssert sa = new SoftAssert();
	for(String e : act)
	{		
	System.out.println(e.length());	
     sa.assertEquals(10, e.length());
	}
	
	
}

@Test
//Checking if mobile number is correct 
public void test06()
{
	ArrayList<String> act = new ArrayList<String>();
	act = userpage.MobileData();
	
	ArrayList<String> exp = new ArrayList<String>();
	for(int i=1;i<=4;i++)
	   { 
		   exp.add(userpage.readexcel(3, i));
	  }    
	
	Assert.assertEquals(act, exp);

}

@Test
//Checking if the course if among the four option 
public void test07()
{
	ArrayList<String> act = new ArrayList<String>();
	act = userpage.CourseData();
	
	ArrayList<String> exp = new ArrayList<String>();
	for(int i=1;i<=4;i++)
	   { 
		   exp.add(userpage.readexcel(4, i));
	  }    
	
	Assert.assertEquals(act, exp);
}

@Test
//Checking if gender is entered correctly
public void test08()
{
	ArrayList<String> act = new ArrayList<String>();
	act = userpage.GenderData();
	
	ArrayList<String> exp = new ArrayList<String>();
	for(int i=1;i<=4;i++)
	   { 
		   exp.add(userpage.readexcel(5, i));
	  }    
	
	Assert.assertEquals(act, exp);
}

@Test
//Checking the state
public void test09()
{
	ArrayList<String> act = new ArrayList<String>();
	act = userpage.StateData();
	
	ArrayList<String> exp = new ArrayList<String>();
	for(int i=1;i<=4;i++)
	   { 
		   exp.add(userpage.readexcel(6, i));
	  }    
	
	Assert.assertEquals(act, exp);
}


@Test
//Checking if delete button enable
public void test10()
{
	for(WebElement e : userpage.delete)
	{
		Assert.assertTrue(e.isEnabled());			
	}
}

@Test
//Checking users from maharashtra state 
public void test11()
{
	ArrayList<String> exp = new ArrayList<String>();
	ArrayList<String> actual = new ArrayList<String>();
	for(int i =1; i<=4; i++)
	{	  String str = userpage.readexcel(6, i);
	      if(str.equals("Maharashtra"));
	      { exp.add(str);}
	}
 
  
    for(WebElement e : userpage.state)
     {	  
     String str = e.getText();
       if(str.equals("Maharashtra"));
        {
        	actual.add(str);}
        }
Assert.assertEquals(exp,actual);
}

@Test
//Checking if adduser button is enable
public void test12()
{
	Assert.assertTrue(userpage.Adduserenable());
}

@Test
//Checking if logout link is enable
public void test13()
{
	Assert.assertTrue(userpage.Logoutenable());
}

@Test
//Verifying the header
public void test14()
{
	ArrayList<String> exp = new ArrayList<String>();
	ArrayList<String> actual = new ArrayList<String>();
	for(int i =0; i<8; i++)
	{	  String str = userpage.readexcel(i, 0);
              exp.add(str);
	}
 
  
    for(WebElement e : userpage.headers)
     {	  
     String str = e.getText();  
        	actual.add(str);        	
     }
    Assert.assertEquals(exp,actual);
}

}