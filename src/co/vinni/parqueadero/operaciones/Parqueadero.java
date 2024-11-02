package co.vinni.parqueadero.operaciones;


import co.vinni.parqueadero.datos.Carro;
import co.vinni.parqueadero.datos.Espacios;
import co.vinni.parqueadero.datos.Moto;
import co.vinni.parqueadero.persistencia.UtilArchivos;
import jdk.jshell.execution.Util;

import java.io.Serializable;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author Vinni ®
 */
public class Parqueadero implements Serializable {
    private final int ESPACIOS_MOTO = 10;
    private final int ESPACIOS_CARRO = 20;
    
    //private Carro[] carros;
    //private Moto[] motos;

    private Espacios espacios;

    private String archivo = "espacios.dat";
    public Parqueadero() {

        UtilArchivos util = new UtilArchivos();
        espacios =  (Espacios)util.recuperarObjeto(archivo);
        if (espacios == null) {
            this.espacios = new Espacios(ESPACIOS_CARRO, ESPACIOS_MOTO);

        }

    }
    
    public boolean agregarCarro(Carro elCarro){
        Date fechaIngreso = new Date();
        elCarro.modificarHoraIngreso(fechaIngreso);
        for (int i = 0; i < ESPACIOS_CARRO; i++) {
            if (espacios.getCarros()[i] == null){
                espacios.getCarros()[i] = elCarro;
                this.actualizar();
                return true;
            }
        }
        return false;
    }
    public boolean agregarMoto(Moto laMoto){
        Date fechaIngreso = new Date();
        laMoto.setHoraIngreso(fechaIngreso);
        for (int i = 0; i < ESPACIOS_MOTO; i++) {
            if (espacios.getMotos()[i] == null){
                espacios.getMotos()[i] = laMoto;
                this.actualizar();
                return true;
            }
        }
        return false;
        
    }
    public long sacarCarro(Carro elCarro){
        Carro carroSale= null;
        for (int i = 0; i < ESPACIOS_CARRO; i++) {
            Carro item = espacios.getCarros()[i];
            if (item != null &&  elCarro.obtenerPlaca().equals(item.obtenerPlaca())){
            //if (elCarro.getPlaca() == carros[i].getPlaca()){
                carroSale = espacios.getCarros()[i];
                espacios.getCarros()[i] = null;
                this.actualizar();
                break;
            }
        }
        long valor = calcularMinutosTranscurridos(carroSale.obtenerHoraIngreso());
        return valor;
    }
    public long sacarMoto(Moto laMoto){
        Moto motoSale = null;
        for (int i = 0; i < ESPACIOS_MOTO; i++) {
            Moto item = espacios.getMotos()[i];
            if (item != null &&  laMoto.getPlaca().equals(item.getPlaca())){
            //if (elCarro.getPlaca() == carros[i].getPlaca()){
                motoSale = espacios.getMotos()[i];
                espacios.getCarros()[i] = null;
                this.actualizar();
                break;
            }
        }
        long valor = calcularMinutosTranscurridos(motoSale.getHoraIngreso());
        return valor;
    }

    public Carro[] obtenerCarros(){
        return this.espacios.getCarros();
    }
//    public String calcularMotox(Moto laMoto){
//        return "fggf";
//    }
//    public Long calcularMotox2(Moto laMoto){
//        return null;
//    }
//    public Carro calcularMotox22(Moto laMoto){
//        return null;
//    }

    public Moto[] obtenerMotos() {
        return this.espacios.getMotos();
    }
    public boolean buscarCarro(String placa){
        boolean encontrado = Arrays.stream(espacios.getCarros())
                .filter(carro -> carro != null)
                .anyMatch(carro -> carro.obtenerPlaca().equals(placa));
        return encontrado;
    }
    public boolean buscarMoto(String placa){
       for (Moto moto : this.espacios.getMotos()) {
            if (moto != null && moto.getPlaca().equals(placa)) {
                return true;
            }
        }
       return false;
    }
    public long cuposDisponiblesCarros(){
        return Arrays.stream(espacios.getCarros())
                           .filter(carro -> carro == null)
                           .count();
    }
    public long cuposDisponiblesMotos(){
        return Arrays.stream(this.espacios.getMotos())
                           .filter(moto -> moto == null)
                           .count();
    }
    
     private long calcularMinutosTranscurridos(Date inicio) {
        Date fin = new Date();
        Instant inicioInstant = inicio.toInstant();
        Instant finInstant = fin.toInstant();
        Duration duracion = Duration.between(inicioInstant, finInstant);
        return duracion.toMinutes();
    }
    private void actualizar(){
        UtilArchivos util  = new UtilArchivos();
        util.almacenarObjeto(archivo, espacios);
    }
}
