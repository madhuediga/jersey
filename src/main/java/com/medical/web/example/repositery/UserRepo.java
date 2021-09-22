package com.medical.web.example.repositery;

import com.medical.web.example.model.User;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends CassandraRepository<User,Integer> {

    Optional<User> findByEmail(String email);

    Optional<User> findByConfirmationToken(String token);

}
