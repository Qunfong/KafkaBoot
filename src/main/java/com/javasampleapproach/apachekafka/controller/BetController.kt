package com.javasampleapproach.apachekafka.controller

import com.javasampleapproach.apachekafka.domain.Bet
import com.javasampleapproach.apachekafka.domain.User
import com.javasampleapproach.apachekafka.services.BetService
import com.javasampleapproach.apachekafka.services.UserService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/bets")
class BetController(private val betService: BetService) {

    @PostMapping(produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun createBet(@RequestParam("userId") userId: Long,
                   @RequestParam("amount") amount: Int,
                  @RequestParam("rows") rows: Int): Bet {
        return betService.makeBet(userId,amount,rows)
    }


}