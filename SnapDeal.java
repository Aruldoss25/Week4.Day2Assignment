package week4.day2.assignment;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {

	public static void main(String[] args) throws InterruptedException, IOException {
	
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver snapdeal=new ChromeDriver();
		snapdeal.get("https://www.snapdeal.com/");
		snapdeal.manage().window().maximize();
		snapdeal.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		
		
		snapdeal.findElement(By.xpath("//button[@id=\"pushDenied\"]"));
		WebElement hover = snapdeal.findElement(By.xpath("//span[text()=\"Men's Fashion\"]"));
		Actions mouse=new Actions(snapdeal);
		mouse.moveToElement(hover).perform();
		Thread.sleep(200);
		
		//selecting the sports shoe
		
		snapdeal.findElement(By.xpath("//span[text()=\"Sports Shoes\"][1]")).click();
		Thread.sleep(100);
		
		//selecting the training shoes
		
		snapdeal.findElement(By.xpath("//div[text()=\"Training Shoes\"]")).click();
		//sorting the value
		
		snapdeal.findElement(By.xpath("//i[@class=\"sd-icon sd-icon-expand-arrow sort-arrow\"]")).click();
		
		WebElement text = snapdeal.findElement(By.xpath("//ul[@class=\"sort-value\"]/li[2]"));
		text.getText();
		System.out.println(text);
		
		text.click();
		
		WebElement text2 = snapdeal.findElement(By.xpath("//div[contains(text(),'Low To High')]"));
		
		if(text.equals(text2)) {
			System.out.println("The order has been sorted correctly");
		}
		else {
	
			System.out.println("The order was not sorted correctly");
		}
		
		Thread.sleep(2000);
		
		JavascriptExecutor jse=(JavascriptExecutor)snapdeal;
		jse.executeScript("window.scrollBy(0,400)");
		
		
		
		
		WebElement hover1 = snapdeal.findElement(By.xpath("//p[text()=\"Columbus TB-4-White Blue White Training Shoes\"][1]"));
		Actions mouse1=new Actions(snapdeal);
		mouse1.moveToElement(hover1).perform();
		
		snapdeal.findElement(By.xpath("//section[@class=\"js-section clearfix dp-widget  dp-fired\"][2]/div[2]/div[2]/div[2]/div")).click();
		
		Thread.sleep(200);
		String text3 = snapdeal.findElement(By.xpath("//span[@class=\"payBlkBig\"]")).getText();
		System.out.println("The price of the shoe is : "+ text3);
		
		String text4 = snapdeal.findElement(By.xpath("//span[@class=\"percent-desc \"]")).getText();
	  System.out.println("The discount of the product is: "+text4);
	  
	  WebElement snap = snapdeal.findElement(By.xpath("//div[@class=\"sidebarin-content\"]"));
	  
	  TakesScreenshot scrShot =((TakesScreenshot)snap);

		java.io.File Sorce = scrShot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Sorce,new File("./Screenshots/Screen.png"));
		
		System.out.println("Screen shot captured");
		
		

		

	}

}
