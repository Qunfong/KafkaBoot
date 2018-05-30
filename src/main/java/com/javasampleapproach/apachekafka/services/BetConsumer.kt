package com.javasampleapproach.apachekafka.services

import com.fasterxml.jackson.databind.ObjectMapper
import com.javasampleapproach.apachekafka.domain.Bet
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

import com.javasampleapproach.apachekafka.storage.MessageStorage



@Component
class BetConsumer {

    @Autowired
    internal var storage: MessageStorage? = null

    @KafkaListener(topics = arrayOf("\${jsa.kafka.topic}"))
    fun processMessage(@Payload bet: String) {
        val mapper = ObjectMapper()
        val convertedBet = mapper.readValue(bet, Bet::class.java)
        log.info("received content = '{}'", convertedBet);
        //		storage.put(content);
    }

    companion object {
        private val log = LoggerFactory.getLogger(KafkaProducer::class.java)
    }
}
