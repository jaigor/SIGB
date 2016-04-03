
/**
 * Esta clase representa al objeto Video.
 * Almacena y devuelve información relacionada con el mismo.
 * 
 * @author Igor Quintela 
 * @version 01/03/2016
 */
public class Video extends Material
{
    private int duracion;
    
    /**
     * Constructor for objects of class Video
     */
    public Video(String matNombre, String matAutor, int matStock, float matPrecio, int durac)
    {
        super(matNombre, matAutor, matStock, matPrecio);
        duracion = durac;
    }

}
