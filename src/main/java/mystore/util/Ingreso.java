package mystore.util;

import lombok.RequiredArgsConstructor;


public class Ingreso {

    private final Prueba prueba;
    public Ingreso(Prueba prueba){
        this.prueba = prueba;
    }

    public void find() {
        prueba.hola();
    }
}
