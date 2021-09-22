package com.medical.web.example.repositery;

import com.medical.web.example.model.Admin;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdminRepositery extends CassandraRepository<Admin,Integer> {

    Optional<Admin> findByEmail(String email);

    List<Admin> findByRole(String role);

}
