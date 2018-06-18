package spring.boot.controller;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import spring.boot.config.EmailConfig;
import spring.boot.pojo.Email;

@RestController
public class MailController {
	@Autowired
	EmailConfig mc;
	@Autowired
	TemplateEngine templateEngine;
	
	@RequestMapping("/mail")
	public void send() throws GeneralSecurityException, UnsupportedEncodingException, MessagingException {
		Email email = new Email();
	    email.setReceiver("1143594156@qq.com");
	    email.setContent("welcome ");
	    email.setSubject("test");
	    mc.sendSimpleMail(email);
	    mc.sendSimpleMail2("1143594156@qq.com", "Jaray", "你好");
	    String content="<html>\n" +
	            "<body>\n" +
	            "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
	            "</body>\n" +
	            "</html>";
	    mc.sendHtmlMail("1143594156@qq.com", "JiaLei", content);
	    mc.sendAttachmentsMail("1143594156@qq.com", "主题：带附件的邮件", "有附件，请查收！", "C:\\Users\\Administrator\\Desktop\\如何准备Java初级和高级的技术面试.docx");
	    
	    String rscId = "neo006";
	    content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
	    String imgPath = "C:\\Users\\Administrator\\Desktop\\getqqicon.jpg";

	    //添加多个图片可以使用多条<img src='cid:" + rscId + "' > 和 helper.addInline(rscId, res) 来实现
	    mc.sendInlineResourceMail("1143594156@qq.com", "主题：这是有图片的邮件", content, imgPath, rscId);
	    System.out.println("successful to send message");
	    
	    
	    //创建邮件正文
	    Context context = new Context();
	    context.setVariable("id", "006");
	    String emailContent = templateEngine.process("emailTemplate", context);

	    mc.sendHtmlMail("1143594156@qq.com","主题：这是模板邮件",emailContent);
	}

}
