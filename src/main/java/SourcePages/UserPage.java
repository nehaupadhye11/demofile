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


public class UserPage extends TestBase {
@BeforeSuite
public void setup()
{
	initialization();
	
  }
public UserPage()
{
  PageFactory.initElements(driver, this);	
}
@FindBy(xpath ="//th")
public List<WebElement> headers;
	
@FindBy(xpath ="//td[2]")
List<WebElement> usersname;

@FindBy(xpath= "//td[3]")
List<WebElement> email;

@FindBy(xpath= "//td[4]")
List<WebElement> mobile;

@FindBy(xpath= "//td[5]")
List<WebElement> course;

@FindBy(xpath= "//td[6]")
List<WebElement> gender;

@FindBy(xpath= "//td[7]")
public List<WebElement> state;

@FindBy(xpath= "//td[8]")
public List<WebElement> delete;

@FindBy(xpath= "//div[@class= 'box']//child::button")
WebElement adduser;

@FindBy(xpath= "//li[@class ='dropdown user user-menu']//child::a")
WebElement logout;


public void MobilenumberLength()
{  
   ArrayList<Integer> l = new ArrayList<Integer>();
   for(int i=0;i<mobile.size(); i++)
   {  
	  l.add(mobile.get(i).getText().length()) ;
   }
 
}
public String readexcel(int i, int j)
{
	String str = null;
  try {
	Workbook wb = Workbook.getWorkbook(new FileInputStream("D:\\OflineSiteData.xls"));
	Sheet sh = wb.getSheet("UserData");
	 Cell cell= sh.getCell(i,j);
	 str = cell.getContents();
	} catch (Exception e) {
		e.printStackTrace();
} 
  
  return str;
}

public boolean Adduserenable()
{
	return adduser.isEnabled();
}

public boolean Logoutenable()
{
	return logout.isEnabled();
}
public ArrayList<String> UserData()
{
		ArrayList<String> act = new ArrayList<String>();
		   
	            for(WebElement e : usersname)
	            {
	              act.add(e.getText());
	            }
	     			
	     		return act;	
	
}

public ArrayList<String> EmailData()
{
		ArrayList<String> act = new ArrayList<String>();
		   
	     
       
	            for(WebElement e : email)
	            {
	              act.add(e.getText());
	            }
	     			
	     		return act;	
	
}

public ArrayList<String> MobileData()
{
		ArrayList<String> act = new ArrayList<String>();
		   
	     
       
	            for(WebElement e : mobile)
	            {
	              act.add(e.getText());
	            }
	     			
	     		return act;	
	
}

public ArrayList<String> CourseData()
{
		ArrayList<String> act = new ArrayList<String>();
		   
	     
       
	            for(WebElement e : course)
	            {
	              act.add(e.getText());
	            }
	     			
	     		return act;	
	
}

public ArrayList<String> GenderData()
{
		ArrayList<String> act = new ArrayList<String>();
		   
	     
       
	            for(WebElement e : gender)
	            {
	              act.add(e.getText());
	            }
	     			
	     		return act;	
	
}

public ArrayList<String> StateData()
{
		ArrayList<String> act = new ArrayList<String>();
		   
	     
       
	            for(WebElement e : state)
	            {
	              act.add(e.getText());
	            }
	     			
	     		return act;	
	
}



}
