package fr.codeonce.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.codeonce.kafka.config.KafkaConsumer;
import fr.codeonce.kafka.config.KafkaProducer;

@RestController
@RequestMapping("/api/v1/kafka")
public class KafkaProducerController {
	
	@Autowired
	private KafkaConsumer kafkaconsumer;

    private KafkaProducer kafkaProducer;

    public KafkaProducerController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @GetMapping("/publish0")
    public ResponseEntity<String> publish0(@RequestParam("message") String message){
        kafkaProducer.sendMessageToPartition0(message);
        return ResponseEntity.ok("Message sent to kafka topic");
    }
    @GetMapping("/publish1")
    public ResponseEntity<String> publish1(@RequestParam("message") String message){
        kafkaProducer.sendMessageToPartition1(message);
        return ResponseEntity.ok("Message sent to kafka topic");
    }
    
   
}