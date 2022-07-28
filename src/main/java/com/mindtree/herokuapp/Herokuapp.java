package com.mindtree.herokuapp;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Herokuapp {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver","C://Users//mindc1may361//eclipse-workspace//Herokuapp//drivers//chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://the-internet.herokuapp.com");
		
		//1
		driver.findElement(By.xpath("//a[contains(text(),'Hovers')]")).click();
		
		WebElement element=driver.findElement(By.xpath("//img[@alt='User Avatar']"));
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
		
		WebElement s=driver.findElement(By.tagName("h5"));
				String name=s.getText();
				
		System.out.println(name);
		
		driver.navigate().back();
		
		//2
		
		driver.findElement(By.xpath("//a[contains(text(),'Checkboxes')]")).click();
		WebElement check=driver.findElement(By.cssSelector("input:checked[type='checkbox']"));
		check.click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.navigate().back();
		
		
		//3
		
		driver.findElement(By.xpath("//a[contains(text(),'Inputs')]")).click();
		driver.findElement(By.xpath("//input[@type='number']")).sendKeys("1234");
		driver.navigate().back();
		
		//4
		
		driver.findElement(By.xpath("//a[contains(text(),'Dropdown')]")).click();
		WebElement Dropdown=driver.findElement(By.id("dropdown"));
		Select option=new Select(Dropdown);
		option.selectByValue("2");
		driver.navigate().back();
		
		
		
		
		
		//6
		driver.findElement(By.xpath("//a[contains(text(),'Sortable Data Tables')]")).click();
		
		
		driver.navigate().back();
		
		//7
		driver.findElement(By.xpath("//a[contains(text(),'Key Presses')]")).click();
		driver.findElement(By.xpath("//input[@id='target']")).sendKeys(Keys.ENTER);
		
		driver.navigate().back();
		driver.navigate().back();
		
		//8
		driver.findElement(By.xpath("//a[contains(text(),'Multiple Windows')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
		Set tab=driver.getWindowHandles();
		Iterator t=tab.iterator();
		String p= (String) t.next();
		String c=(String) t.next();
		driver.switchTo().window(c);
		
		WebElement text=driver.findElement(By.tagName("h3"));
		String printtext=text.getText();
		
		System.out.println(printtext);
		
		driver.switchTo().window(p);
		driver.navigate().back();
		
		
		//9
		driver.findElement(By.xpath("//a[contains(text(),'Context Menu')]")).click();
		
		Actions rc=new Actions(driver);
		WebElement locate=driver.findElement(By.id("hot-spot"));
		rc.contextClick(locate).perform();
		
		driver.switchTo().alert().accept();
		driver.navigate().back();
		
		
		
		//5
		
			driver.findElement(By.xpath("//a[contains(text(),'File Upload')]")).click();
			Actions fu=new Actions(driver);
			WebElement upload=driver.findElement(By.name("file"));
			fu.click(upload).perform();
		
			
				
		
		
		
		
		
		
		
		
	}

}
