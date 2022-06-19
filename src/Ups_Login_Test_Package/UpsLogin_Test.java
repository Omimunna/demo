package Ups_Login_Test_Package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpsLogin_Test {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver driver = new ChromeDriver(); //  its Called Parent child up_Casting
		
		driver.get("https://www.ups.com/lasso/login");
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		WebElement userId = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"submitBtn\"]"));
		
		userId.sendKeys("TalenTech");
		password.sendKeys("password12345");
		submitButton.click();
		
		WebElement errorMsg  = driver.findElement(By.id("errorMessages"));
       
		
		String error = errorMsg.getText();
		if(error.contains("Something seems to have gone wrong.")) {
			System.out.println("PASSED");
		}else {
			System.out.println("FAILED!!");
		}
		
		//Thread.sleep(2000);
		
		
		driver.close();
		
	}

}
