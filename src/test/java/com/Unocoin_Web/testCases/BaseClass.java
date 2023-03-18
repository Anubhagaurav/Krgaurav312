package com.Unocoin_Web.testCases;

import java.io.File;
import java.io.IOException;
import java.util.Properties;


import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.EmailException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.Unocoin_Web.utilities.ReadConfig;






public class BaseClass {

	ReadConfig readconfig = new ReadConfig();
public String baseUrl=readconfig.getApplicationURL();
public String username=readconfig.username();
public String password=readconfig.password();
public String OTP=readconfig.OTP();
public static WebDriver driver;
public static Logger logger;

@Parameters("browser")
@BeforeClass

public void setup(String br)
{


Logger logger=Logger.getLogger("Unocoin");
PropertyConfigurator.configure("Log4j.Properties");
if(br.equals("chrome"))
{
	System.setProperty("webdriver.chrome.driver", readconfig.chromepath());
	driver = new ChromeDriver();
}
driver.get(baseUrl);
driver.manage().window().maximize();
}
/*@AfterMethod
public static void sendEmail() throws EmailException{
final String username = "gaurav2rocks@outlook.com";
   final String password = "Kumargaurav@312";

   Properties props = new Properties();
   props.put("mail.smtp.auth", true);
   props.put("mail.smtp.starttls.enable", true);
   props.put("mail.smtp.host", "smtp.office365.com");
   props.put("mail.smtp.port", "587");

   Session session = Session.getInstance(props,
           new javax.mail.Authenticator() {
               protected PasswordAuthentication getPasswordAuthentication() {
                   return new PasswordAuthentication(username, password);
               }
           });

   try {

       Message message = new MimeMessage(session);
       message.setFrom(new InternetAddress("gaurav2rocks@outlook.com"));
       message.setRecipients(Message.RecipientType.TO,
               InternetAddress.parse("kumarg@unocoin.com"));
       message.setSubject("Testing Report");
       message.setText("PFA");

       MimeBodyPart messageBodyPart = new MimeBodyPart();

       Multipart multipart = new MimeMultipart();

       messageBodyPart = new MimeBodyPart();
       String file = "/Users/kumargaurav/eclipse-workspace/Unocoin_Maven/test-output/emailable-report.html";
       String fileName = "Testing report";
       DataSource source = new FileDataSource(file);
       messageBodyPart.setDataHandler(new DataHandler(source));
       messageBodyPart.setFileName(fileName);
       multipart.addBodyPart(messageBodyPart);

       message.setContent(multipart);

       System.out.println("Sending");

       Transport.send(message);

       System.out.println("Mail Sent");

   } catch (MessagingException e) {
       e.printStackTrace();
   }
}*/
@AfterClass
public void tearDown()
{
driver.quit();
}
 
public void captureScreen(WebDriver driver, String tname) throws IOException {
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
	FileUtils.copyFile(source,target);
	System.out.println("Screenshot taken");
}


}