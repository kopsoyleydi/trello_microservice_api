package com.example.kafka_service.config;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic serviceStudentTopic(){
        return TopicBuilder.name("messaging").build();
    }
}
