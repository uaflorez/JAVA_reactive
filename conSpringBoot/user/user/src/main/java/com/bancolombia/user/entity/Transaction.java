package com.bancolombia.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;
    private double monto;

    public String getTipo() {
        return tipo;
    }
    public double getMonto() {
        return monto;
    }



    public void setId(Long id) {
        this.id = id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}
