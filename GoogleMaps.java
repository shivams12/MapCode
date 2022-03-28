package Cucuember.mavenproject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleMaps {
	
	
	public static void main(String[] args) throws InterruptedException {
        
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/maps");
		driver.findElement(By.id(Pages.searchbox)).sendKeys(TestData.searchtextbox);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Pages.searchbutton)));
		driver.findElement(By.id(Pages.searchbutton)).click();
		String value = "37.7577627,-122.4726194";
		driver.getPageSource().contains(value);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Pages.directions)));
		driver.findElement(By.cssSelector(Pages.directions)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Pages.textboxsearch)));
		driver.findElement(By.cssSelector(Pages.textboxsearch)).sendKeys(TestData.inputtextbox);
		driver.findElement(By.cssSelector(Pages.searchboxclick)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Pages.route)));
		List<WebElement> titles = driver.findElements(By.cssSelector(Pages.route));
		for (int i = 0; i < titles.size(); i++) {
			System.out.println(titles.get(i).getText());
		}
	}

}
