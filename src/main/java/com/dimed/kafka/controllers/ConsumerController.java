package com.dimed.kafka.controllers;

import com.dimed.kafka.models.SimpleModel;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka")
public class ConsumerController {

    private Gson jsonConverter;

    @Autowired
    public ConsumerController (Gson jsonConverter) {
        this.jsonConverter = jsonConverter;
    }

    @KafkaListener(topics = {"reprocessamentos"})
    public void getFromKafka(String simpleModel) {
        System.out.println(simpleModel);

        SimpleModel simpleModel1 = jsonConverter.fromJson(simpleModel, SimpleModel.class);
        System.out.println("Object -> " + simpleModel1.toString());
    }
}
