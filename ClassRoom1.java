package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassRoom1 {

	public static void main(String[] args) throws InterruptedException {
//		Set the system property and Launch the URL
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		//1) Load the URL    1. Load https://erail.in/
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));		
//		Click the 'sort on date' checkbox
		
		if (driver.findElement(By.xpath("//input[@id='chkSelectDateOnly']")).isSelected())
			driver.findElement(By.xpath("//input[@id='chkSelectDateOnly']")).click();
			System.out.println(" Sort On Date Checkbox is Selected ");
		
//		clear the existing text from station text field
			driver.findElement(By.id("txtStationFrom")).clear();
			System.out.println("Station from textbox is cleared successfully ");
		
//		type "ms"in the from station text field
			driver.findElement(By.id("txtStationFrom")).sendKeys("ms");
			System.out.println("sendkeys the value as ms to from Station text box");
			Thread.sleep(1000);
		
//		tab in the from station text field
			driver.findElement(By.id("txtStationFrom")).sendKeys(Keys.ENTER);
			System.out.println("selecting the from station value from dropdown");
		
//		clear the existing text in the to station text field
			driver.findElement(By.id("txtStationTo")).clear();
			System.out.println("Station to textbox is cleared successfully ");
		
//		type "mdu" in the to station text field
			driver.findElement(By.id("txtStationTo")).sendKeys("mdu");
			System.out.println("sendkeys the value as mdu to To Station text box");
			Thread.sleep(1000);
		
//		tab in the to station text field
			driver.findElement(By.id("txtStationTo")).sendKeys(Keys.ENTER);
			System.out.println("selecting the To station value from dropdown");
		
//		Add a java sleep for 2 seconds
			Thread.sleep(2000);

//			Store all the train names in a list		
			List<WebElement> rows = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr"));
//			Get the size of list		
			int rowSize = rows.size();
			System.out.println("Printing the list size:" + rowSize);
			
			List<String> trainNames=new ArrayList<String>();
			
			for(int i=1;i<=rowSize;i++)
			{
				String text=driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr["+i+"]/td[2]")).getText();
				trainNames.add(text);
			
			}
//			Add the list into a new Set			
			Set<String> trainSet=new LinkedHashSet<String>(trainNames);
//			Get the size of set	
			int setSize=trainSet.size();
			System.out.println("Printing the train set size:"+ setSize);
//			Compare the Size of list and Set to verify the names are unique
			if(rowSize==setSize)
				System.out.println("No duplicates in Train Names");
			else
				System.out.println("There are duplicate Train Names");		
			driver.close();		

	}

}
