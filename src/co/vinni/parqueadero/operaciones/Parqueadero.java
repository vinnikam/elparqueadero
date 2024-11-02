package co.vinni.parqueadero.operaciones;


import co.vinni.parqueadero.datos.Carro;
import co.vinni.parqueadero.datos.Moto;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author Vinni ®
 */
public class Parqueadero {
    private final int ESPACIOS_MOTO = 10;
    private final int ESPACIOS_CARRO = 20;
    
    private Carro[] carros;
    private Moto[] motos;

    public Parqueadero() {
        this.carros = new Carro[ESPACIOS_CARRO];
        this.motos = new Moto[ESPACIOS_MOTO];
    }
    
    public boolean agregarCarro(Carro elCarro){
        Date fechaIngreso = new Date();
        elCarro.modificarHoraIngreso(fechaIngreso);
        for (int i = 0; i < ESPACIOS_CARRO; i++) {
            if (carros[i] == null){
                carros[i] = elCarro;
                return true;
            }
        }
        return false;
    }
    public boolean agregarMoto(Moto laMoto){
        Date fechaIngreso = new Date();
        laMoto.setHoraIngreso(fechaIngreso);
        for (int i = 0; i < ESPACIOS_MOTO; i++) {
            if (motos[i] == null){
                motos[i] = laMoto;
                return true;
            }
        }
        return false;
        
    }
    public long sacarCarro(Carro elCarro){
        Carro carroSale= null;
        for (int i = 0; i < ESPACIOS_CARRO; i++) {
            Carro item = carros[i];
            if (item != null &&  elCarro.obtenerPlaca().equals(item.obtenerPlaca())){
            //if (elCarro.getPlaca() == carros[i].getPlaca()){
                carroSale = carros[i];
                carros[i] = null;
                break;
            }
        }
        long valor = calcularMinutosTranscurridos(carroSale.obtenerHoraIngreso());
        return valor;
    }
    public long sacarMoto(Moto laMoto){
        Moto motoSale = null;
        for (int i = 0; i < ESPACIOS_MOTO; i++) {
            Moto item = motos[i];
            if (item != null &&  laMoto.getPlaca().equals(item.getPlaca())){
            //if (elCarro.getPlaca() == carros[i].getPlaca()){
                motoSale = motos[i];
                motos[i] = null;
                break;
            }
        }
        long valor = calcularMinutosTranscurridos(motoSale.getHoraIngreso());
        return valor;
    }
    public int calcularCarro(Carro elCarro){
        return 8;
    }
    public int calcularMoto(Moto laMoto){
        return 10;
    }
    protected void salir(){}
    public Carro[] obtenerCarros(){
        return this.carros;
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
        return motos;
    }
    public boolean buscarCarro(String placa){
        boolean encontrado = Arrays.stream(carros)
                .filter(carro -> carro != null)
                .anyMatch(carro -> carro.obtenerPlaca().equals(placa));
        return encontrado;
    }
    public boolean buscarMoto(String placa){
       for (Moto moto : motos) {
            if (moto != null && moto.getPlaca().equals(placa)) {
                return true;
            }
        }
       return false;
    }
    public long cuposDisponiblesCarros(){
        return Arrays.stream(carros)
                           .filter(carro -> carro == null)
                           .count();
    }
    public long cuposDisponiblesMotos(){
        return Arrays.stream(motos)
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
}
