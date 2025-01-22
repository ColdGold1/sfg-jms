package org.example.cold.sfgjms.listener;

import jakarta.jms.Destination;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import lombok.RequiredArgsConstructor;
import org.example.cold.sfgjms.config.JmsConfig;
import org.example.cold.sfgjms.model.HelloWorldMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class HelloMessageListener {

    private final JmsTemplate jmsTemplate;

//    @JmsListener(destination = JmsConfig.MY_QUEUE)
//    public void listen(@Payload HelloWorldMessage helloWorldMessage,
//                       @Headers MessageHeaders headers, Message message){
//        //System.out.println("I Got a message ");
//        System.out.println(helloWorldMessage);
//    }

    @JmsListener(destination = JmsConfig.MY_SEND_RCV_QUEUE)
    public void listenForHello(@Payload HelloWorldMessage helloWorldMessage,
                       @Headers MessageHeaders headers, Message message) throws JMSException {

        HelloWorldMessage payload = HelloWorldMessage
                .builder()
                .id(UUID.randomUUID())
                .message("sahjdgkkajsdghajskldgahksd")
                .build();

        jmsTemplate.convertAndSend(message.getJMSReplyTo(), payload);
        //System.out.println("I Got a message ");
        //System.out.println(helloWorldMessage);
    }
}
