package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Pageobject {
	
	
	
	
	
WebDriver driver;
//this is new comment by parveen
public Pageobject(WebDriver driver){
	this.driver=driver;
}
@FindBy(name="username1") WebElement user;
@FindBy(name="password") WebElement pass;
@FindBy(id="tdb1") WebElement button;
public void Gcrit(String Uname,String pwd){
	user.sendKeys(Uname);
	pass.sendKeys(pwd);
	button.click();
	
}

}
