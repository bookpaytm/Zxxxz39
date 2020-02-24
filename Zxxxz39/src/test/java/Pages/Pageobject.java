package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Pageobject {
	
	
	
	
	
WebDriver driver;
public Pageobject(WebDriver driver){
	this.driver=driver;
}
//commented the file
@FindBy(name="username") WebElement user;
@FindBy(name="password1") WebElement pass;
@FindBy(id="tdb1") WebElement button;
public void Gcrit(String Uname,String pwd){
	user.sendKeys(Uname);
	pass.sendKeys(pwd);
	button.click();
	
}

}
