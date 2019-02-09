package task1;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Challenge1 {

	static WebDriver driver;

	public static void main(String[] args) {
		String projectpath = System.getProperty("user.dir");
		System.out.println("Projectpath is " + projectpath);

		//chrome driver initialization
		System.setProperty("webdriver.chrome.driver", projectpath +"//drivers//chromedriver//chromedriver.exe");
		driver = new ChromeDriver();

		//wait and size
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//wait = new WebDriverWait(driver,30);

		//get url
		String url = "http://hpa.services/automation-challenge/";
		driver.get(url);

		driver.findElement(By.id("Box1")).click();
		isAlertPresent();
		
		driver.findElement(By.id("Box3")).sendKeys(Keys.TAB);
		isAlertPresent();

		driver.findElement(By.id("Box2"));
		String optionVal = driver.findElement(By.id("optionVal")).getText();
		System.out.println(optionVal);

		//int i = 1;

		//if(optionVal.equals(i)) {
			driver.findElement(By.xpath("//*[@id=\"Box2\"]/input[1]")).click();
		//}
		/*else{
			driver.findElement(By.xpath("//*[@id=\"Box2\"]/input[2]")).click();
		}*/
		
		isAlertPresent();
		
		String drpdowntxt = driver.findElement(By.id("selectionVal")).getText();
		System.out.println(drpdowntxt);
		
		Select drpCountry = new Select(driver.findElement(By.xpath("//*[@id=\"BoxParagraph4\"]/select")));
		drpCountry.selectByVisibleText(drpdowntxt);
		isAlertPresent();
		
		driver.findElement(By.id("formDate")).sendKeys("2017-05-04");
		driver.findElement(By.id("formCity")).sendKeys("Nashville");
		driver.findElement(By.id("formState")).sendKeys("Tennessee");
		driver.findElement(By.id("formCountry")).sendKeys("USA");
		
		driver.findElement(By.xpath("//tbody//tr[5]//td[1]//input[1]")).sendKeys("2009-08-26");
		driver.findElement(By.xpath("//tbody//tr[6]//td[1]//input[1]")).sendKeys("Seattle");
		driver.findElement(By.xpath("//tbody//tr[7]//td[1]//input[1]")).sendKeys("Washington");
		driver.findElement(By.xpath("//tbody//tr[8]//td[1]//input[1]")).sendKeys("USA");
		driver.findElement(By.xpath("//tbody//tr[9]//td[1]//input[1]")).sendKeys("2007-10-10");
		
		driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
		isAlertPresent();
		
		String result = driver.findElement(By.id("formResult")).getText();
		System.out.println(result);
		
		String linenum = driver.findElement(By.xpath("//*[@id=\"lineNum\"]")).getText();
		System.out.println(linenum);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 WebElement Element = driver.findElement(By.xpath("//*[@id=\"lineNum\"]"));
		 js.executeScript("arguments[0].scrollIntoView();", Element);
		 
		 
		System.out.println("Completed");
	}
	
	public static boolean isAlertPresent(){

		boolean presentFlag = false;

		try {
			Alert alert = driver.switchTo().alert();
			presentFlag = true;
			alert.accept();

		} catch (NoAlertPresentException ex) {
			ex.printStackTrace();
		}
		return presentFlag;
	}
}