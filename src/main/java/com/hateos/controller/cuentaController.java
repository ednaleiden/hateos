package com.hateos.controller;


import com.hateos.model.cuenta;
import com.hateos.service.CuentaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cuentas")
public class cuentaController {

    @Autowired
    private CuentaServices cuentaService;

    @GetMapping
    public ResponseEntity<List<cuenta>> listarCuenta(){
        List<cuenta> Cuentas = cuentaService.listAll();

        if (Cuentas.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(Cuentas, HttpStatus.OK);

    }
}
