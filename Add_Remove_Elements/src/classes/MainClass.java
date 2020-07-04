package classes;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainClass {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Programs\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseUrl = "http://the-internet.herokuapp.com/add_remove_elements/";

		Boolean isPresent;
		int addingCount = 2;
		int listSize=0;
		driver.get(baseUrl);
//adding elements
		for (int i = 1; i <= addingCount; i++) {
			driver.findElement(By.cssSelector(".example>button")).click();
			System.out.println("adding element..");
			
//checking if element added
			 List<WebElement> elements = driver.findElements(By.cssSelector("button.added-manually"));
			 listSize=elements.size();	
		     System.out.println("elements list size " + listSize);
			
			if(listSize==i) {
				System.out.println("element ¹"+i+" added");
			}
			else {
				System.out.println("element is not added");
			}
		}
		for (int i=listSize; i>0; i--) {
			
//removing element		
     		 driver.findElement(By.xpath("//*[@id=\"elements\"]/button[" + i + "]")).click();
   			

//checking if element removed			
				isPresent = driver.findElements(By.xpath("//*[@id=\"elements\"]/button[" + i + "]")).size() > 0;
				System.out.println("removing element..") ;
				List<WebElement> elements = driver.findElements(By.cssSelector("button.added-manually"));
	   			 listSize=elements.size();
			     System.out.println("elements list size " + listSize);
				if (!isPresent) {
					System.out.println("element ¹" + i + " removed");
				} else {
					System.out.println("element ¹" + i + " is not removed");
				}
			
			}	
		
			driver.close();
	}

}
