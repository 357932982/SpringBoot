package com.example.emaildemo;

import com.example.emaildemo.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailDemoApplicationTests {

    @Autowired
    private MailService mailService;

    @Test
    public void testSimpleMail() {
        mailService.sendSimpleMail("2929227563@qq.com", "测试", "测试简单邮件");
    }

    @Test
    public void testHtmlMail(){
        String content="<html>\n" +
                "<body>\n" +
                "    <h1>hello world ! 这是一封Html邮件!</h1>\n" +
                "</body>\n" +
                "</html>";
        mailService.sendHtmlMail("357932982@qq.com", "测试", content);
    }

    @Test
    public void testAttachmentsMail(){
        String filePath = "F:\\BaiduNetdiskDownload\\tree.txt";
        mailService.sendAttachmentMail("2929227563@qq.com", "附件邮件", "有附件", filePath );
    }

    @Test
    public void testInlineResourceMail(){
        String rscId = "a001";
        String rscPath = "C:\\Users\\Sony\\Desktop\\SpringBoot\\timg.jpg";
        String content="<html><body><h1>这是有图片的邮件：</h1><img src=\"cid:" + rscId + "\" ></body></html>";
        System.out.println(content);
        mailService.sendInlineResourceMail("2929227563@qq.com", "带图片的邮件", content, rscPath, rscId);
    }

}
