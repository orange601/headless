# headless
selenium을 이용한 크롤링
프로젝트는 이클립스 NEON 버전을 사용했으며 빌드툴은 maven사용했음

headless란
인터넷을할때 브라우저(크롬)를 사용해서 화면을 띄우지만 OS에 따라서 화면자체가 존재하지 않을 수 있다.
우분투 같은 경우에 화면자체가 존재하지 않기 때문에 일반적인 방식으로는 크롬을 쓸 수 없다.
이를 해결해 주는 방식이 Headless 모드이다.

Selenium chrome driver 네이버 캡차(Captcha) 무력화
https://hyrama.com/?p=693



1. selenium을 이용한 네이버 로그인시도
 - selenium을 이용한 로그인은 캡차 페이지로 이동시킴 ( selenium을 이용한 로그인 막힘 ) 
 
2. 캡차 뚫는 방법들이 구글링하면 나옴 
 - https://neung0.tistory.com/34
 - https://hyrama.com/?p=693
 - https://stophyun.tistory.com/199
 - 기존 방식은 selenium의 sendKeys메서드를 이용한 입력방식이었다.
 - 구글링해서 나온 방식은 clipboard 기능을 이용해서 복 붙 기능을 활용하면 selenium을 인식을 못한다는거였다.

3. 내가 시도했던 방식 ( 위에껄 따라했다고 따라했지만 안됨 )

```java

public static void main(String[] args) {
		  String url = "https://www.naver.com/";
    	//크롬드라이버 설치 돼 있어야 함 //절대경로사용
	    System.setProperty("webdriver.chrome.driver", "c:\\selenium\\chromedriver.exe");
		 
	    ChromeOptions options = new ChromeOptions();
	    //options.addArguments("headless"); // 추가시 Headless 모드로 동작 // 추가하지 않으면 크롬으로 열림 
	   //options.addArguments("disable-gpu"); //기억안남
	    //options.addArguments("dump-dom"); //기억안남
	 
	    
	    WebDriver driver = new ChromeDriver(options);
	    // 5초 설정
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    // 접속
	    driver.get(url); // 다른 URL을 사용해서 예제를 만들었기때문에 그대로 실행하면 안됨 
	    
	    // 메인 로그인 버튼 클릭
	    driver.findElement(By.className("className")).click();
	    
	    
	    try {
	    	synchronized(driver) {
	    		driver.wait(2000);
	    	}
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	    
	    // 1. 아이디 복사
	    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	    String copyString = "id";
	    if(copyString != null) {
	         StringSelection contents = new StringSelection(copyString);
	         clipboard.setContents(contents, null);
	    }
	    
	    // 2. 아이디 붙여넣기
	    Actions action = new Actions(driver);
	    action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
	    
	    // 3. pw 입력박스 클릭
	    WebElement pwInput = driver.findElement(By.xpath("//*[@id='xpath']"));
	    pwInput.click();
	    
	    // 4. pw 복사
	    Clipboard clipboard2 = Toolkit.getDefaultToolkit().getSystemClipboard();
	    String copyString2 = "pw";
	    if(copyString2 != null) {
	         StringSelection contents2 = new StringSelection(copyString2);
	         clipboard2.setContents(contents2, null);
	    }
	    
	    // 5. pw 붙여넣기
	    action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
	    
	    // 6. 로그인버튼 클릭
	    WebElement loginBtn = driver.findElement(By.xpath("//*[@id='xpath']"));
	    loginBtn.click();
	    
	    try {
	    	synchronized(driver) {
	    		driver.wait(2000);
	    	}
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	    driver.quit();
	}


```

4. 해결 따윈못했고 
 - 위 블로그 중 맥쓰는 분이 파폭에서 하면 된다함. 파폭으로 해보는건 다음에.. 지쳤어.
