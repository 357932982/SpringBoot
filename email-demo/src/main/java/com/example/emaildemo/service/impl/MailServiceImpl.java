package com.example.emaildemo.service.impl;

import com.example.emaildemo.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.UnsupportedEncodingException;

@Component
public class MailServiceImpl implements MailService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JavaMailSender mailSender;

    @Value("${mail.sender}")
    private String from;

    /**
     * 发送简单邮件
     *
     * @param to：收件人
     * @param subject： 主题
     * @param content： 正文
     */
    @Override
    public void sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        try {
            message.setFrom(String.valueOf(new InternetAddress(from, "小明")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        try {
            mailSender.send(message);
            logger.info("简单邮件已发送。");
        } catch (MailException e) {
            logger.error("发送简单邮件时发生异常！", e);
        }

    }

    /**
     * 发送HTML格式邮件
     *
     * @param to：收件人
     * @param subject： 主题
     * @param content： 正文
     */
    @Override
    public void sendHtmlMail(String to, String subject, String content) {

        MimeMessage message = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from, "小明");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

            mailSender.send(message);
            logger.info("html邮件发送成功");
        } catch (MessagingException e) {
            logger.error("发送html邮件时发生异常！", e);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送带附件邮件
     *
     * @param to：收件人
     * @param subject：  主题
     * @param content：  正文
     * @param filePath： 文件路径
     */
    @Override
    public void sendAttachmentMail(String to, String subject, String content, String filePath) {
        MimeMessage message = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from, "小明");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content);

//            添加附件文件
//            添加多个附件可以使用多条 helper.addAttachment(fileName, file)，可以用循环
            FileSystemResource file = new FileSystemResource(new File(filePath));
            String fileName = filePath.substring(filePath.lastIndexOf(File.separator) + 1);
            System.out.println(fileName);
            helper.addAttachment(fileName, file);

            mailSender.send(message);
            logger.info("带附件的邮件已经发送。");
        } catch (MessagingException e) {
            logger.error("发送带附件的邮件时发生异常！", e);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送正文中有静态资源邮件
     *
     * @param to：收件人
     * @param subject：       主题
     * @param content：       正文
     * @param rscPath：内嵌文件路径
     * @param rscId：静态文件名称
     */
    @Override
    public void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from, "小明");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

//            添加静态文件
            FileSystemResource resource = new FileSystemResource(new File(rscPath));
            helper.addInline(rscId, resource);

            mailSender.send(message);
            logger.info("嵌入静态资源的邮件已经发送。");
        } catch (MessagingException e) {
            logger.error("发送嵌入静态资源的邮件时发生异常！", e);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
