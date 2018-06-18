package spring.boot.config;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.sun.mail.util.MailSSLSocketFactory;
import spring.boot.pojo.Email;  
  
@Component
@Configuration
public class EmailConfig {  
	@Autowired 
	private Environment env;
	@Autowired
    private JavaMailSender mailSender;
	static {
		System.setProperty("mail.mime.splitlongparameters","false");
	}

    @Bean
    public JavaMailSenderImpl getMailSender() throws GeneralSecurityException{
    	MailSSLSocketFactory sf = new MailSSLSocketFactory();
    	sf.setTrustAllHosts(true);
        JavaMailSenderImpl javaMailSender= new JavaMailSenderImpl();
        javaMailSender.setHost(env.getProperty("spring.mail.host"));
        javaMailSender.setUsername(env.getProperty("spring.mail.username"));
        javaMailSender.setPassword(env.getProperty("spring.mail.password"));
        Properties properties=new Properties();
        properties.put("mail.smtp.host", env.getProperty("spring.mail.host"));
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", env.getProperty("spring.mail.properties.smtp.auth"));
        properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.ssl.socketFactory", sf);
        properties.put("mail.smtp.timeout", env.getProperty("spring.mail.properties.smtp.timeout"));
        javaMailSender.setJavaMailProperties(properties);
        return javaMailSender;
    }

    public void sendSimpleMail(Email email) throws GeneralSecurityException{
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setFrom(env.getProperty("spring.mail.username"));
        String receiver=email.getReceiver();
        String receivers[]=receiver.split(";");
        simpleMailMessage.setTo(receivers);
        simpleMailMessage.setSubject(email.getSubject());
        simpleMailMessage.setText(email.getContent());
        mailSender.send(simpleMailMessage);
    }
    
    public void sendSimpleMail2(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(env.getProperty("spring.mail.username"));
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);

        try {
            mailSender.send(message);
            System.out.println("简单邮件已经发送。");
        } catch (Exception e) {
        	System.out.println("发送简单邮件时发生异常！" + e);
        }
    }
    
    public void sendHtmlMail(String to, String subject, String content) throws UnsupportedEncodingException {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            //true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");//"UTF-8"解决中文乱码
            helper.setFrom(env.getProperty("spring.mail.username"));
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

            mailSender.send(message);
            System.out.println("html邮件发送成功");
        } catch (MessagingException e) {
        	System.out.println("发送html邮件时发生异常！" + e);
        }
    }
    
    public void sendAttachmentsMail(String to, String subject, String content, String filePath) throws UnsupportedEncodingException, MessagingException{
        MimeMessage message = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");//"UTF-8"解决中文乱码
            helper.setFrom(env.getProperty("spring.mail.username"));
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

            FileSystemResource file = new FileSystemResource(new File(filePath));
            String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
            helper.addAttachment(fileName, file);
            helper.addAttachment(fileName, file);//添加多个附件可以使用多条

            mailSender.send(message);
            System.out.println("带附件的邮件已经发送。");
        } catch (MessagingException e) {
        	System.out.println("发送带附件的邮件时发生异常！" + e);
        }
    }
    
    public void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId){
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setFrom(env.getProperty("spring.mail.username"));
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

            FileSystemResource res = new FileSystemResource(new File(rscPath));
            helper.addInline(rscId, res);

            mailSender.send(message);
            System.out.println("嵌入静态资源的邮件已经发送。");
        } catch (MessagingException e) {
        	System.out.println("发送嵌入静态资源的邮件时发生异常！" + e);
        }
    }
      
}  