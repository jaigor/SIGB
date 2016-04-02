
/**
 * Write a description of class Libro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Libro extends Material
{
    private String ISBN;
    private String fechaEdicion;

    /**
     * Constructor for objects of class Libro
     */
    public Libro(String matTitulo, String matAutor, int matStock, float matPrecio, 
    String lISBN, String lFecha)
    {
        super(matTitulo, matAutor, matStock, matPrecio);
        ISBN = lISBN;
        fechaEdicion = lFecha;
    }

}
