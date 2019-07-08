package votingapi.services;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import votingapi.Application;

@Component
public class RabbitMqServce {

    private final RabbitTemplate rabbitTemplate;

    public RabbitMqServce(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(Object data) {
        System.out.println("Sending message...");
        rabbitTemplate.convertAndSend(Application.topicExchangeName, "foo.bar.baz", data);
    }

}