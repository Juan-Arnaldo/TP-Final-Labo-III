package com.company.Operacion;

public class Compra extends Operacion implements ActualizacionRegistro{


    @Override
    public boolean actualizarCaja() {
        return false;
    }

    @Override
    public boolean actualizarStock() {
        return false;
    }
}
