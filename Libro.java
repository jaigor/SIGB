
/**
 * Write a description of class Libro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Libro extends Material
{
    String ISBN;
    String fechaEdicion;

    /**
     * Constructor for objects of class Libro
     */
    public Libro(String matNombre, String matAutor, int matStock, String lISBN, String lFecha)
    {
        super(matNombre, matAutor, matStock);
        ISBN = lISBN;
        fechaEdicion = lFecha;
    }

}
