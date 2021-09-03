package week4.day2.assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectable {

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver select=new ChromeDriver();
		select.get("http://www.leafground.com/pages/selectable.html");
		select.manage().window().maximize();
		select.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		
		
		WebElement source = select.findElement(By.xpath("//li[text()=\"Item 1\"]"));
		WebElement destination = select.findElement(By.xpath("//li[text()=\"Item 4\"]"));
		
		Actions selecting=new Actions(select);
		selecting.dragAndDrop(source, destination).perform();
	}

}
