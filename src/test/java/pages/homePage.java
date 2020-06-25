package pages;

import static org.testng.Assert.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@SuppressWarnings({ "javadoc" })
public class homePage extends BasePage {

	public homePage(WebDriver driver) {
		super(driver);
	}

	String expectedTitle = "הירולו - חברת פיתוח מובילה המתמחה בפתרונות פרונט אנד";

	By errorFields = By.xpath("//label[starts-with(@class,'Footer__InputError')]");
	By submitButtonAtFooter = By.cssSelector("button[class^='Footer__Button']");
	List<String> actualErrorList = new ArrayList<>();
	List<String> expectedErrorList = new ArrayList<>(
			List.of("שדה טלפון הוא שדה חובה", "שדה אימייל הוא שדה חובה", "שדה שם הוא שדה חובה"));
	boolean isEqual = false;

	By nameField = By.cssSelector("footer input[name='name']");
	String name = "Herolo";
	By emailField = By.cssSelector("footer input[name='email']");
	String email = "Herolo@herolo.com";
	By phoneField = By.cssSelector("footer input[name='phone']");
	String phone = "0507777777";
	By jugglingImg = By.id("juggling");
	String expectedCurrentURL = "https://automation.herolo.co.il/thank-you/";
	String CurrentURL;
	By backButton = By.cssSelector("a[href='/']");

	By whatsAppLink = By.xpath("//a[starts-with(@class,'callUsWhatsapp')]");
	String expectedURLWhatsApp = "https://api.whatsapp.com/send?phone=972544945333";
	By whatsAppPagePhone = By.xpath("//span[contains(text(),'+972 54-494-5333')]");
	String mainPageHandle;
	String expectedPhoneNumber = "+972 54-494-5333";

	By bottomErrors = By.xpath("//span[starts-with(@class,'commun__ErrorText')]");
	int actualErrorsize;
	int numberOfElementsToBE = 4;
	By submitButtonBottom = By.xpath("//a[@type='button']");

	By numberOfProjectImages = By
			.xpath("//div[@data-index and @aria-hidden='false']//img[@alt='Project image']");
	int numberOfCurrentProjects = 4;
	int actualNumberOfCurrentProjects;

	By faceBookLink = By.cssSelector("a[href='https://www.facebook.com/Herolofrontend']");
	By actualTitleFacebook;
	String expectedTitleFacebook = "https://www.facebook.com/Herolofrontend";

	By nameFieldBottom = By.id("name");
	String nameBottom = "Herolo";
	By emailFieldBottom = By.id("email");
	String emailBottom = "Herolo@herolo..com";
	By phoneFieldBottom = By.id("telephone");
	String phoneBottom = "0507777777";
	By companyFieldBottom = By.id("company");
	String company = "Herolo";
	By submitBottom = By.xpath("//a[@type='button']");
	By backButtonBottom = By.cssSelector("a[href='/frontend-developers/']");

	By popupElement = By.xpath("//*[@*[contains(.,'ReactModal__Content')]]");
	By closeButtun = By.xpath("//*[@*[contains(.,'CloseModalBtn')]]");

	public void getWebSite(String siteURL) {
		driver.get(siteURL);
	}

	public void compareTabName() {
		assertEquals(getTabName(), expectedTitle, "The title of the web site is not as expected");
	}

	public void clickOnPopup() {
		if (!(isElementValid(popupElement))) {
			clickOnElement(closeButtun);
		}
	}

	public void sendEmptyFieldsAtFooter() {
		clickOnPopup();
		clickOnElement(submitButtonAtFooter);
		actualErrorList = getTextFromElements(errorFields);
		Collections.sort(actualErrorList);
		Collections.sort(expectedErrorList);
		isEqual = expectedErrorList.equals(actualErrorList);
		assertTrue(isEqual, "The error list is not the same as expected");
	}

	public void sendFullFieldsfilled() {
		clickOnPopup();
		sendKeysToElement(nameField, name);
		sendKeysToElement(emailField, email);
		sendKeysToElement(phoneField, phone);
		clickOnElement(submitButtonAtFooter);
		waitForElementToBeVisable(jugglingImg);
		assertEquals(getURL(), expectedCurrentURL, "Not the expected URL");
		clickOnElement(backButton);
	}

	public void validateWhatsAppLink() {
		clickOnPopup();
		mainPageHandle = driver.getWindowHandle();
		waitForElementToBeClickable(whatsAppLink);
		clickOnElement(whatsAppLink);
		Set<String> handles = driver.getWindowHandles();
		for (String winHandle : handles) {
			driver.switchTo().window(winHandle);
		}
		assertEquals(getURL(), expectedURLWhatsApp, "not the expected webPage");
		assertEquals(getTextFromElement(whatsAppPagePhone), "+972 54-494-5333",
				"not the expected webPage");
		driver.switchTo().window(mainPageHandle);
	}

	public void testNumberOfCurrecntProjects() {
		clickOnPopup();
		actualNumberOfCurrentProjects = countElements(numberOfProjectImages, numberOfElementsToBE);
		assertEquals(actualNumberOfCurrentProjects, numberOfCurrentProjects,
				"not the right number of projects at the Home Page");
	}

	public void validateErrorsAtSubmitBottom() {
		clickOnPopup();
		clickOnElement(submitButtonBottom);
		actualErrorsize = ((countElements(bottomErrors, numberOfElementsToBE)));
		assertEquals(actualErrorsize, numberOfElementsToBE,
				"not the right size of errors at the bottom");
	}

	public void testFaceBookAtBottom() {
		clickOnPopup();
		mainPageHandle = driver.getWindowHandle();
		clickOnElement(faceBookLink);
		Set<String> handles = driver.getWindowHandles();
		for (String winHandle : handles) {
			driver.switchTo().window(winHandle);
		}
		assertEquals(getURL(driver), expectedTitleFacebook, "not the right page in Facebook");
		driver.switchTo().window(mainPageHandle);
	}

	public void sendFullFieldsfilledAtBottom() {
		clickOnPopup();
		sendKeysToElement(nameFieldBottom, name);
		sendKeysToElement(emailFieldBottom, email);
		sendKeysToElement(phoneFieldBottom, phone);
		sendKeysToElement(companyFieldBottom, company);
		clickOnElement(submitBottom);
		waitForElementToBeVisable(jugglingImg);
		assertEquals(getURL(), expectedCurrentURL, "Not the expected URL");
		clickOnElement(backButtonBottom);
	}

}
