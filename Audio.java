
/**
 * Write a description of class Audio here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
