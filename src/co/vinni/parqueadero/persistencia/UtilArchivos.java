package co.vinni.parqueadero.persistencia;

import java.io.*;

public class UtilArchivos {
    public void almacenarObjeto (String archivo, Object objeto){
        try (FileOutputStream fileOut = new FileOutputStream(archivo);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(objeto);
            System.out.println("El objeto se almaceno en archivo binario");
        } catch (IOException i) {
            System.out.println("Objeto no se pudo almacenar");
            //i.printStackTrace();
        }
    }
    public Object recuperarObjeto (String archivo){
        try (FileInputStream fileIn = new FileInputStream(archivo);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            return  in.readObject();
        } catch (IOException i) {
            //i.printStackTrace();
            System.out.println("Objeto en archivo no  encontrado");
        } catch (ClassNotFoundException c) {
            System.out.println("Objeto en archivo no  encontrado");
            //c.printStackTrace();
        }
        return null;
    }
}
