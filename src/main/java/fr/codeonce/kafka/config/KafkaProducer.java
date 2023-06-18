package fr.codeonce.kafka.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.apache.kafka.clients.producer.ProducerRecord;

@Service
public class KafkaProducer {

    private static final Logger LOGGER =  LoggerFactory.getLogger(KafkaProducer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessageToPartition0(String message) {
        kafkaTemplate.send(new ProducerRecord<>("testkafka", 0, null, message));
        LOGGER.info("Sent to Partition 0: " + message);
    }

    public void sendMessageToPartition1(String message) {
        kafkaTemplate.send(new ProducerRecord<>("testkafka", 1, null, message));
        LOGGER.info("Sent to Partition 1: " + message);
    }
}
