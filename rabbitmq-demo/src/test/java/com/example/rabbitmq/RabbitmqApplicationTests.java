package com.example.rabbitmq;

import com.example.rabbitmq.entity.User;
import com.example.rabbitmq.fanout.FanoutSender;
import com.example.rabbitmq.many.Sender_1;
import com.example.rabbitmq.many.Sender_2;
import com.example.rabbitmq.object.SendUser;
import com.example.rabbitmq.onece.Sender;
import com.example.rabbitmq.topic.TopicSender;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqApplicationTests {

    @Autowired
    private Sender sender;

    @Autowired
    private Sender_1 sender_1;

    @Autowired
    private Sender_2 sender_2;

    @Autowired
    private SendUser sendUser;
    
    @Autowired
    private TopicSender topicsender;

    @Autowired
    private FanoutSender fanoutSender;

    @Test
    public void contextLoads() {
        sender.send();
    }

    @Test
    public void one2many() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            sender_1.send(i);
            sender_2.send(i);
            Thread.sleep(1000);
        }
    }

    @Test
    public void sendUserTest(){
        User user = new User("小明", 19);
        sendUser.send(user);
    }
    
    @Test
    public void topicSender() {
    	topicsender.send();
    }

    @Test
    public void topicSender1() {
        topicsender.send1();
    }

    @Test
    public void fanoutSend(){
        fanoutSender.send();
    }


}
