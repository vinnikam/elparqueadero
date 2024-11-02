package co.vinni.parqueadero.datos;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Vinni ®
 */
public class Moto implements Serializable {
    private String placa;
    private int modelo;
    private Date horaIngreso ;

    // 1 es un metodo que no tiene retorno puede tener cero o n parametros
    // 2 nombre es el de la clase
    // 3 se ejecuta al invocar el new Nombreclase;
    // 4 solo se ejecuta 1 vez por instancia
    
    public Moto(){
        System.out.println("El constructor de moto");
    }
    
    
    
    
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public Date getHoraIngreso() {
        return horaIngreso;
    }

    public void setHoraIngreso(Date horaIngreso) {
        this.horaIngreso = horaIngreso;
    }
    
}
