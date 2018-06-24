package com.example.rabbitmq;

import com.example.rabbitmq.entity.User;
import com.example.rabbitmq.many.Sender_1;
import com.example.rabbitmq.many.Sender_2;
import com.example.rabbitmq.object.SendUser;
import com.example.rabbitmq.onece.Sender;
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
    public void sendUserTest() {
        User user = new User("小明", 19);
        sendUser.send(user);
    }

}
