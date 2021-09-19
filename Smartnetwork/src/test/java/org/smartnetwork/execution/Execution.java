package org.smartnetwork.execution;


import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import dataProvider.ReadExcel;
import pageFactory.Login_Elements;
import pageFactory.Post_Elements;
import pageFactory.Register_Elements;

import static org.smartnetwork.extentreport.ExtentTestManager.startTest;

public class Execution extends BaseClass {
	
	public String excelpath = "src/test/resources/TestData.xlsx";

	@Test(priority=0, description = "Application login with valid username and password.")
	public void applicationLogin(Method method) {
		startTest(method.getName(), "Application login with valid username and password.");
		try {
			Login_Elements login = new Login_Elements(driver);
			ReadExcel excel = new ReadExcel(excelpath, "Login");
			Map<String, Map<String, String>> data = excel.getExcelAsMap();
			System.out.println(data.get("1").get("Username"));
			login.enter_email().sendKeys(data.get("1").get("Username"));
			login.enter_pwd().sendKeys(data.get("1").get("Password"));
			login.click_login().click();
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOf(login.click_profileIcon()));
			Assert.assertTrue(login.click_profileIcon().isDisplayed());
			File pic2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(pic2, new File("/home/gopinath/Desktop/Workspace/Smartnetwork/target/homepage.png"));
			login.click_profileIcon().click();
			login.click_logout().click();
			Assert.assertTrue(login.click_login().isDisplayed());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test(priority=1, description = "Register into the application")
	public void register(Method method) {	
		startTest(method.getName(), "Register into the application");
		Register_Elements reg = new Register_Elements(driver);
		ReadExcel excel = new ReadExcel(excelpath, "Register");
		try {
			Map<String, Map<String, String>> data = excel.getExcelAsMap();
			String firstname = data.get("1").get("FirstName");
			String lastname =data.get("1").get("LastName");
			String username = data.get("1").get("Username");
			String email=data.get("1").get("Email");
			String password=data.get("1").get("Password");
			String cpassword=data.get("1").get("CPassword");
			reg.click_registerTab().click();
			File pic3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(pic3, new File("/home/gopinath/Desktop/Workspace/Smartnetwork/target/register.png"));
			reg.enter_fname().sendKeys(firstname);
			reg.enter_lname().sendKeys(lastname);
			reg.enter_username().sendKeys(username);
			reg.enter_regmail().sendKeys(email);
			reg.enter_reg_password().sendKeys(password);
			reg.enter_reg_cpassword().sendKeys(cpassword);
			reg.click_agree_check().click();
			reg.click_register().click();
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOf(reg.click_skip()));
			Assert.assertTrue(reg.click_skip().isDisplayed());
			File pic4 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(pic4, new File("/home/gopinath/Desktop/Workspace/Smartnetwork/target/skip.png"));
			reg.click_skip().click();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Test(dependsOnMethods="register", description ="Create post with uploading image and videos")
	public void createPost(Method method) {
		startTest(method.getName(), "Create post with uploading image and videos");

		Post_Elements post = new Post_Elements(driver);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(post.click_createPost()));
		Assert.assertTrue(post.click_createPost().isDisplayed());
		post.click_createPost().click();
		try {
			File pic5 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(pic5, new File("/home/gopinath/Desktop/Workspace/Smartnetwork/target/createpost.png"));
			ReadExcel excel = new ReadExcel(excelpath, "Post");
			Map<String, Map<String, String>> data = excel.getExcelAsMap();
			post.enter_title().sendKeys(data.get("1").get("Title"));
			post.enter_desc().sendKeys(data.get("1").get("Description"));
			String filepath="/home/gopinath/Desktop/Workspace/Smartnetwork/src/test/resources/Files/photo.jpeg";
			post.upload_file().sendKeys(filepath);
			Thread.sleep(10000);
			File pic6 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(pic6, new File("/home/gopinath/Desktop/Workspace/Smartnetwork/target/beforepost.png"));
			post.click_post().click();
			Thread.sleep(5000);
			Assert.assertTrue(post.click_createPost().isDisplayed());
			String title = data.get("1").get("Description");
			post.click_profile().click();
			WebDriverWait wait2 = new WebDriverWait(driver,30);
			wait2.until(ExpectedConditions.visibilityOf(post.mypost()));
			for(WebElement text : post.get_title_text()){
					Assert.assertEquals(text.getText(), title);
					break;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Login_Elements login = new Login_Elements(driver);
		login.click_profileIcon().click();
		login.click_logout().click();
		Assert.assertTrue(login.click_login().isDisplayed());
		
	}

	
}
