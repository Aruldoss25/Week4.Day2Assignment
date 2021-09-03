package week4.day2.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nyka {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriverManager.chromedriver().setup();
		ChromeDriver nyka=new ChromeDriver();
		nyka.get("https://www.nykaa.com/");
		nyka.manage().window().maximize();
		nyka.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		
		WebElement hover1 = nyka.findElement(By.xpath("//a[text()=\"brands\"]"));
		Actions hover=new Actions(nyka);
		hover.moveToElement(hover1).perform();
		
		WebElement hover2 = nyka.findElement(By.xpath("//a[text()=\"Popular\"]"));
		Actions hoverClick=new Actions(nyka);
		hoverClick.moveToElement(hover2).perform();
		
		
		WebElement element1 = nyka.findElement(By.xpath("//img[@src=\"https://adn-static2.nykaa.com/media/wysiwyg/2019/lorealparis.png\"]"));
		element1.click();
		
		//moving to Lorel
		
		Set<String> windowSet = nyka.getWindowHandles();
		List<String> windowList=new ArrayList<String>(windowSet);
		nyka.switchTo().window(windowList.get(1));
		
		
		WebElement dropdown = nyka.findElement(By.xpath("//span[text()=\"Sort By : \"]"));
		dropdown.click();
		
		nyka.findElement(By.xpath("//div[@class=\"sort-container show-sort\"]/div[4]/div/div")).click();
		
		Thread.sleep(2000);
		
		//Selecting shampoo
		nyka.findElement(By.xpath("//div[@class=\"pull-right filter-options-toggle\"][1]/i[1]")).click();
		Thread.sleep(200);
		nyka.findElement(By.xpath("//div[@class=\"filter-options-toggle\"][1]")).click();
		Thread.sleep(200);
		nyka.findElement(By.xpath("//li[@class=\"filter-list-header  \"][1]/div[2]")).click();
		Thread.sleep(200);
		nyka.findElement(By.xpath("//label[@for=\"chk_Shampoo_undefined\"]/div")).click();
		Thread.sleep(200);
		String text = nyka.findElement(By.xpath("//div[@class=\"filter-applied\"]/following-sibling::ul/li")).getText();
        System.out.println("The filter applied is : "+ text);
        Thread.sleep(2000);
        
        //Clicking the shampoo
        nyka.findElement(By.xpath("//span[text()=\"L'Oreal Paris Colour Protect Shampoo\"]")).click();
	
		
		
		Set<String> window2Set=nyka.getWindowHandles();
		List<String> windows2List=new ArrayList<String>(window2Set);
		WebDriver window2 = nyka.switchTo().window(windows2List.get(2));
		String title = window2.getTitle();
		System.out.println("The second page is : "+title);
		
		nyka.findElement(By.xpath("//span[text()=\"175ml\"]")).click();
		
		//printing the price
		String text2 = nyka.findElement(By.xpath("//span[@class=\"post-card__content-price-price\"][1]/following-sibling::span[1]")).getText();
	System.out.println("The price of the product is: "+text2);
	
	
//adding to the bag
	nyka.findElement(By.xpath("//button[@class=\"combo-add-to-btn prdt-des-btn js--toggle-sbag nk-btn nk-btn-rnd atc-simple m-content__product-list__cart-btn  \"][1]")).click();
	Thread.sleep(500);
	
	nyka.findElement(By.xpath("//div[@class=\"AddBagIcon\"]")).click();
	Thread.sleep(500);
	
	WebElement frame = nyka.findElement(By.xpath("//iframe[@style=\"position: fixed; display: block; bottom: 0px; text-align: left; z-index: 2147483647; background-color: rgb(0, 0, 0); overflow: hidden; border-width: 2px 0px 0px; border-top-style: solid; border-right-style: initial; border-bottom-style: initial; border-left-style: initial; border-top-color: rgb(245, 245, 245); border-right-color: initial; border-bottom-color: initial; border-left-color: initial; border-image: initial; height: 34px; box-sizing: content-box; width: 100%; visibility: visible;\"]"));
	nyka.switchTo().frame(frame);
	
	nyka.findElement(By.xpath("//div[@class=\"centerwrap\"]/div[1]")).click();
	nyka.switchTo().defaultContent();
	
	
	String text3 = nyka.findElement(By.xpath("//div[@class=\"value medium-strong\"]")).getText();
	
	System.out.println("The grand total amount : "+ text3);
	Thread.sleep(200);
	
	WebElement frame1 = nyka.findElement(By.xpath("//iframe[@style=\"position: fixed; display: block; bottom: 0px; text-align: left; z-index: 2147483647; background-color: rgb(0, 0, 0); overflow: hidden; border-width: 2px 0px 0px; border-top-style: solid; border-right-style: initial; border-bottom-style: initial; border-left-style: initial; border-top-color: rgb(245, 245, 245); border-right-color: initial; border-bottom-color: initial; border-left-color: initial; border-image: initial; height: 34px; box-sizing: content-box; width: 100%; visibility: visible;\"]"));
	nyka.switchTo().frame(frame1);
	
	nyka.findElement(By.xpath("//div[@class=\"centerwrap\"]/div[1]")).click();
	nyka.switchTo().defaultContent();
	
	
	nyka.findElement(By.xpath("//span[text()=\"Proceed\"]")).click();
	Thread.sleep(200);
	
	nyka.findElement(By.xpath("//button[text()=\"CONTINUE AS GUEST\"]")).click();
	
	Thread.sleep(300);
	
	String text4 = nyka.findElement(By.xpath("//div[@class=\"payment-details-tbl grand-total-cell prl20\"]/div[2]")).getText();
	
	System.out.println("The final total price is : "+ text4);
	
	
	if(text3.equals(text4)) {
		System.out.println("The price was same");
	}
	else
		System.out.println("The price does not match");
	
	}

}
