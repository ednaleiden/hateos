package com.hateos.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cuentas")
@NoArgsConstructor
@AllArgsConstructor
public class cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length= 20 ,nullable = false,unique = true)
    private String numeroDeCuenta;

    private float balance;

    public cuenta(Integer id, String numeroDeCuenta) {
        this.id = id;
        this.numeroDeCuenta = numeroDeCuenta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroDeCuenta() {
        return numeroDeCuenta;
    }

    public void setNumeroDeCuenta(String numeroDeCuenta) {
        this.numeroDeCuenta = numeroDeCuenta;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}
