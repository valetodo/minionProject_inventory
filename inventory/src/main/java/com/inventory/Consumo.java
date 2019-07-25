package com.inventory;

import java.util.Date;

public class Consumo extends Product {
    private Date expiracion;

    public Date getExpiracion() {
        return expiracion;
    }

    public void setExpiracion(Date expiracion) {
        this.expiracion = expiracion;
    }

}