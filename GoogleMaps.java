package Cucuember.mavenproject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleMaps {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/maps");
		driver.findElement(By.id("searchboxinput")).sendKeys("San Francisco, California");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchbox-searchbutton")));
		driver.findElement(By.id("searchbox-searchbutton")).click();
		String value = "37.7577627,-122.4726194";
		driver.getPageSource().contains(value);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[alt='Directions']")));
		driver.findElement(By.cssSelector("img[alt='Directions']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id='sb_ifc51']>input")));
		driver.findElement(By.cssSelector("div[id='sb_ifc51']>input")).sendKeys("chico");
		driver.findElement(By.cssSelector("div[id='directions-searchbox-0']>button:nth-of-type(1)")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='siAUzd-neVct']>div")));
		List<WebElement> titles = driver.findElements(By.cssSelector("div[class='siAUzd-neVct']>div"));
		for (int i = 0; i < titles.size(); i++) {
			System.out.println(titles.get(i).getText());
		}
	}

}
