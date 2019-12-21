package com.sat.controller;

import com.sat.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("kafka")

public class UserController {

    @Autowired
    KafkaTemplate<String, User> kafkaTemplate;
    private static final String TOPIC= "kafka_produce";

    @PostMapping("/publish/user")
    public String publishMessage(@Valid  @RequestBody User user){
        kafkaTemplate.send(TOPIC, user);
        return "Published Sucessfully";
    }
}
