package com.hateos.repository;

import com.hateos.model.cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaRepository extends JpaRepository<cuenta,Integer> {

    @Query("UPDATE cuante c SET c.balance=c. + ?1  WHERE c.id=?2")
    @Modifying
    void actualizarBalance(float monto,Integer id);

}
