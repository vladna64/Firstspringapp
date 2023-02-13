package com.example.repository;

import com.example.model.PersonForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
//@EnableJpaRepositories
public interface PersonRepository extends JpaRepository<PersonForm, Long> {
    @Query("SELECT u FROM PersonForm u")
    Collection<PersonForm> findAllPerson();
}
