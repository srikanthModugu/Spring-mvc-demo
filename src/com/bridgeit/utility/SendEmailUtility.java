package com.bridgeit.utility;

import java.io.InputStream;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.bridgeit.model.Person;

public class SendEmailUtility {


	public  void sendEmail(Person per)
	{
		String fromEmail ="modugusrikanth1@gmail.com";
		String password  ="8985358626";
		String message = per.getName() + " you have Sucessfully registered in My app Thankyou\n" + "Your email:"
				+ per.getEmail() + "\n" + "Your password:" + per.getPassWord();
		String subject = "Registertion sucessfull";
		try 
		{
			Properties props = System.getProperties();
			InputStream in = this.getClass().getResourceAsStream("sendEmail.properties");
			props.load(in);
			
			Session mailSession = Session.getDefaultInstance(props, null);
			mailSession.setDebug(true);

			Message mailMessage = new MimeMessage(mailSession);
			mailMessage.setFrom(new InternetAddress(fromEmail));
			mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(per.getEmail()));
			mailMessage.setText(message);
			mailMessage.setSubject(subject);

			Transport transport = mailSession.getTransport("smtp");
			transport.connect("smtp.gmail.com", fromEmail, password);

			transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
