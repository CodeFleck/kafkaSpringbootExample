package com.dimed.kafka.controllers;

import com.dimed.kafka.models.SimpleModel;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka")
public class ProducerController {

    private KafkaTemplate<String, String> kafkaTemplate;
    private Gson jsonConverter;

    @Autowired
    public ProducerController(KafkaTemplate<String, String> kafkaTemplate, Gson jsonConverter) {
        this.kafkaTemplate = kafkaTemplate;
        this.jsonConverter = jsonConverter;
    }

    @PostMapping
    public void post(@RequestBody SimpleModel simpleModel) {
        kafkaTemplate.send("reprocessamentos", jsonConverter.toJson(simpleModel));
    }
}
