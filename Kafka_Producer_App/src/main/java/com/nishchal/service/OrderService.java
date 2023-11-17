package com.nishchal.service;
// this is
import com.nishchal.binding.Order;
import com.nishchal.constants.AppConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

// here logic goes to publish the message in to the kafka topic.
@Service
public class OrderService {

//@Autowired
    //private KafkaTemplate<String, Order> kafkaTemplate;  // we can create constructor instead of autowire as well.
    private KafkaTemplate<String, Order> kafkaTemplate;

    public OrderService(KafkaTemplate<String, Order> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public String addMsg(Order order) {

        // publish msg to kafka topic
        kafkaTemplate.send(AppConstants.TOPIC_NAME, order);

        return "Msg Published To Kafka Topic";
    }
}
