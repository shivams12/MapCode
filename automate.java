package Cucuember.mavenproject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class automate {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/maps");
		driver.findElement(By.id("searchboxinput")).sendKeys("San Francisco, California");
		Thread.sleep(1000);
		driver.findElement(By.id("searchbox-searchbutton")).click();
		Thread.sleep(2000);
		String value = "37.7577627,-122.4726194";
		driver.getPageSource().contains(value);
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("img[alt='Directions']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("div[id='sb_ifc51']>input")).sendKeys("chico");
		driver.findElement(By.cssSelector("div[id='directions-searchbox-0']>button:nth-of-type(1)")).click();
		Thread.sleep(2000);
		
		List<WebElement> titles = driver.findElements(By.cssSelector("div[class='siAUzd-neVct']>div"));
		for(int i=0; i<titles.size();i++) {
			System.out.println(titles.get(i).getText());
		}
	}

}
