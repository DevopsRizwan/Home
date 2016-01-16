package com.onlinebanking.selenium;

import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

@SuppressWarnings("deprecation")
public class PrestoOnLBanSelInteTest {
	private Selenium selenium;
	private String hubUrl;
	private String targetUrl;

	@Before
	public void setUp() throws Exception {
		// selenium = //new DefaultSelenium("localhost", 4444, "*chrome",
		// "http://localhost:8080/");
		//hubUrl = System.getenv("selenium.hub.url");
		
		hubUrl = "http://10.121.48.143:4444/wd/hub/";
		if (hubUrl == null) {
			hubUrl = System.getProperty("selenium.hub.url");
		}
		//targetUrl = System.getenv("target.url");
		targetUrl = "http://10.121.48.143:8080/onlinebanking";
		if (targetUrl == null) {
			targetUrl = System.getProperty("target.url");
		}
		
		WebDriver driver = new RemoteWebDriver(new URL(hubUrl), DesiredCapabilities.firefox());
		selenium = new WebDriverBackedSelenium(driver, targetUrl);

	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testAdminLoginAndCreateEmp() throws Exception {
		selenium.open("/onlinebanking/");
/*		selenium.click("link=Search");
		selenium.click("link=Login Portal");
		selenium.waitForPageToLoad("30000");
		selenium.select("css=select", "label=Administrator");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=userName", "admin");
		selenium.type("id=adminlogin_password", "admin");
		selenium.type("id=adminlogin_bank_id", "1234");
		selenium.click("id=adminlogin_0");
		selenium.waitForPageToLoad("30000");
		selenium.click("//div[3]/a/span/strong");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=textinput", "9444");
		selenium.type("name=add.branch", "JAI");
		selenium.type("name=add.role_name", "Manager");
		selenium.type("name=add.firstName", "lovelyhai");
		selenium.type("name=add.middleName", "singh");
		selenium.type("name=add.lastName", "keasri");
		selenium.type("name=add.dob", "20/06/87");
		selenium.type("name=add.landLine", "963325");
		selenium.type("name=add.mobile", "98989");
		selenium.type("name=add.email", "chan11ww@chan.com");
		selenium.type("id=address-line1", "mahraja nagar");
		selenium.type("id=city", "Jai1");
		selenium.type("id=region", "Raj");
		selenium.click("id=singlebutton");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=textinput", "testusr2");
		selenium.type("id=passwordinput", "testusr2");
		selenium.type("name=adds.bank_id", "9444");
		selenium.click("id=singlebutton");
		selenium.waitForPageToLoad("30000");*/
	}
	
/*	@Test
	public void testAddClientByEmpAndViewTrans() throws Exception{
		selenium.open("/Presto/login-portal.jsp");
		selenium.click("link=Search");
		selenium.click("link=Login Portal");
		selenium.waitForPageToLoad("30000");
		selenium.select("css=select", "label=Employee");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=userName", "testusr1");
		selenium.type("id=emplogin_password", "testusr1");
		selenium.type("id=emplogin_bank_id", "9222");
		selenium.click("id=emplogin_0");
		selenium.waitForPageToLoad("30000");
		selenium.click("//div[5]/a/span/strong");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=textinput", "9222");
		selenium.type("id=textinput", "8222");
		selenium.type("name=add.branch", "JAI");
		selenium.type("name=add.firstName", "gardhawarxswq");
		selenium.type("name=add.middleName", "Prasaddwqd");
		selenium.type("name=add.lastName", "yadavdw");
		selenium.type("name=add.dob", "20/09/87");
		selenium.type("name=add.mobile", "7999");
		selenium.type("name=add.landLine", "dwq");
		selenium.type("name=add.landLine", "96334545");
		selenium.type("name=add.email", "garrr@chan.com");
		selenium.type("id=address-line1", "mahraja nagar");
		selenium.type("id=city", "Jai1");
		selenium.type("id=region", "Raj");
		selenium.click("id=singlebutton");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=textinput", "testcust2");
		selenium.type("id=passwordinput", "testcust2");
		selenium.type("name=adds.bank_id", "8222");
		selenium.click("id=singlebutton");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=clientID", "8222");
		selenium.type("name=depo.details", "cash");
		selenium.type("id=appendedtext", "9999");
		selenium.click("id=submit");
		selenium.waitForPageToLoad("30000");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=clientID", "8222");
		selenium.click("id=submit");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Logout");
		selenium.waitForPageToLoad("30000");
		}
	
	

	@Test
	public void testClientloginAndview() throws Exception {
		selenium.open("/Presto/index.jsp");
		selenium.click("link=Search");
		selenium.click("link=Login Portal");
		selenium.waitForPageToLoad("30000");
		selenium.select("css=select", "label=User");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=userName", "testcust2");
		selenium.type("id=clientlogin_password", "testcust2");
		selenium.type("id=clientlogin_bank_id", "8222");
		selenium.click("id=clientlogin_0");
		selenium.waitForPageToLoad("30000");
		//selenium.click("css=span > strong");
		selenium.waitForPageToLoad("30000");
	//	selenium.click("link=Logout");
		selenium.waitForPageToLoad("30000");
	}*/

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}

}
