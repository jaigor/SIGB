
/**
 * Esta clase representa al objeto Periodico.
 * Almacena y devuelve información relacionada con el mismo.
 * 
 * @author Igor Quintela 
 * @version 01/03/2016
 */
public class Periodico extends MaterialSuscripcion
{
    // Definición de campos propios del Material
    private int periodicidad = 1; //diario, o cada 1 dia
    
    /**
     * Instaciación de campos propios y genéricos del Material
     * 
     * @param matTitulo     Nombre de la obra/item.
     * @param matAutor      Nombre del autor de la obra.
     * @param stockActual      Número de elementos que hay en base de datos.
     * @param matPrecio     Cantidad de euros que cuesta el elemento.
     * @param tematica      Tematica del material suscribible.
     */
    public Periodico(String matTitulo, String matAutor, int stockActual, double matPrecio, String tematica)
    {
        super(matTitulo, matAutor, stockActual, matPrecio, tematica);
        setPeriodicidad(periodicidad);
    }
    
}
