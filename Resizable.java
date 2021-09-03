package week4.day2.assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Resizable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver select=new ChromeDriver();
		select.get("https://jqueryui.com/resizable/");
		select.manage().window().maximize();
		select.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		
		WebElement frame1 = select.findElement(By.xpath("//iframe[@src=\"/resources/demos/resizable/default.html\"]"));
		
select.switchTo().frame(frame1);


WebElement resize = select.findElement(By.xpath("//div[@class=\"ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se\"]"));
Actions a=new Actions(select);
a.dragAndDropBy(resize, 100, 150).perform();
	}

}
