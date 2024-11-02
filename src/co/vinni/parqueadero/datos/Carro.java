/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.vinni.parqueadero.datos;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Vinni ®
 */
public class Carro implements Serializable {
    private String placa;
    private int modelo;
    private Date horaIngreso ;
    private String color;
    
    
    
    private Moto marca;
    
    public void modificarMarca(Moto moto){
        marca = moto;
    }
    public Moto obtenerMarca(){
        return marca;
    }
    
    
    
    public String obtenerPlaca() {
        return placa;
    }

    public void modificarPlaca(String placa) {
        this.placa = placa;
    }

    public int obtenerModelo() {
        return modelo;
    }

    public void modificarModelo(int modelo) {
        this.modelo = modelo;
    }

    public Date obtenerHoraIngreso() {
        return horaIngreso;
    }

    public void modificarHoraIngreso(Date horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    public String obtenerColor() {
        return color;
    }

    public void modificarColor(String color) {
        this.color = color;
    }
    
    
}
