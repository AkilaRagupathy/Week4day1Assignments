package week4day1Assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	/*	https://www.leafground.com/window.xhtml
	          Click Open Multiple 
	          Get the size of available Windows
	          switch to last window 
	          Get the Title of the Window
	           Close all the windows except last window */
		
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		 driver.get("https://www.leafground.com/window.xhtml");
		 driver.manage().window().maximize();
		 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		 driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
		 Set<String> windowHandles = driver.getWindowHandles();
			System.out.println(windowHandles.size());
			
			List<String> window=new ArrayList<String>(windowHandles);
			driver.switchTo().window(window.get(2));
        
			System.out.println(driver.getTitle());
			
			driver.switchTo().window(window.get(0));
			driver.close();
			
			driver.switchTo().window(window.get(1));
			driver.close();
			
			
			
	}
	

}
