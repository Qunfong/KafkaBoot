package com.javasampleapproach.apachekafka.controller

import com.javasampleapproach.apachekafka.domain.User
import com.javasampleapproach.apachekafka.services.UserService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserControlle(private val userService: UserService) {

    @PostMapping(produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun createUser(@RequestParam("name") name: String,
                   @RequestParam("bank") bank: String,
                   @RequestParam("credit") credit: Int): User {
        return userService.save(name,bank,credit)
    }

    @GetMapping("{id}")
    fun getUser(@PathVariable id: Long) = userService.findById(id)
}