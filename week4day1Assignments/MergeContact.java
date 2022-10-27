package week4day1Assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Click on CRM/SFA Link
		 * 
		 * 5. Click on contacts Button
		 * 
		 * 6. Click on Merge Contacts using Xpath Locator
		 * 
		 * 7. Click on Widget of From Contact
		 * 
		 * 8. Click on First Resulting Contact
		 * 
		 * 9. Click on Widget of To Contact
		 * 
		 * 10. Click on Second Resulting Contact
		 * 
		 * 11. Click on Merge button using Xpath Locator
		 * 
		 * 12. Accept the Alert
		 * 
		 * 13. Verify the title of the page
		 */

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leaftaps.com/opentaps/control/login");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.id("username")).sendKeys("demosalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();

		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//a[@href='/crmsfa/control/mergeContactsForm']")).click();

		driver.findElement(By.xpath("//img[@src='/images/fieldlookup.gif']")).click();

		Set<String> windowHandles = driver.getWindowHandles();
		//System.out.println(windowHandles.size());

		List<String> window = new ArrayList<String>(windowHandles);
		driver.switchTo().window(window.get(1));

		//System.out.println(driver.getTitle());

		driver.findElement(By.xpath("//a[@class='linktext']")).click();

		driver.switchTo().window(window.get(0));

		driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[2]")).click();

		Set<String> windowHandles1 = driver.getWindowHandles();
		//System.out.println(windowHandles1.size());

		List<String> window1 = new ArrayList<String>(windowHandles1);
		driver.switchTo().window(window1.get(1));

		//System.out.println(driver.getTitle());

		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[2]")).click();

		driver.switchTo().window(window.get(0));
		driver.findElement(By.linkText("Merge")).click();

		Alert alert = driver.switchTo().alert();

		alert.accept();

		System.out.println(driver.getTitle());

	}

}
