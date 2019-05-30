package com.mengxuegu.springboot10mail;

import com.bean.Mail;
import lombok.Data;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Data
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot10MailApplicationTests {

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    Mail mail;




    //  发送一个简单邮件（只有文字  没有附件）
    @Test
    public void testSimpleMail() {
        // 封装简单的邮件内容
        SimpleMailMessage message = new SimpleMailMessage();
        // 标题
        message.setSubject("放假通知");
        //正文
        message.setText("放假啦");
        // 发件人
        message.setFrom("273689468@qq.com");
        // 收件人
        message.setTo("328799352@qq.com");
        javaMailSender.send(message);
    }


    // 发送副本邮件
    @Test
    public void testMimeMail() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        // 邮件的帮助类
        //  通过消息帮助对象  设置mulitipart的值为true  可以发送附件
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
        // 标题
        mimeMessageHelper.setSubject("放假通知");
        //正文
        mimeMessageHelper.setText("放假啦");
        // 附件
        mimeMessageHelper.addAttachment("haoke.jpg",new FileSystemResource("F:\\淘宝教育\\SpringBootPractice\\spring-boot-10-mail\\src\\main\\resources\\images\\haoke.jpg"));
        // 发件人
        mimeMessageHelper.setFrom("273689468@qq.com");
        // 收件人
        mimeMessageHelper.setTo("328799352@qq.com");

        javaMailSender.send(mimeMessage);

    }




    // 将mail的属性通过配置文件注入
    @Test
    public void test3() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
        // 标题
        mimeMessageHelper.setSubject(mail.getSubject());
        //正文
        mimeMessageHelper.setText(mail.getText());
        // 附件
        mimeMessageHelper.addAttachment(mail.getPicname(),new FileSystemResource(mail.getPicloacation()));
        // 发件人
        mimeMessageHelper.setFrom(mail.getFrom());
        // 收件人
        mimeMessageHelper.setTo(mail.getTo());

        javaMailSender.send(mimeMessage);

    }

}
