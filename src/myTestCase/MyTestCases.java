package myTestCase;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases extends Parameters {

	@BeforeTest
	public void SetUp() {
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		WebElement popUpScreen = driver.findElement(By.className("sc-iBmynh"));
		if (popUpScreen.isDisplayed()) {
			WebElement SarButton = driver.findElement(By.className("cta__saudi"));
			SarButton.click();
		}
	}

	@Test(priority = 1)
	public void CheckTheDeafultLanguageIsEnglish() {
		String ExpectedLanguage = "EN";
		String ActualLanguage = driver.findElement(By.tagName("html")).getAttribute("lang").toUpperCase();
		assertEquals(ActualLanguage, ExpectedLanguage);
	}

	@Test(priority = 2)
	public void CheckTheCurrencyIsSAR() {
		String ExpectedCurrency = "SAR";
		String ActualCurrency = driver.findElement(By.xpath("//button[@data-testid='Header__CurrencySelector']"))
				.getText();
		assertEquals(ActualCurrency, ExpectedCurrency);
	}

	@Test(priority = 3)
	public void CheckTheContactNumber() {
		String ExpectedContactNumber = "+966554400000";
		String ActualContactNumber = driver.findElement(By.tagName("strong")).getText();
		assertEquals(ActualContactNumber, ExpectedContactNumber);
	}

	@Test(priority = 4)
	public void CheckTheQitafLogo() {
		WebElement TheFooter = driver.findElement(By.tagName("footer"));
		assertEquals(TheFooter.findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-ekulBa.eYboXF")).isDisplayed(), true);
	}

	@Test(priority = 5)
	public void CheckHotelTabIsNotSelectedByDefault() {
		assertEquals(driver.findElement(By.id("uncontrolled-tab-example-tab-hotels")).getAttribute("aria-selected"),
				"false");
	}

	@Test(priority = 6)
	public void RandomChangeTheWebsiteLanguage() {
		Random rand = new Random();
		int RandomIndex = rand.nextInt(Websites.length);
		driver.get(Websites[RandomIndex]);
		if (driver.getCurrentUrl().contains("ar")) {
			String ExpectedWebsiteLanguage = "ar";
			String ActualWebsiteLanguage=driver.findElement(By.tagName("html")).getAttribute("lang");
			assertEquals(ActualWebsiteLanguage, ExpectedWebsiteLanguage);
		}
		else {
			String ExpectedWebsiteLanguage = "en";
			String ActualWebsiteLanguage=driver.findElement(By.tagName("html")).getAttribute("lang");
			assertEquals(ActualWebsiteLanguage, ExpectedWebsiteLanguage);
		}
	}

	@AfterTest
	public void myPostTest() {
	}
}
