package com.hateos.controller;


import com.hateos.model.cuenta;
import com.hateos.service.CuentaServices;
import org.springframework.beans.factory.annotation.Autowired;
import  static  org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/cuentas")
public class cuentaController {

    @Autowired
    private CuentaServices cuentaService;

    @GetMapping
    public ResponseEntity<List<cuenta>> listarCuentas(){
        List<cuenta> Cuentas = cuentaService.listAll();

        if (Cuentas.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        for (cuenta Cuenta :Cuentas){
            Cuenta.add(linkTo(methodOn(cuentaController.class).listarCuenta(Cuenta.getId())).withSelfRel());
            Cuenta.add(linkTo(methodOn(cuentaController.class).listarCuentas()).withRel(IanaLinkRelations.COLLECTION));
        }

        CollectionModel<cuenta> modelo = CollectionModel.of(Cuentas);
        modelo.add(linkTo(methodOn(cuentaController.class).listarCuentas()).withSelfRel());
        return new ResponseEntity<>(Cuentas, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<cuenta>listarCuenta(@PathVariable Integer id){
        try{
            cuenta Cuenta = cuentaService.get(id);
            Cuenta.add(linkTo(methodOn(cuentaController.class).listarCuenta(Cuenta.getId())).withSelfRel());
            Cuenta.add(linkTo(methodOn(cuentaController.class).listarCuentas()).withRel(IanaLinkRelations.COLLECTION));
            return  new ResponseEntity<>(Cuenta, HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<cuenta> guardarCuenta(@RequestBody cuenta cuenta){
        cuenta cuentaBBOD = cuentaService.save (cuenta);

        cuentaBBOD.add(linkTo(methodOn(cuentaController.class).listarCuenta(cuentaBBOD.getId())).withSelfRel());
        cuenta.add(linkTo(methodOn(cuentaController.class).listarCuentas()).withRel(IanaLinkRelations.COLLECTION));
        return  ResponseEntity.created(linkTo(methodOn(cuentaController.class).listarCuenta(cuentaBBOD.getId())).toUri()).body(cuentaBBOD);
    }


    @PutMapping
    public ResponseEntity<cuenta> editarCuenta(@RequestBody cuenta cuenta) {
        cuenta cuentaBBOD = cuentaService.save(cuenta);
        return new ResponseEntity<>(cuentaBBOD, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
            public ResponseEntity<?> eliminarCuenta(@PathVariable Integer id) {
        try {
            cuentaService.deleteCuenta(id);
            return ResponseEntity.noContent().build();
        } catch (Exception exception) {
            return ResponseEntity.notFound().build();

        }
    }
}
