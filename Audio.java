
/**
 * Esta clase representa al objeto 
 * Audio (o Disco de Audio).
 * Almacena y devuelve información 
 * relacionada con el mismo.
 * 
 * @author Igor Quintela 
 * @version 01/03/2016
 */
public class Audio extends Material
{
    // Definición de campos propios del Material
    private int numPistas;
    
    /**
     * Instaciación de campos propios y genéricos del Material
     * 
     * @param matTitulo     Nombre de la obra/item.
     * @param matAutor      Nombre del autor de la obra.
     * @param stockActual   Número de elementos que hay en base de datos.
     * @param matPrecio     Cantidad de euros que cuesta el elemento.
     * @param numPistas     Número total de pistas/canciones del disco.
     */
    public Audio(String matTitulo, String matAutor, int stockActual, double matPrecio, int numPistas)
    {
        super(matTitulo, matAutor, stockActual, matPrecio);
        this.numPistas = numPistas;
    }
    
    /**
     * Devuelve el número de pistas totales del Disco de audio
     * 
     * @return  número entero de las pistas 
     */
    public int getNumPistas()
    {
        return numPistas;
    }
    
    /**
     * Modifica el número de pistas totales del Disco de audio
     * 
     * @param  numPistas    String a modificar en el número de pistas
     */
    public void setNumPistas(int numPistas)
    {
        this.numPistas = numPistas;
    }
}
