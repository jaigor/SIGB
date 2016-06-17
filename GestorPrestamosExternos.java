import java.io.File;
import java.io.IOException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.util.ArrayList;

/**
 * Write a description of class GestorPrestBiblio here.
 * 
 * @author Igor Quintela 
 * @version 17/06/2016
 */
public class GestorPrestamosExternos extends GestorPrestamos
{
    private ArrayList<Prestamo> prestamosExternos;
    
    /**
     * Constructor for objects of class GestorPrestamosExternos
     */
    public GestorPrestamosExternos()
    {
        prestamosExternos = new ArrayList<Prestamo>();
    }

    /**
     * Método para retornar la colección
     * de préstamos externos
     * 
     * @return     listado de prestamos externos 
     */
    public ArrayList<Prestamo> getPrestamosExternos()
    {
        return prestamosExternos;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
    public void exportar(String ruta)
    {
        File archivo = new File(ruta);
        try{
            FileOutputStream fos = new FileOutputStream(archivo);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Prestamo p : this.prestamosExternos){
                oos.writeObject(p);
            }
            oos.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    */
    /**
     * An example of a method - replace this comment with your own
     * 
     */
    public void importarPrestamos(String ruta)
    {
        File archivo = new File(ruta);
        boolean salir = false;
        try{
            FileInputStream fis = new FileInputStream(archivo);
            ObjectInputStream ois = new ObjectInputStream(fis);
            PrestamoExterno pe = leerArchivo(ois);
            while (pe != null){
                Biblioteca.getInstacia().getGestPrest().añadirPrestamo(pe.getMatPrestado(),pe.getSocioPrestamo());
                pe = leerArchivo(ois);
            } 
            ois.close();
        }
        catch (EOFException e) {
            System.out.println("El archivo está vacio");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * An example of a method - replace this comment with your own
     * 
    */
    public PrestamoExterno leerArchivo(ObjectInputStream ois)
    {
        PrestamoExterno pe;
        try {
            pe = (PrestamoExterno)ois.readObject();
        }
        catch (Exception e){
            pe = null;
        }
        return pe;    
    }
}
