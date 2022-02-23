package com.nisum.manager.repository;

import com.nisum.manager.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerServiceRepository extends JpaRepository<Manager, Long> {

}
