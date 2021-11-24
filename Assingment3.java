package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assingment3 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		//1) Load the URL 1) Open https://www.myntra.com/
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Actions builder = new Actions(driver);
		// 2) Mouse hover on MeN 
		WebElement men = driver.findElement(By.xpath("//a[@data-group='men']"));
		
		builder.moveToElement(men).perform();
		
		//3) Click Jackets
		WebElement jack = driver.findElement(By.xpath("//a[@href='/men-jackets']"));
		builder.click(jack).perform();
		
		// 4)  Find the total count of item
		
		String totalItems = driver.findElement(By.xpath("//div[@class='title-container']//span[1]")).getText();
		String totalItems1 = totalItems.replaceAll("[^0-9]", "");
		System.out.println("Total number of items : " + totalItems1);
		
		//5) Validate the sum of categories count matches
		int count = Integer.valueOf(totalItems1);

		List<String> jacket = new ArrayList<String>();

		List<WebElement> elements = driver.findElements(By.xpath("//span[@class='categories-num']"));

		for (WebElement eachElement : elements) {
			String txt = eachElement.getText();
			txt = txt.replaceAll("[^0-9]", "");
			jacket.add(txt);
		}
		
		int total = 0;
		for (int i = 0; i <= jacket.size() - 1; i++) {
			total = total + Integer.valueOf(jacket.get(i));
		}
		System.out.println("The total Categories count : " + total);

		if (count == total) {
			System.out.println("Sum of categories count matches with the Total Items count");
		} else
			System.out.println("Not Matching");
		//6) Check jackets
		
		driver.findElement(By.xpath("//span[@class='categories-num']/following-sibling::div")).click();
		System.out.println("Successfully Checked Jacket Checkbox ");
			
		// 7) Click + More option under BRAND
		
		driver.findElement(By.xpath("//ul[@class='brand-list']/following-sibling::div")).click();
		System.out.println("Successfully clicked on +More Options ");
		
		// 8 Type Duke and click checkbox
		
		driver.findElement(By.xpath("//input[@class='FilterDirectory-searchInput']")).sendKeys("Duke");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@class='FilterDirectory-count']/following-sibling::div")).click();
		System.out.println("Typed the text as Duck and clicked successfully in Search Textbox ");
		// 9) Close the pop-up x 
		driver.findElement(By.xpath("//ul[@class='FilterDirectory-indices']/following-sibling::span")).click();
		System.out.println("Closed the Pop up window by click on X symbol ");
		
		//10) Confirm all the Coats are of brand Duke
		Thread.sleep(3000);

		List<WebElement> productInfo = driver.findElements(By.xpath("//div[@class='product-productMetaInfo']/h3"));
		Set<String> brandName = new HashSet<String>();
		for (WebElement webElement : productInfo) {
			brandName.add(webElement.getText());

		}
		System.out.println(brandName);

		if (brandName.size() == 1) {
			System.out.println("All Coats are of brand" + brandName);
		}
		System.out.println("Va;idated the Brand Name for showing products");
		// 11) Sort by Better Discount 
		
		WebElement sortBy = driver.findElement(By.xpath("//div[@class='sort-sortBy']"));
		Actions dropdow = new Actions(driver);
		dropdow.moveToElement(sortBy).perform();
		
		//12) Find the price of first displayed item
		String price = driver.findElement(By.xpath("//div[@class='product-price']//span/span")).getText();
		System.out.println("The Price of the First displayed item is : " + price);
		
		//13) Click on the first product
		driver.findElement(By.xpath("//div[@class='product-imageSliderContainer']//img")).click();
		System.out.println("Clikced on the First Product successfully ");
		// Switching Back to Main Window from child window 
		Set<String> handles = driver.getWindowHandles();
		List<String> handlesList = new ArrayList<String>();
		handlesList.addAll(handles);
		driver.switchTo().window(handlesList.get(1));
		System.out.println("Switched to Main window from child window ");
		
		// 14) Click on WishList Now 
		driver.findElement(By.xpath("//span[text()='WISHLIST']")).click();
		
		System.out.println("Clicked on the WishList successfully ");
		//14) Close Browser(driver.close())
		driver.close();
		System.out.println("Window closed successfully ");
	}

}
