package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassRoom2 {

	private static WebElement qv;

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		//1) Load the URL    1. Load https://www.snapdeal.com/
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//	2. Mouse hover on Men's Fashion and Click Shirts
		
		WebElement men = driver.findElement(By.linkText("Men's Fashion"));
		Actions builder = new Actions(driver);
		builder.moveToElement(men).perform(); 
		System.out.println("Move Over to Men's Fashion is successfull ");
		WebElement shirt = driver.findElement(By.linkText("Shirts"));
		builder.click(shirt).perform();
		System.out.println("Click on the Shirts is successfull");
		
		//	3. Mouse hover on the first product and Click on Quick View
		WebElement img = driver.findElement(By.xpath("//picture[@class='picture-elem']//img"));
		builder.moveToElement(img).perform();
		System.out.println("Move over on first Image is successfull ");
		WebElement qv = driver.findElement(By.xpath("//div[@class='clearfix row-disc']//div"));
		Thread.sleep(5000);
		builder.click(qv).perform();
		System.out.println("Click on Quick view of First Image is successfull ");
		
		//	4. Close all the browsers
		driver.quit();
		System.out.println("Closed all the browsers using Quit method in selenium ");

	}

}
