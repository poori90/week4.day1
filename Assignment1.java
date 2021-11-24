package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//1) Load the URL
		driver.get("http://www.leafground.com/pages/table.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//1)Get the count of number of rows and columns
		
				List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table_id']//tr"));
				int rowSize = rows.size();	
				System.out.println("Row Count : " + rowSize);
				
				List<WebElement> columns = driver.findElements(By.tagName("th"));
				int columnSize = columns.size();	
				System.out.println("Column Count : " + columnSize);			
		
		//2)Get the Progress value of 'Learn to Interact with elements
				String value =
						  driver.findElement(By.xpath("//table[@id='table_id']//tr[3]/td[2]")).getText();
						  System.out.println(" The Progress value of 'Learn to Interact with elements is :  " + value);
						 

		// 3)Check the vital task for the least completed progress
				Set<String> Progress = new TreeSet<String>();
				for (int i = 2; i <=rowSize; i++) {
					String val = driver.findElement(By.xpath("//table[@id='table_id']//tr["+i+"]/td[2]")).getText();
					Progress.add(val);
				}
				List<String> arr = new ArrayList<String>(Progress);
				String least = arr.get(1);
				System.out.println("The Least Completed Progress Value is :" + least);			  
				if(least!=null) 
				  {
				  driver.findElement(By.xpath("(//input[@name='vital'])[3]")).click(); 
				  }
				  System.out.println("The Vital Check Box is clicked successfully for least completed progress");
					
				Thread.sleep(2000);
				driver.close();
				}
				
	}

