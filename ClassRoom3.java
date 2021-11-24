package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassRoom3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		// Load Url 
		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		// select "Selenium" and "Loadrunner" from the multi select combo box using actions class
		Actions builder = new Actions(driver);
		Thread.sleep(5000);
		WebElement item1 = driver.findElement(By.xpath("//div[@class='example'][6]/select[1]/option[2]"));
		WebElement item2 = driver.findElement(By.xpath("//div[@class='example'][6]/select[1]/option[5]"));
		
		builder.keyDown(Keys.CONTROL).click(item1).click(item2).keyUp(Keys.CONTROL).perform();
		System.out.println("Both the drop down values selected successfully using Action Class ");

	}

}
