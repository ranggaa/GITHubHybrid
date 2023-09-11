/*Project Name: Primus bank
 * Modules: Login,Branchcreation,branchUpdation,Logout
 * Author: Ranga
 * Creation Date: 8/25/2023
  */
package commonFunctions;
import org.checkerframework.common.util.report.qual.ReportCall;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import config.AppUtil;
public class FunctionLibrary extends AppUtil{
//method for Login
public static boolean adminLogin(String username,String password)
{
	driver.findElement(By.xpath(conpro.getProperty("ObjUser"))).sendKeys(username);
	driver.findElement(By.xpath(conpro.getProperty("ObjPass"))).sendKeys(password);
	driver.findElement(By.xpath(conpro.getProperty("ObjLogin"))).click();
	String Expected="adminflow";
	String Actual =driver.getCurrentUrl();
	if(Actual.toLowerCase().contains(Expected.toLowerCase()))
	{
		Reporter.log("Admin Login success::"+Expected+"      "+Actual,true);
		return true;
	}
	else
	{
		Reporter.log("Admin Login Fail::"+Expected+"      "+Actual,true);
		return false;
	}
	
}
//method for branches button
public static void branchesButton()
{
	driver.findElement(By.xpath(conpro.getProperty("ObjBranches"))).click();
}
//method for branch creation
public static boolean branchCreation(String BranchName,String Address1,String Address2,String Address3,
		String Area,String Zipcode,String Country,String State,String City) throws Throwable
{
	driver.findElement(By.xpath(conpro.getProperty("ObjNewBranch"))).click();
	driver.findElement(By.xpath(conpro.getProperty("ObjBranchName"))).sendKeys(BranchName);
	driver.findElement(By.xpath(conpro.getProperty("ObjAddress1"))).sendKeys(Address1);
	driver.findElement(By.xpath(conpro.getProperty("ObjAddress2"))).sendKeys(Address2);
	driver.findElement(By.xpath(conpro.getProperty("ObjAddress3"))).sendKeys(Address3);
	driver.findElement(By.xpath(conpro.getProperty("ObjArea"))).sendKeys(Area);
	driver.findElement(By.xpath(conpro.getProperty("ObjZipcode"))).sendKeys(Zipcode);
	new Select(driver.findElement(By.xpath(conpro.getProperty("ObjCountry")))).selectByVisibleText(Country);
	new Select(driver.findElement(By.xpath(conpro.getProperty("ObjState")))).selectByVisibleText(State);
	new Select(driver.findElement(By.xpath(conpro.getProperty("Objcity")))).selectByVisibleText(City);
	driver.findElement(By.xpath(conpro.getProperty("Objsubmit"))).click();
	//capture alert text
	String Expected = driver.switchTo().alert().getText();
	Thread.sleep(5000);
	driver.switchTo().alert().accept();
	String Actual ="New Branch with id";
	if(Expected.toLowerCase().contains(Actual.toLowerCase()))
	{
		Reporter.log(Expected,true);
		return true;
	}
	else
	{
		Reporter.log("Fail to Create New Branch",true);
		return false;
	}
	
}
//method for branch updation
public static boolean branchUpdate(String BranchName,String Address,String Area, String Zipcode) throws Throwable
{
	driver.findElement(By.xpath(conpro.getProperty("ObjEdit"))).click();
	WebElement element1 =driver.findElement(By.xpath(conpro.getProperty("ObjBranch")));
	element1.clear();
	element1.sendKeys(BranchName);
	WebElement element2 =driver.findElement(By.xpath(conpro.getProperty("ObjAddress")));
	element2.clear();
	element2.sendKeys(Address);
	WebElement element3 =driver.findElement(By.xpath(conpro.getProperty("ObjAreaName")));
	element3.clear();
	element3.sendKeys(Area);
	WebElement element4 =driver.findElement(By.xpath(conpro.getProperty("Objzip")));
	element4.clear();
	element4.sendKeys(Zipcode);
	driver.findElement(By.xpath(conpro.getProperty("ObjUpdate"))).click();
	Thread.sleep(4000);
	String Expected_Alert =driver.switchTo().alert().getText();
	Thread.sleep(4000);
	driver.switchTo().alert().accept();
	String Actual_Alert ="Branch updated Sucessfully";
	if(Expected_Alert.equalsIgnoreCase(Actual_Alert))
	{
		Reporter.log(Expected_Alert,true);
		return true;
	}
	else
	{
		Reporter.log("Fail to Update Branch",true);
		return false;
	}
}
//method for logout
public static boolean adminLogout()
{
	driver.findElement(By.xpath(conpro.getProperty("ObjLogout"))).click();
	if(driver.findElement(By.xpath(conpro.getProperty("ObjLogin"))).isDisplayed())
	{
		Reporter.log("Admin Logout Success",true);
		return true;
	}
	else
	{
		Reporter.log("Admin Logout Fail",true);
		return false;
	}
	
}
}

















