package pageFactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Register_Elements {
	public WebDriver driver;
	public String excelpath = "src/test/resources/TestData.xlsx";

	public Register_Elements(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="/html/body/app-root/app-login/section/div/div/div[2]/div/div[2]/ul/li[2]") private WebElement register_tab;
	
	@FindBy(xpath="//input[@formcontrolname='firstName']") private WebElement fname_field;
	
	@FindBy(xpath="//input[@formcontrolname='lastName']") private WebElement lname_field;
	
	@FindBy(xpath="//input[@formcontrolname='userName']") private WebElement username_field;
	
	@FindBy(xpath="//input[@formcontrolname='email']") private WebElement reg_email_field;
	
	@FindBy(xpath="//input[@formcontrolname='password']") private WebElement reg_pwd_field;
	
	@FindBy(xpath="//input[@formcontrolname='confirmPassword']") private WebElement cpwd_field;
	
	@FindBy(xpath="//div[@class='custom-control custom-switch float-right']") private WebElement agree_check;
	
	@FindBy(xpath="//button[@type='submit']") private WebElement register_btn;
	
	@FindBy(xpath="/html/body/modal-container/div/div/div[1]/div/button") private WebElement skip_button;
	
	public WebElement click_registerTab() {
		return register_tab;
		
	}
	
	public WebElement enter_fname() {
		return fname_field;
		
	}
	
	public WebElement enter_lname() {
		return lname_field;
		
	}
	
	
	public WebElement enter_username() {
		return username_field;
		
	}
	
	public WebElement enter_regmail() {
		return reg_email_field;
		
	}
	
	public WebElement enter_reg_password() {
		return reg_pwd_field;
		
	}
	
	public WebElement enter_reg_cpassword() {
		return cpwd_field;
		
	}
	
	public WebElement click_agree_check() {
		return agree_check;
		
	}
	
	public WebElement click_register() {
		return register_btn;
		
	}
	
	public WebElement click_skip() {
		return skip_button;
		
	}
	
	
	
	
	
	
	
}