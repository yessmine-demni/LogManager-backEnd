package com.vermeg.logmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vermeg.logmanager.entities.Machine;

@Repository
public interface MachineRepository extends JpaRepository<Machine, Integer> {
}
