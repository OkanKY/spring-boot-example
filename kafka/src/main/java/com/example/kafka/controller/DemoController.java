package com.example.kafka.controller;

import com.example.kafka.consumer.KafkaConsumer;
import com.example.kafka.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka")
@RequiredArgsConstructor
public class DemoController {

    private final KafkaProducer kafkaProducer;
    private final KafkaConsumer kafkaConsumer;

    @GetMapping(value = "/produce")
    public void produce(@RequestParam String topic, @RequestParam String payload) {
        kafkaProducer.send(topic, payload);
    }

    @GetMapping(value = "/consume")
    public String consume() {
        return kafkaConsumer.getPayload();
    }



}
