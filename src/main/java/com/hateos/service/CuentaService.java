package com.hateos.service;


import com.hateos.exceptions.CuentaNotFoundException;
import com.hateos.model.Cuenta;
import com.hateos.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;

    public List<Cuenta> listAll(){
        return cuentaRepository.findAll();
    }

    public Cuenta get(Integer id){
        return cuentaRepository.findById(id).get();
    }

    public Cuenta save(Cuenta cuenta){
        return cuentaRepository.save(cuenta);
    }

    public void delete(Integer id) throws CuentaNotFoundException {

        if (!cuentaRepository.existsById(id)){
           throw new CuentaNotFoundException("cuenta no encontrada con el ID" +  id);
        }else {
            cuentaRepository.deleteById(id);
        }

    }

    public Cuenta depositar(float monto,Integer id){
        cuentaRepository.actualizarMonto(monto, id);
        return cuentaRepository.findById(id).get();
    }

    public Cuenta retitar(float monto,Integer id){
        cuentaRepository.actualizarMonto(-monto, id);
        return cuentaRepository.findById(id).get();
    }
}
