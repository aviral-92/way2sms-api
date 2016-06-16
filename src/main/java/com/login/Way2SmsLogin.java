package com.login;

import java.io.IOException;
import java.net.MalformedURLException;
import org.apache.log4j.Logger;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlButtonInput;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTextArea;

public class Way2SmsLogin {

	static Logger log = Logger.getLogger(Way2SmsLogin.class);
	
	public void Way2SmsLoginTest()
			throws FailingHttpStatusCodeException, MalformedURLException, IOException, InterruptedException {

		WebClient webClient = new WebClient(BrowserVersion.CHROME);
		webClient.getOptions().setUseInsecureSSL(true);
		webClient.getCookieManager().setCookiesEnabled(true);
		webClient.getOptions().setJavaScriptEnabled(true);
		webClient.getOptions().setCssEnabled(false);
		log.debug("Message");
		// webClient.getOptions().setThrowExceptionOnScriptError(false);
//		Thread.sleep(1000);
		HtmlPage htmlPage = webClient.getPage("http://site24.way2sms.com/content/index.html");
//		Thread.sleep(1000);
		HtmlInput username = (HtmlInput) htmlPage.getElementByName("username");
		HtmlInput password = (HtmlInput) htmlPage.getElementByName("password");
		username.setValueAttribute("Your Username");
		password.setValueAttribute("Your Password");
		HtmlButtonInput submitBtn = (HtmlButtonInput) htmlPage.getHtmlElementById("loginBTN");
		htmlPage = submitBtn.click();
		Thread.sleep(6000);
		DomNodeList<DomElement> dom = htmlPage.getElementsByTagName("input");
		Thread.sleep(6000);
		submitBtn = (HtmlButtonInput) dom.get(4);
		htmlPage = submitBtn.click();
		HtmlAnchor htmlAnchor = htmlPage.getAnchorByText("Send SMS");
		htmlPage = htmlAnchor.click();
		HtmlInput mobile = (HtmlInput) htmlPage.getElementByName("mobile");
		HtmlTextArea text = (HtmlTextArea) htmlPage.getElementByName("message");

		mobile.setValueAttribute("8527701990");
		text.setTextContent("Hello Aviral");
		submitBtn = (HtmlButtonInput) htmlPage.getHtmlElementById("Send");
		htmlPage = submitBtn.click();

		System.out.println(htmlPage.asText());
		webClient.close();
	}

	public static void main(String[] args)
			throws FailingHttpStatusCodeException, MalformedURLException, IOException, InterruptedException {
		Way2SmsLogin login = new Way2SmsLogin();
		login.Way2SmsLoginTest();

	}

}
