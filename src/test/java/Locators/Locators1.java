package Locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = null;      
             driver = new ChromeDriver();
             driver.get("https://www.amazon.in");
             driver.manage().window().maximize();
             driver.close();
	}

}
