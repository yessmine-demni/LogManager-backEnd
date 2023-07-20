package com.vermeg.logmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vermeg.logmanager.entities.Log;

@Repository
public interface LogRepository extends JpaRepository<Log, Integer> {
}
