package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		// 1) Load the URL
		driver.get("http://www.leafground.com/pages/sorttable.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table_id']//tr"));
		int rowSize = rows.size();
		System.out.println("No of Rows are : " + rowSize);
		// First get all the values of names store in the List and Sort
		List<String> names = new ArrayList<String>();
		Thread.sleep(2000);
		for (int i = 1; i < rowSize; i++) {
			String text = driver.findElement(By.xpath("//table[@id='table_id']//tr[" + i + "]/td[2]")).getText();
			names.add(text);
		}
		Collections.sort(names);
		System.out.println("The sorted list of names are : " + names);

		// Click on the Name Header
		driver.findElement(By.xpath("//table[@id='table_id']//th[2]")).click();
		System.out.println("Name Header is clicked successfully");
		// Again get all the values and store it in a List
		List<String> names1 = new ArrayList<String>();
		Thread.sleep(2000);
		for (int i = 1; i < rowSize; i++) {
			String text1 = driver.findElement(By.xpath("//table[@id='table_id']//tr[" + i + "]/td[2]")).getText();
			names1.add(text1);
		}
		System.out.println("The  list of names after click on Name Header(Sorting the Name column)  : " + names1);
		// Compare both the list
		if (names.equals(names1))
			System.out.println("Both the list have the Names in Same Order");
		else
			System.out.println("Both the Lists are different order");

	}

}
