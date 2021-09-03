package week4.day2.assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Draggable2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver select=new ChromeDriver();
		select.get("https://jqueryui.com/draggable/");
		select.manage().window().maximize();
		select.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		
		WebElement frame1 = select.findElement(By.xpath("//iframe[@src=\"/resources/demos/draggable/default.html\"]"));
	select.switchTo().frame(frame1);
		
		
		WebElement source = select.findElement(By.xpath("//p[text()=\"Drag me around\"]"));
	
		
		Actions selecting=new Actions(select);
		selecting.dragAndDropBy(source, 100, 100).perform();

	}

}
