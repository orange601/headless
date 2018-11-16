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
    	//크롬드라이버 설치 돼 있어야 함 //절대경로사용
	    System.setProperty("webdriver.chrome.driver", "c:\\selenium\\chromedriver.exe");
		 
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("headless"); // 추가시 Headless 모드로 동작 // 추가하지 않으면 크롬으로 열림 
	    //options.addArguments("disable-gpu"); //기억안남
	    //options.addArguments("dump-dom"); //기억안남
	 
	    
	    WebDriver driver = new ChromeDriver(options);
	    driver.get("https://www.naver.com/"); // 다른 URL을 사용해서 예제를 만들었기때문에 그대로 실행하면 안됨 
	    
	    try {
	    	// 접속시 5초동안 대기 후 접속 해야되는 사이트이기때문에 ( cloudflare로 인하여 ) 6초대기후 다음 진행 
	    	synchronized(driver) {
	    		driver.wait(6000); // 밀리세컨드 맞겠찌?
	    	}
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	    // 팝업창을 닫는다
	    driver.findElement(By.className("btn-close")).click();
	    
	    // 로그인 버튼 클릭
	    driver.findElement(By.className("login")).click();
	    
	    //입력박스에 ID 입력 (email이라 적혀있지만 name이 email 일뿐 혼동하지말고 )
	    driver.findElement(By.name("email")).sendKeys("ID");
	    
	    //입력박스에 PW 입력
	    driver.findElement(By.name("password")).sendKeys("PW");
	    
	    //로그인 버튼클릭
	    driver.findElement(By.cssSelector("div.half button.w-navy")).click();
	    
	    try {
	    	//로그인이 잘 되는지 확인하기 위해서 다시 6초 기다리기
	    	synchronized(driver) {
	    		driver.wait(6000);
	    	}
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	    //종료( 브라우저 닫힘 )
	    driver.quit();
    }
}
