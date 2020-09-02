package nikhil.spring.activemq.sender;

import lombok.RequiredArgsConstructor;
import nikhil.spring.activemq.config.JmsConfig;
import nikhil.spring.activemq.model.HelloWorldMessage;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class HelloSender {

    private final JmsTemplate jmsTemplate;

    @Scheduled(fixedRate = 2000)
    public void sendMessage(){
        System.out.println("Kono Dio Da");

        HelloWorldMessage message =  HelloWorldMessage.builder()
                .id(UUID.randomUUID())
                .message("Jotaroooo!!")
                .build();

        //Talks with ActiveMQ template and uses the JmsConfig
        jmsTemplate.convertAndSend(JmsConfig.MY_QUEUE, message);

        System.out.println("Ceezzzaaaaaaaa!!!!!!");
    }
}
