package com.javasampleapproach.apachekafka.repositories;
import com.javasampleapproach.apachekafka.domain.Bet;
import com.javasampleapproach.apachekafka.domain.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface BetRepository extends JpaRepository<Bet, String> {

    @NotNull
    Bet findById(long id);
}