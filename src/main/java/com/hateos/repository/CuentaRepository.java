package com.hateos.repository;

import com.hateos.model.cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaRepository extends JpaRepository<cuenta,Integer> {

    
}
