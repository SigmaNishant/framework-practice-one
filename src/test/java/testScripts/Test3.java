package testScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;
import pomPages.HomePage;


public class Test3 extends BaseClass {
	
	@Test
	public void test3() {
		SoftAssert soft = new SoftAssert();

		HomePage.clickGears();
		home.clickSkillraryDemoApp();
		web.handleChildBrowser();

		soft.assertEquals(demoApp.getPageHeader(), "SkillRary-ECommerce");
		
		web.scrollTillElement(demoApp.getContactUs());
		demoApp.clickContactUs();
		
		soft.assertTrue(contact.getContactUsIcon().isDisplayed());
		
		Map<String,String> map = excel.readData("Sheet1");
		contact.sendContactInfo(map.get("Full Name"), map.get("Email"),
				map.get("Subject"), map.get("Message"));
		
		soft.assertAll();
	}


}
