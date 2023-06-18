package fr.codeonce.kafka.config;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);


    @KafkaListener(topicPartitions = {@TopicPartition(topic = "testkafka", partitions = {"0"})}, groupId = "group_id")
    public void listenToPartition0(ConsumerRecord<String, String> record) {
    	LOGGER.info("Received message from partition 0: " + record.value());
    }


    @KafkaListener(topicPartitions = @TopicPartition(topic = "testkafka", partitions = {"1"}),
            groupId = "group_id")
    public void listenToPartition1(ConsumerRecord<String, String> record) {
    	LOGGER.info("Received message from partition 1: " + record.value());
    }
}