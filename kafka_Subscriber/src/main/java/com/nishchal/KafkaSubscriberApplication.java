package com.nishchal;

import com.nishchal.constants.AppConstants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
// kafaka listener should be add here in main spring boot class
@SpringBootApplication
public class KafkaSubscriberApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaSubscriberApplication.class, args);
    }

    // this listener will listen the message what ever comes to the kafka topic.
    @KafkaListener(topics = AppConstants.TOPIC_NAME, groupId="com.nishchal")
    public void subscribeMsg(String order) {
        System.out.print("*** Msg Recieved From Kafka *** :: ");
        System.out.println(order);
        //logic
    }
}

