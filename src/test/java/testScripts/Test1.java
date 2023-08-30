package testScripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;
import pomPages.HomePage;


public class Test1 extends BaseClass {
	
	@Test
	public void test1() throws InterruptedException {
		SoftAssert soft = new SoftAssert();
		
		HomePage.clickGears();
		home.clickSkillraryDemoApp();
		web.handleChildBrowser();
		soft.assertEquals(demoApp.getPageHeader(), "SkillRary-ECommerce");
		
		demoApp.mouseHoverTocourse(web);
		demoApp.clickSeleniumTraining();
		
		soft.assertEquals(selenium.getPageHeader(), "Selenium Training");
		selenium.doubleClickPlusButton(web);
		selenium.clickAddToCart();
		
		web.handleAlert("OK");
		Thread.sleep(2000);
		soft.assertEquals(selenium.getItemAddedMessage(),"Item added to cart");
		
		soft.assertAll();
	}

}
