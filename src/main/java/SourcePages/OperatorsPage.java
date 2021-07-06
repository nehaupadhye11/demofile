package SourcePages;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeSuite;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class OperatorsPage extends TestBase{

@BeforeSuite
public void setup()
{
 initialization();	
}

public OperatorsPage()
{	
PageFactory.initElements(driver, this);
}

@FindBy(xpath="//th")
List<WebElement> headers;

@FindBy(xpath="//td[1]")
List<WebElement> id;

@FindBy(xpath="//td[2]")
List<WebElement> users;

@FindBy(xpath="//td[3]")
List<WebElement> work;
	
@FindBy(xpath="//td[4]")
List<WebElement> waytoconnect;
	
@FindBy(xpath= "//td[5]")	
List<WebElement> numbers;

@FindBy(xpath="//td[6]")
List<WebElement> timings;

@FindBy(xpath = "//li[@class='dropdown user user-menu']//child::a")
WebElement logout;

	
public String ReadData(int i , int j)
{
	String str = null;
	 try {
	    	Workbook wb = Workbook.getWorkbook(new FileInputStream("D:\\OflineSiteData.xls"));
            Sheet sh = wb.getSheet("OperatorsData");
            Cell cell =sh.getCell(i,j);
            str = cell.getContents();	   
     	  } 
	catch (Exception e) {}
    
	return str; 	
}

public boolean LogoutEnable()
{
	return logout.isEnabled();
}

public ArrayList<String> HeadersData()
{
  ArrayList<String> act = new ArrayList<String>();
   for(WebElement e : headers )
    {
	 act.add(e.getText());
     }
   return act;
}

public ArrayList<String> UsersData()
{
	ArrayList<String> act = new ArrayList<String>();
	 for(WebElement e : users  )
      {
		act.add(e.getText());		
	   }
    return act;
}

public ArrayList<String> ContactNumber()
{ 
   ArrayList<String> act = new ArrayList<String>();
    for(WebElement e: numbers)
     {
	   act.add(e.getText());
      }
   return act;
}

public void WorkingHours()
{
   int working;	
   String[] temp = new String[2];
   ArrayList<String> act = new ArrayList<String>();
     for(WebElement e: timings)
       {
	     act.add(e.getText());
	   }   
}

public ArrayList<String> PersonAvailableonWhatsapp()
{	 	
 ArrayList<String> act1 = new ArrayList<String>();    
 ArrayList<String> act2 = new ArrayList<String>();
 ArrayList<String> temp = new ArrayList<String>();

   for(WebElement e : waytoconnect)
   {
       act1.add(e.getText());	
    }
 
   for(WebElement e : users)
     {
       act2.add(e.getText());	
     }

   for(int i=0; i<waytoconnect.size();i++)
     {
        if(act1.get(i).contains("Whats App"))	
         {
	       temp.add(act2.get(i));
	              }
      }		
   return temp;
}

public ArrayList<String> PersonAvailableforTechnicalhelp()
{	 	
 ArrayList<String> act1 = new ArrayList<String>();    
 ArrayList<String> act2 = new ArrayList<String>();
 ArrayList<String> temp = new ArrayList<String>();

   for(WebElement e : work)
   {
       act1.add(e.getText());	
    }
 
   for(WebElement e : users)
     {
       act2.add(e.getText());	
     }

   for(int i=0; i<work.size();i++)
     {
        if(act1.get(i).contains("Technical Help"))	
         {
	       temp.add(act2.get(i));
	              }
      }		
   return temp;

}

public ArrayList<String> PersonAvailableforEnquiry()
{	 	
 ArrayList<String> act1 = new ArrayList<String>();    
 ArrayList<String> act2 = new ArrayList<String>();
 ArrayList<String> temp = new ArrayList<String>();

   for(WebElement e : work)
   {
       act1.add(e.getText());	
    }
 
   for(WebElement e : users)
     {
       act2.add(e.getText());	
     }

   for(int i=0; i<work.size();i++)
     {
        if(act1.get(i).contains("Enquiry"))	
         {
	       temp.add(act2.get(i));
	              }
      }		
   return temp;

}

public ArrayList<String> PersonAvailableforAlldays()
{	 	
 ArrayList<String> act1 = new ArrayList<String>();    
 ArrayList<String> act2 = new ArrayList<String>();
 ArrayList<String> temp = new ArrayList<String>();

   for(WebElement e : timings)
   {
       act1.add(e.getText());	
    }
 
   for(WebElement e : users)
     {
       act2.add(e.getText());	
     }

   for(int i=0; i<work.size();i++)
     {
        if(act1.get(i).contains("Monday-Saturday"))	
         {
	       temp.add(act2.get(i));
	              }
      }		
   return temp;

}

}



