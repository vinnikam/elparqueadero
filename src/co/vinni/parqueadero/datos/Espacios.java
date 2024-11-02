package co.vinni.parqueadero.datos;

import java.io.Serializable;

public class Espacios implements Serializable {
    private Carro[] carros;
    private Moto[] motos;

    public Espacios(int espaciosCarro, int espaciosMoto) {
        this.carros = new Carro[espaciosCarro];
        this.motos = new Moto[espaciosMoto];
    }

    public Carro[] getCarros() {
        return carros;
    }


    public Moto[] getMotos() {
        return motos;
    }
}
