package tests;

import org.testng.annotations.Test;

@SuppressWarnings("javadoc")
public class MainRunner extends BaseTest {

	String siteURL = "https://automation.herolo.co.il/";

	@Test(priority = 1, groups = "Open Web Site test", description = "Open the web site test")
	public void upFooterOpenWebSite() {
		homePage.getWebSite(siteURL);
	}

	@Test(priority = 2, groups = "Tab test name", description = "Test if the tab name as expected")
	public void titleTest() {
		homePage.compareTabName();
	}

	@Test(priority = 3, groups = "Test fields", description = "Test empty fields at submit")
	public void testEmptyFieldsAtSubmitFotter() {
		homePage.sendEmptyFieldsAtFooter();
	}

	@Test(priority = 4, groups = "Test fields", description = "Test correct fields at submit")
	public void sendFieldsfilled() {
		homePage.sendFullFieldsfilled();
	}

	@Test(priority = 5, groups = "Test WhatApp Link", description = "Test whastApp link")
	public void testwhatAppLink() {
		homePage.validateWhatsAppLink();
	}

	@Test(priority = 6, groups = "Test fields", description = "Test that bottom have 4 errors")
	public void testEmptyFieldsAtSubmitBottom() {
		homePage.validateErrorsAtSubmitBottom();
	}

	@Test(priority = 7, groups = "carousel of projects", description = "Test the number of projects at the carousel")
	public void testNumberOfItemsAtCarousel() {
		homePage.testNumberOfCurrecntProjects();
	}

	@Test(priority = 8, groups = "Links at bottom test", description = "Test FaceBook Link")
	public void testFaceBookLink() {
		homePage.testFaceBookAtBottom();
	}

	@Test(priority = 10, groups = "Test fields",description = "Test that bottom send the form correct")
	public void testBottomForm() {
		homePage.sendFullFieldsfilledAtBottom();
	}

}
