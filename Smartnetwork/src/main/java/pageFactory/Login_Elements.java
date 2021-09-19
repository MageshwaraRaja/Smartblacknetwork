package pageFactory;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class Login_Elements {
	public WebDriver driver;
	public Login_Elements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@formcontrolname='userEmail']") private WebElement login_email_field;
	
	@FindBy(xpath="//input[@type='password']") private WebElement login_pwd_field;
		
	@FindBy(xpath="//button[@type='submit']") public WebElement btn_login;
	
	@FindBy(xpath="//button[@id='button-basic']") private WebElement profile_icon;
	
	@FindBy(xpath="//*[@id=\"dropdown-basic\"]/li[3]/a") private WebElement logout_btn;
	
	
	public WebElement enter_email(){
		return login_email_field;
		
	}
	
	public WebElement enter_pwd() {
		return login_pwd_field;
	}
	
	public WebElement click_login() {
		return btn_login;
	}
	
	
	public WebElement click_profileIcon() {
		return profile_icon;
	}
	
	public WebElement click_logout() {
		return logout_btn;
	}
	
	
	
}
