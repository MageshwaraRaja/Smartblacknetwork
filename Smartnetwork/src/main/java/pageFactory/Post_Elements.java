package pageFactory;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Post_Elements {
	public String excelpath = "src/test/resources/TestData.xlsx";
	public Post_Elements(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@class='btn btn-yellow btn-block pt9 pb9 px-3 br-10 fs13 fw-500']")
	private WebElement createPost;
	
	@FindBy(xpath="//*[@formcontrolname='postTitile']") private WebElement title_txt;
	
	@FindBy(xpath="//*[@formcontrolname='postDescription']") private WebElement desc_txt;
	
	@FindBy(xpath="//input[@type='file']") private WebElement add_file;
	
	@FindBy(xpath="//button[@class='btn btn-yellow fw-600 btn-block fs14 br-10 px-3 px-md-4 py-2']")
	private WebElement post_btn;
	
	@FindBy(xpath="//div[@class='profile-img']") private WebElement profile;
	
	@FindBy(xpath="//h5[@class='text-center fs12 color-grey-u fw-500 mb-0']") private WebElement mypost;
	
	@FindBy(xpath="//p[@class='fs10 text-white my-2 ng-star-inserted']") private List<WebElement> get_title;
	
	public WebElement click_createPost() {
		return createPost;
		
	}
	
	public WebElement enter_title() {
		return title_txt;
		
	}
	
	public WebElement enter_desc() {
		return desc_txt;
		
	}
	
	public WebElement upload_file() {
		return add_file;
		
	}
	
	public WebElement click_post() {
		return post_btn ;
		
	}
	
	public WebElement click_profile() {
		return profile ;
		
	}
	
	public WebElement mypost() {
		return mypost ;
		
	}
	
	public List<WebElement> get_title_text(){
		return get_title;
		
	}
	
	
	
	
}
