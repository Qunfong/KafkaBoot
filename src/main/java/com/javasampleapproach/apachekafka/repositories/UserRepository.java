package com.javasampleapproach.apachekafka.repositories;
import com.javasampleapproach.apachekafka.domain.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface UserRepository extends JpaRepository<User, String> {

    @NotNull
    User findById(long id);
}