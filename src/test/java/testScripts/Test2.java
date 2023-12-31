package testScripts;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;
import pomPages.HomePage;

public class Test2  extends BaseClass{
	@Test
	public void test2() {
		SoftAssert soft = new SoftAssert();
		
		HomePage.clickGears();
		home.clickSkillraryDemoApp();
		web.handleChildBrowser();
		
		soft.assertEquals(demoApp.getPageHeader(), "SkillRary-ECommerce");
		
		demoApp.selectCategory(web, 1);
		
		soft.assertEquals(testing.getPageHeader(),"Testing");
		
		web.dragAndDropElement(testing.getSeleniumImage(), 
				testing.getCartArea());
		web.scrollTillElement(testing.getFacebookIcon());
		testing.clickFacebookIcon();
		
		soft.assertAll();
	}

}
