//package com.javasampleapproach.apachekafka.services;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.javasampleapproach.apachekafka.domain.Bet;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.stereotype.Component;
//
//import com.javasampleapproach.apachekafka.storage.MessageStorage;
//
//@Component
//public class KafkaConsumer {
//	private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);
//
//	@Autowired
//	MessageStorage storage;
//
//	@KafkaListener(topics="${jsa.kafka.topic}")
//
//	public void processMessage(@Payload String bet) {
//		log.info("received content = '{}'", );
////		storage.put(content);
//    }
//}
