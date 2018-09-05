package day8;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MsgMailTest {

	public static  void sendMail(String from,String to,String subject,String msgText) {
		// TODO Auto-generated method stub
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.qq.com");
		prop.put("debug", true);
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(prop, null);
		session.setDebug(false);
		
		try {
		    MimeMessage msg = new MimeMessage(session);
		    msg.setFrom(new InternetAddress(from));
		    InternetAddress[] address = {new InternetAddress(to)};
		    msg.setRecipients(Message.RecipientType.TO, address);
		    msg.setSubject(subject);
		    msg.setSentDate(new Date());
		    msg.setText(msgText);
		    //xxx” œ‰”√ªß√˚£¨yyy£¨” œ‰√‹¬Î
		    Transport.send(msg,"657901225","cetmrwdwiynpbcjg");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static void main(String[] args) {
		MsgMailTest.sendMail("657901225@qq.com", "wangbowx@163.com", "Hello", "Email Test");
	}

}
