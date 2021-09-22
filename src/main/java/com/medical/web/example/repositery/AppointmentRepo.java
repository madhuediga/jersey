package com.medical.web.example.repositery;

import com.medical.web.example.model.Appointment;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepo extends CassandraRepository<Appointment,Integer> {
}
