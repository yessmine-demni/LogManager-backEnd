package com.vermeg.logmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vermeg.logmanager.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
