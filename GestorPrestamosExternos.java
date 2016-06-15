import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;

/**
 * Write a description of class GestorPrestBiblio here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GestorPrestamosExternos extends GestorPrestamos
{

    /**
     * Constructor for objects of class GestorPrestamosExternos
     */
    public GestorPrestamosExternos()
    {
        // 
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    /*public void exportar(String ruta)
    {
        File archivo = new File(ruta);
        try{
            FileOutputStream fos = new FileOutputStream(archivo);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Prestamo p : this.prestamosInterb){
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
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    /*public void importar(String ruta)
    {
        File archivo = new File(ruta);
        try{
            FileOutputStream fos = new FileOutputStream(archivo);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Prestamo p : this.prestamosInterb){
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
    }*/
}
