package TestCases;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import SourcePages.DashBoardPage;
import SourcePages.LoginPage;
import SourcePages.OperatorsPage;
import SourcePages.TestBase;

public class OperatorsPageTest extends TestBase {
	 LoginPage login;
	 DashBoardPage dashboard;
	 OperatorsPage operatorspage;

@BeforeSuite
  public void setup()
    {
	   initialization();
	   login = new LoginPage();
       dashboard = login.ValidLogin();
	   operatorspage = dashboard.Operatorclick();
     }

   public OperatorsPageTest()
   {
      super();	
    }


@Test
//Count maximum working hours
public void test01()
{
 operatorspage.WorkingHours();	

}

@Test
//Verify user names available on whatsapp
public void test02()
{ 
	ArrayList<String> act = new ArrayList<String>();
	ArrayList<String> exp = new ArrayList<String>();
	ArrayList<String> temp1 = new ArrayList<String>();
	ArrayList<String> temp2 = new ArrayList<String>();
	act = operatorspage.PersonAvailableonWhatsapp();
    for(int i=1; i<=5; i++)
    {
     temp1.add(operatorspage.ReadData(3, i));
     temp2.add(operatorspage.ReadData(1, i));   
    }
    for(int i=0; i<=4;i++)
    {
       if(temp1.get(i).contains("Whats App"))	
        {
	       exp.add(temp2.get(i));
	               }
     }
    Assert.assertEquals(exp, act);    
}

@Test
//Verifying headers of the table 
public void test03()
{
	ArrayList<String> act = new ArrayList<String>();
	ArrayList<String> exp = new ArrayList<String>();
 
	act = operatorspage.HeadersData();
	for(int i=0; i<=5; i++)
	{
		exp.add(operatorspage.ReadData(i,0));
	}	
Assert.assertEquals(exp,act);
}


@Test
//Verify user names available technical help
public void test04()
{ 
	ArrayList<String> act = new ArrayList<String>();
	ArrayList<String> exp = new ArrayList<String>();
	ArrayList<String> temp1 = new ArrayList<String>();
	ArrayList<String> temp2 = new ArrayList<String>();
	act = operatorspage.PersonAvailableforTechnicalhelp();
  for(int i=1; i<=5; i++)
  {
   temp1.add(operatorspage.ReadData(2, i));
   temp2.add(operatorspage.ReadData(1, i));   
  }
  for(int i=0; i<=4;i++)
  {
     if(temp1.get(i).contains("Technical Help"))	
      {
	       exp.add(temp2.get(i));
	               }
   }
  Assert.assertEquals(exp, act);    
}

@Test
//Checking if logout enable
public void test05()
{
Assert.assertEquals(operatorspage.LogoutEnable(),true);	
}

@Test
//Verify user names available for enquiry
public void test06()
{ 
	ArrayList<String> act = new ArrayList<String>();
	ArrayList<String> exp = new ArrayList<String>();
	ArrayList<String> temp1 = new ArrayList<String>();
	ArrayList<String> temp2 = new ArrayList<String>();
	act = operatorspage.PersonAvailableforEnquiry();
for(int i=1; i<=5; i++)
{
 temp1.add(operatorspage.ReadData(2, i));
 temp2.add(operatorspage.ReadData(1, i));   
}
for(int i=0; i<=4;i++)
{
   if(temp1.get(i).contains("Enquiry"))	
    {
	       exp.add(temp2.get(i));
	               }
 }
Assert.assertEquals(exp, act);    
}

@Test
//Verify user names available technical help
public void test07()
{ 
	ArrayList<String> act = new ArrayList<String>();
	ArrayList<String> exp = new ArrayList<String>();
	ArrayList<String> temp1 = new ArrayList<String>();
	ArrayList<String> temp2 = new ArrayList<String>();
	act = operatorspage.PersonAvailableforAlldays();

for(int i=1; i<=5; i++)
{
 temp1.add(operatorspage.ReadData(5, i));
 temp2.add(operatorspage.ReadData(1, i));   
}
for(int i=0; i<=4;i++)
{
   if(temp1.get(i).contains("Monday-Saturday"))	
    {
	       exp.add(temp2.get(i));
	               }
     }
Assert.assertEquals(exp, act);    
}


}