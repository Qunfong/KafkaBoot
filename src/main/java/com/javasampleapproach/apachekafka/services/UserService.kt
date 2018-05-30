package com.javasampleapproach.apachekafka.services

import com.javasampleapproach.apachekafka.domain.User
import com.javasampleapproach.apachekafka.repositories.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun save(name:String, bank:String, credit: Int): User {
        val user = User();
        user.name = name;
        user.bank = bank;
        user.credit = credit;
        return userRepository.save(user)
    }

    fun findById(id: Long) = userRepository.findById(id);


}