package com.hateos.service;

import com.hateos.model.cuenta;
import com.hateos.repository.CuentaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional  //ejecutar una transaccion rollback o commit
public class CuentaServices {

    @Autowired
    private CuentaRepository cuentaRepository;

    public List<cuenta> listAll(){
        return cuentaRepository.findAll();
    }




}
