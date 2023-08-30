package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	//Declaration
	@FindBy(xpath = "//img[@alt='SkillRary']")
	private WebElement logo;

	@FindBy(name = "q")
	private WebElement searchTF;
	@FindBy(xpath = "//input[@value='go']")
	private WebElement searchButton;
	@FindBy(xpath = "//a[text()=' GEARS ']")
	private static WebElement gearsTab;

	@FindBy(xpath = "//ul[@class='droupdown-menu gear_menu']/descendant::a[text()=' SkillRary Demo APP']")
	private WebElement skillraryDemoAppLink;

	//Initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getLogo() {
		return logo;
	}

	public HomePage(WebElement logo, WebElement searchTF, WebElement searchButton, WebElement skillraryDemoAppLink) {
		super();
		this.logo = logo;
		this.searchTF = searchTF;
		this.searchButton = searchButton;
		this.skillraryDemoAppLink = skillraryDemoAppLink;
	}

	public void searchFor(String data) {
		searchTF.sendKeys(data);
		searchButton.click();
	}

	public static void clickGears() {
		try {
			gearsTab.click();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	public void clickSkillraryDemoApp() {
		skillraryDemoAppLink.click();
	}

}
