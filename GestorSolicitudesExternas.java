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
public class GestorSolicitudesExternas extends GestorPrestamos
{
    private ArrayList<MaterialExterno> solicitudes;
    private ArrayList<Biblioteca> bibliotecas;
    
    /**
     * Constructor for objects of class GestorPrestamosExternos
     */
    public GestorSolicitudesExternas()
    {
        solicitudes = new ArrayList<MaterialExterno>();
        bibliotecas = new ArrayList<Biblioteca>();
    }

    /**
     * Método para retornar la colección
     * de préstamos externos
     * 
     * @return     listado de prestamos externos 
     */
    public ArrayList<MaterialExterno> getSolicitudes()
    {
        return solicitudes;
    }
    
    /**
     * Método para retornar la colección
     * de préstamos externos
     * 
     * @return     listado de prestamos externos 
     */
    public ArrayList<Biblioteca> getBibliotecas()
    {
        return bibliotecas;
    }
    
    /**
     * Método para retornar la colección
     * de préstamos externos
     * 
     * @return     listado de prestamos externos 
     */
    public MaterialExterno buscarMatExternos(String matTitulo, String matAutor)
    {
        for (Biblioteca b : bibliotecas){
            if (b.getGestMat().buscarMaterialMulti(matTitulo, matAutor) != null){
                MaterialExterno matEncontrado = 
                new MaterialExterno(Biblioteca.getInstacia().getBibNombre(),b.getBibNombre(),matTitulo, matAutor);
                return matEncontrado;
            }
        }
        return null;
    }
    
    /**
     * Método para retornar la colección
     * de préstamos externos
     * 
     * @return     listado de prestamos externos 
     */
    public void printMatExterno(MaterialExterno matExterno)
    {
        System.out.println("-------------------------------------------");
        System.out.println("Biblioteca Origen: " + matExterno.getBiblioOrigen() +
        " | Biblioteca Destino: " + matExterno.getBiblioDestino()+ " | Título: " + matExterno.getMatTitulo() +
        " | Autor: " + matExterno.getMatAutor());
    }
    
     /**
     * Método para retornar la colección
     * de préstamos externos
     * 
     * @return     listado de prestamos externos 
     */
    public void añadirSolicitudes(MaterialExterno matExterno)
    {
        solicitudes.add(matExterno);      
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
    */ 
    public void exportarPrestamos(String ruta)
    {
        File archivo = new File(ruta);
        try{
            FileOutputStream fos = new FileOutputStream(archivo);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (MaterialExterno p : this.solicitudes){
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
            MaterialExterno me = leerArchivo(ois);
            while (me != null){
                Socio nuevoSocio = new Socio(me.getBiblioOrigen(), "", 
                String perApellidos, String perDireccion,String perUser, String perPassword);
                
                Biblioteca.getInstacia().añadirPrestamo(me.getMatPrestado(),pe.getSocioPrestamo());
                me = leerArchivo(ois);
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
    public MaterialExterno leerArchivo(ObjectInputStream ois)
    {
        MaterialExterno me;
        try {
            me = (MaterialExterno)ois.readObject();
        }
        catch (Exception e){
            me = null;
        }
        return me;    
    }
}
