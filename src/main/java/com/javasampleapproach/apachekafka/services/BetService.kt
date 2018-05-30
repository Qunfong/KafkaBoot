package com.javasampleapproach.apachekafka.services

import com.javasampleapproach.apachekafka.domain.Bet
import com.javasampleapproach.apachekafka.domain.User
import com.javasampleapproach.apachekafka.repositories.BetRepository
import com.javasampleapproach.apachekafka.repositories.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.support.MessageBuilder
import com.fasterxml.jackson.databind.ObjectMapper





@Suppress("SpringKotlinAutowiring")
@Service
class BetService(private val userRepository: UserRepository, private val betRepository: BetRepository){
    private val log = LoggerFactory.getLogger(BetService::class.java)

    @Autowired
    private val kafkaTemplate: KafkaTemplate<String, String>? = null

    @Value("\${jsa.kafka.topic}")
    internal var kafkaTopic = "jsa-test"

    fun makeBet(userId:Long,amount:Int,rows:Int): Bet {
        val bet = Bet()
        bet.user = userRepository.findById(userId)
        bet.amount = amount
        bet.rows = rows

        sendBetToMachine(bet)
        return saveBet(bet)

    }

    private fun sendBetToMachine(bet: Bet) {
        val mapper = ObjectMapper()

        val message = MessageBuilder
                .withPayload<String>(mapper.writeValueAsString(bet))
                .setHeader(KafkaHeaders.TOPIC, kafkaTopic)
                .build()
        kafkaTemplate?.send(message)
    }

    private fun saveBet(bet:Bet): Bet {
        return betRepository.save(bet)
    }
}