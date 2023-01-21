package com.thamiprojects.clientrestapi.repository;

import com.thamiprojects.clientrestapi.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Client Repo is not used this time as we're not persisting to any database
@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
