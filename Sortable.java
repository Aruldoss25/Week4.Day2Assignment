package week4.day2.assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortable {

	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		ChromeDriver sort=new ChromeDriver();
		sort.get("http://www.leafground.com/pages/sortable.html");
		sort.manage().window().maximize();
		WebElement table = sort.findElement(By.xpath("//div[@id=\"mydiv\"]/ul"));
		List<WebElement> webColumn = table.findElements(By.tagName("li"));
		System.out.println(webColumn.size());
		
for(WebElement st:webColumn) {
	String text=st.getText();
	System.out.println("The element in the text is :"+text);

	
		
		

	}

}
}
