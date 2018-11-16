package com.eyabit.chromeless;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
	    System.setProperty("webdriver.chrome.driver", "c:\\selenium\\chromedriver.exe");
		 
	    ChromeOptions options = new ChromeOptions();
	    //options.addArguments("headless"); // Headless 모드로 동작
	   // options.addArguments("disable-gpu");
	   //options.addArguments("dump-dom");
	 
	    WebDriver driver = new ChromeDriver(options);
	    driver.get("https://www.unibitkr.com/");
	    
	    try {
	    	synchronized(driver) {
	    		driver.wait(6000);
	    	}
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	    driver.findElement(By.className("btn-close")).click();
	    
	    driver.findElement(By.className("login")).click();
	    driver.findElement(By.name("email")).sendKeys("oltop@naver.com");
	    driver.findElement(By.name("password")).sendKeys("v6b7n8m9<)");
	    
//	    System.out.println(driver.findElement(By.tagName("button")));
//	    System.out.println("#######");
//	    System.out.println(driver.findElement(By.tagName("submit")));
//	    System.out.println("#######");
//	    System.out.println(driver.findElement(By.className("btn")));
//	    System.out.println("#######");
//	    System.out.println(driver.findElement(By.cssSelector(".btn w-navy")));
//	    System.out.println("");
	   //System.out.println(driver.findElement(By.cssSelector("div.half button.w-navy")));
	   
	    driver.findElement(By.cssSelector("div.half button.w-navy")).click();
	    
	    //driver.findElement(By.className("btn w-navy big")).click();
	    
    	//driver.findElement(By.className("btn w-navy big")).submit();
	    
	    
	    try {
	    	synchronized(driver) {
	    		driver.wait(6000);
	    	}
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	    driver.quit();
    }
}
