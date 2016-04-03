
/**
 * Esta clase representa al objeto Audio.
 * Almacena y devuelve información relacionada con el mismo.
 * 
 * @author Igor Quintela 
 * @version 01/03/2016
 */
public class Audio extends Material
{
    private int numeroPistas;
    
    /**
     * Constructor for objects of class Audio
     */
    public Audio(String matTitulo, String matAutor, int matStock, float matPrecio, int numPistas)
    {
        super(matTitulo, matAutor, matStock, matPrecio);
        numeroPistas = numPistas;
    }

}
