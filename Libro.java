
/**
 * Esta clase representa al objeto Libro.
 * Almacena y devuelve información relacionada con el mismo.
 * 
 * @author Igor Quintela 
 * @version 01/03/2016
 */
public class Libro extends Material
{
    private String ISBN;
    private String fechaEdicion;
    private int numPaginas;

    /**
     * Constructor for objects of class Libro
     */
    public Libro(String matTitulo, String matAutor, int matStock, float matPrecio, 
    String lISBN, String lFecha, int numerPaginas)
    {
        super(matTitulo, matAutor, matStock, matPrecio);
        ISBN = lISBN;
        fechaEdicion = lFecha;
        numPaginas = numerPaginas;
    }

}
