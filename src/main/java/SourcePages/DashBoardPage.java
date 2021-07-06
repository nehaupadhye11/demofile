package SourcePages;

import java.io.FileInputStream;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class DashBoardPage extends TestBase {
  @BeforeMethod
  public void setup()
  {
	  initialization();
  }
  public ArrayList<String> header = new ArrayList<String>();
  {
		try {
	  	
			Workbook wb = Workbook.getWorkbook(new FileInputStream("D:\\OflineSiteData.xls"));
			Sheet sh = wb.getSheet("Dashboard");
			int rows = sh.getRows();
								
				for (int j = 0; j < rows; j++){
				Cell cell = sh.getCell(0, j);
				String str = cell.getContents();
				header.add(str);
				}
		} catch (Exception e) {
			System.out.println("Exception");
		}}

	
  public DashBoardPage()
  {
    PageFactory.initElements(driver,this);	
  }
	
   @FindBy(xpath = "//li[2]/a/span")
   WebElement Dashboard;
   
   @FindBy(xpath = "//li[3]/a/span")
   WebElement Users;
   
   @FindBy(xpath = "//li[4]/a/span")
   WebElement Operators;
   
   @FindBy(xpath = "//li[5]/a/span")
   WebElement Usefullinks;
   
   @FindBy(xpath = "//li[6]/a/span")
   WebElement Downloads;

   @FindBy(xpath = "//li[7]/a/span")
   WebElement Logout;
   
   @FindBy(xpath = "//div[1]/div/div[2]")
   WebElement seleniumicon;
   
   public UserPage Usersclick()
   {
       Users.click();
       return new UserPage();
   }
   
   public OperatorsPage Operatorclick()
   {
	   Operators.click();
       return new OperatorsPage();
   }
   
   public UsefulLinkPage Usefullinkpageclick()
   {
	   Usefullinks.click();
       return new UsefulLinkPage();
   }

   public DownloadPage Downloadpageclick()
   {
	   Downloads.click();
       return new DownloadPage();
   }
   
   public String Validatingheaders(int i)
   {
         return	driver.findElement(By.xpath("//div["+i+"]/div/div[1]/h3")).getText();   
   }
   
public boolean Seleniumiconactive()
{
    return seleniumicon.isDisplayed();
 }




}
