
/**
 * Esta clase representa al objeto Libro.
 * Almacena y devuelve información relacionada con el mismo.
 * 
 * @author Igor Quintela 
 * @version 01/03/2016
 */
public class Libro extends Material
{
    // Definición de campos propios del Material
    private String isbn;
    private String fechaEdicion;
    private int numPaginas;

    /**
     * Instaciación de campos propios y genéricos del Material
     * 
     * @param matTitulo     Nombre de la obra/item.
     * @param matAutor      Nombre del autor de la obra.
     * @param stockActual      Número de elementos que hay en base de datos.
     * @param matPrecio     Cantidad de euros que cuesta el elemento.
     * @param isbn          ISBN del libro.
     * @param fechaEdicion  Última fecha de edición del libro.
     * @param numPaginas    Número total de páginas del libro.
     */
    public Libro(String matTitulo, String matAutor, int stockActual, double matPrecio, 
    String isbn, String fechaEdicion, int numPaginas)
    {
        super(matTitulo, matAutor, stockActual, matPrecio);
        this.isbn = isbn;
        this.fechaEdicion = fechaEdicion;
        this.numPaginas = numPaginas;
    }

    /**
     * Devuelve el ISBN del Libro
     * 
     * @return  String correspondiente al ISBN 
     */
    public String getISBN()
    {
        return isbn;
    }
    
    /**
     * Devuelve la fecha de edición del Libro
     * 
     * @return  String que tiene la Fecha de Edicion 
     */
    public String getFechaEdicion()
    {
        return fechaEdicion;
    }
    
    /**
     * Devuelve el número de páginas totales del Libro
     * 
     * @return  número entero de las páginas 
     */
    public int getNumPaginas()
    {
        return numPaginas;
    }
}
