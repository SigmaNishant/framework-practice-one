package genericLibraries;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtility {
	
	private WebDriver driver;
	private Actions a;
	private Select s;
	public WebDriver openApplication(String browser, String url, long time)  {
		switch(browser)    {
		case"chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		case"firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		case"edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
			
		default:
			System.out.println("Invalid Browser data");
			
		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(time , TimeUnit.SECONDS);
		return driver;
	}
	
	public WebElement explicitWait(WebElement element, long time)   {
		WebDriverWait wait = new WebDriverWait(driver, time);
		WebElement e = wait.until(ExpectedConditions.visibilityOf(element));
		return e;
	}
	public void mouseHover(WebElement element  ) {
		a = new Actions(driver);
		a.moveToElement(element).perform();
	}
	
	public void doubleClickonElelement(WebElement element)   {
		a = new Actions(driver);
		a.doubleClick(element).perform();
		}
	public void rightClick(WebElement element)  {
		a = new Actions(driver);
		a.contextClick(element).perform();
	}
	
	public void dragAndDropElement(WebElement element, WebElement target)   {
	   a = new Actions(driver);
	   a.dragAndDrop(element,target).perform();
   }
	
	public void dropdown(WebElement element, int index)    {
		s = new Select(element);
		s.selectByIndex(index);
	
	}
     
	public void dropdown(WebElement element, String value)   {
		s = new Select(element);
		s.selectByValue(value);
		
	}
	
	public void dropdown(String text , WebElement element)   {
		s = new Select(element);
		s.selectByVisibleText(text);
		
				
	}
	
	public void switchToFrame(int index)  {
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame1(String nameOrId)    {
		driver.switchTo().frame(nameOrId);
		
		}
	
	public void switchToFrame(String frameElement)  {
		driver.switchTo().frame(frameElement);
		
	}
	
	public void switchBackFromFrame()  {
		driver.switchTo().defaultContent();
		}
    
	public void scrollTillElement(WebElement element)   {
		JavascriptExecutor js =  (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",element);
		
	}
	
	public void takesScreenshot(JavaUtility javaUtil)   {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(null);
		File dest = new File("./elementpic.png");
		try {
			FileUtils.copyFile(src,dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	 public void handleAlert(String status)
	 {
		 Alert a1 = driver.switchTo().alert();
		 if(status.equalsIgnoreCase("ok"))
			 a1.accept();
		 else
			 a1.dismiss();
		  }
	 
	 public void handleChildBrowser()
	 {
		 Set<String> set = driver.getWindowHandles();
			for(String wId : set)
			{
				driver.switchTo().window(wId);
			}
		}
	 
	 public void closeCurrentTab()
	 {
		 driver.close();
	 }
	 
	 public void quitBrowser()
	 {
		 driver.quit();
	 }
	 
}



