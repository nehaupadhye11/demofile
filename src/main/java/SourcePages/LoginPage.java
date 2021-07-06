package SourcePages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeSuite;

public class LoginPage extends TestBase {

@BeforeSuite
public void setup()
{
		initialization();
	}
@FindBy(id = "email")
WebElement email; 
	
@FindBy(id = "password") 
WebElement password;

@FindBy(xpath = "//button")
WebElement button;

@FindBy(xpath = "//img")
WebElement image;

@FindBy(partialLinkText = "Register a new")
WebElement link;

@FindBy(id = "email_error")
WebElement emaillabel;

@FindBy(id = "password_error")
WebElement passwordllabel;

public LoginPage()
{
  PageFactory.initElements(driver,this);	
}

public String Emaillabeltext()
 {
	return(emaillabel.getText());
 }
public String Passwordlabeltext()
{
	return(passwordllabel.getText());
}
public void EnterDetails(String uname ,String pass)
{
	email.sendKeys(uname);
    password.sendKeys(pass);
    button.click();
}
public String Registerlink()
{
 link.click();
 return(driver.getTitle());
}

public DashBoardPage ValidLogin()
{
	email.sendKeys("kiran@gmail.com");
	password.sendKeys("123456");
	button.click(); 
	return new DashBoardPage();
   }

public void Cleardata()
{ 
	email.clear();
	password.clear();
	}
public boolean Imagevisible()
{  
    return(image.isDisplayed());	
}
}
