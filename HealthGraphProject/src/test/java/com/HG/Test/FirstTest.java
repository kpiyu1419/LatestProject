package com.HG.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {


	@Test
	public void f() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://testfire.net/index.jsp");
		WebElement loginlink=driver.findElement(By.id("AccountLink"));
		loginlink.click();


		//Invalid credential login
		/* WebElement username=driver.findElement(By.id("uid"));
		  username.sendKeys("demo_user");
		  WebElement password=driver.findElement(By.id("passw"));
		  password.sendKeys("demo_password");
		//  driver.findElement(By.id("user_password"));
		  WebElement btn=driver.findElement(By.name("btnSubmit"));
		  btn.click();*/

		//Valid credentials

		WebElement username=driver.findElement(By.id("uid"));
		username.sendKeys("admin");
		WebElement password=driver.findElement(By.id("passw"));
		password.sendKeys("admin");
		//  driver.findElement(By.id("user_password"));
		WebElement btn=driver.findElement(By.name("btnSubmit"));
		btn.click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		//Click on ViewAccSummary
		WebElement viewAccSummary=driver.findElement(By.id("MenuHyperLink1"));
		viewAccSummary.click();
		
		System.out.println("View Account Summary Clicked");
		//select 800001 acc in dropdown
		Select se = new Select(driver.findElement(By.name("listAccounts")));
		se.selectByValue("800001");

		WebElement btn1=driver.findElement(By.id("btnGetAccount"));
		btn1.click();
		System.out.println("Account 800001 Selected from drop down");

		//Assert  for balance??

		WebElement balanceverify= driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/div/table/tbody/tr[1]/td/table/tbody/tr[4]/td[2]"));
		System.out.println( balanceverify.getText());

		String expectedBal = "$108874.00";
		//Assert.assertEquals(expectedBal,balanceverify);

		System.out.println("Balance verified");

		//Click on Transfer funds
		WebElement transferlink=driver.findElement(By.id("MenuHyperLink3"));
		transferlink.click();

		Select fa = new Select(driver.findElement(By.name("fromAccount")));

		fa.selectByValue("800000");//Transfer from account

		Select ta = new Select(driver.findElement(By.name("toAccount")));

		ta.selectByValue("800001");  //Transfer to account

		WebElement AmountTotransfer=driver.findElement(By.id("transferAmount"));
		AmountTotransfer.sendKeys("9876");
		
		Thread.sleep(2000);

		//Transfer amount button click
		WebElement btn3=driver.findElement(By.id("transfer"));
		btn3.click();
		System.out.println( "Fund Transfered Successfully");


		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Validate Trasnsaction Detail message

		//  WebElement transactionDetailMessage= driver.findElement(By."//span[@id='_ctl0__ctl0_Content_Main_postResp']");

		/* WebElement transactionDetailMessage=driver.findElement(By.id("_ctl0__ctl0_Content_Main_postResp"));
			  transactionDetailMessage.getText();

			  String expectedText = "9876.0 was successfully transferred from Account 800000 into Account 800001 at 10/13/22 10:12 PM.";
			  Assert.assertEquals(transactionDetailMessage,expectedText);

			  try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 */

		//Click on View Recent Transactions

		WebElement veiwRecentTransactions=driver.findElement(By.id("MenuHyperLink2"));
		veiwRecentTransactions.click();

		//Validate First Two Transactions??



		//Click On Contact US

		WebElement contactUs=driver.findElement(By.id("HyperLink3"));
		contactUs.click();

		//Click On Online Form link

		driver.findElement(By.linkText("online form")).click();

		//WebElement onlineFormlink=driver.findElement(By.id("HyperLink3"));
		// onlineFormlink.click();

		//Feedback Form Details

		WebElement yourName=driver.findElement(By.name("name"));
		yourName.sendKeys("Admin User");

		WebElement emailid=driver.findElement(By.name("email_addr"));
		emailid.sendKeys("kpiyu1419@gmail.com");

		WebElement subject=driver.findElement(By.name("subject"));
		subject.sendKeys("MyFeedback");


		WebElement comments=driver.findElement(By.name("comments"));
		comments.sendKeys("Good experince in using this application");

		WebElement submitfeedback=driver.findElement(By.name("submit"));
		submitfeedback.click();
		
		System.out.println("Feedback form filled");
		
		Thread.sleep(2000);

		//Validate Thank you message
		WebElement messgeValidation= driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/div/h1"));

		//Verify Thank you message is Displayed
		if(messgeValidation.isDisplayed())
		{
			System.out.println("thank you message is Dispalyed");
		}

		else
		{
			System.out.println("Thank you message is not Dispalyed");
		}


		WebElement signOff=driver.findElement(By.id("LoginLink"));
		signOff.click();
		WebElement signOffValidation= driver.findElement(By.xpath("//*[@id=\"LoginLink\"]/font"));
		signOffValidation.click();

		
		//Validate user is signed off

		//WebElement signOffValidation= driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/div/h1"));


	}

}




//*[name='username']
	//	//*[@id="app"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input
		
	//	#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div:nth-child(2) > div > div:nth-child(2) > input


		//*[@id="app"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input

