package nikhil.spring.activemq.listener;

import nikhil.spring.activemq.config.JmsConfig;
import nikhil.spring.activemq.model.HelloWorldMessage;
import org.apache.logging.log4j.message.Message;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @JmsListener(destination = JmsConfig.MY_QUEUE)
    public void listen(@Payload HelloWorldMessage helloWorldMessage,
                       @Headers MessageHeaders messageHeaders, Message message)
    {
        System.out.println("Za Warudo!!!!");

        System.out.println(helloWorldMessage);
    }
}
